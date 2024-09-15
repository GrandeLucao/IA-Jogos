package ghosts.Red;

import java.util.List;
import java.util.Random;

import ghosts.EntityManager;
import ghosts.MessageDispenser;
import ghosts.StateMachine;

import java.util.ArrayList;


import pacman.Game;
import pacman.GhostPlayer;
import pacman.Location;
import pacman.Move;
import pacman.State;
import util.Pair;
import util.Utils;

public class Red extends GhostPlayer{

    private StateMachine<Red> stateMach;
    private Random random = new Random();
    int dots;

    public Red() {
        super("red");
        stateMach=new StateMachine<Red>(this);
        stateMach.setCurrentState(StalkerState.getInstance());
        //dots=Game.getCurrentState().getDotLocations().size();
    }

    public Move chooseMove(Game game, int ghostIndex) {
         checkThings(game);
        if(stateMach.getCurrentState()==StalkerState.getInstance()){
          State state = game.getCurrentState();
          List<Move> moves = game.getLegalGhostMoves(ghostIndex);
          if (moves.isEmpty()) return null;
          double[] distances = new double[moves.size()];
          Location pacManLoc = state.getPacManLocation();
          for (int i=0; i<distances.length; i++) {
            Location newLoc = Game.getNextLocation(state.getGhostLocations().get(ghostIndex), moves.get(i));
            distances[i] = Location.euclideanDistance(pacManLoc, newLoc);
          }
          int moveIndex = Utils.argmin(distances); // the move that minimizes the distance to PacMan
          return moves.get(moveIndex);
        }else{
          List<Pair<Move, Double>> distribution = getMoveDistribution(game, game.getCurrentState(), ghostIndex);
          double dart = random.nextDouble();
          double sum = 0.0;
          try {
            for(Pair<Move, Double> pair : distribution) {
                sum += pair.second();
                if(sum >= dart) {
                  return pair.first();
                }
            }
            throw new RuntimeException("No move selected in" + this.getClass().getName() + " for 'dart'=" + dart);
          } catch(RuntimeException re) {}
          return null;
        }
      }

      public List<Pair<Move, Double>> getMoveDistribution(Game game, State state, int ghostIndex) {
        List<Pair<Move, Double>> distribution = new ArrayList<Pair<Move, Double>>();
        List<Move> legalMoves = Game.getLegalGhostMoves(state, ghostIndex);
        double uniformProb = 1.0 / (double)legalMoves.size();
        for(Move move : legalMoves) {
            distribution.add(new Pair<Move, Double>(move, uniformProb));
        }
        return distribution;
      }

      public void checkThings(Game game){
        //pega o quadrante
        if(game.getCurrentState().getPacManLocation().getX()>=12){
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("orange"), "2quad", null);
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("pink"), "", null);
        }
        if(game.getCurrentState().getPacManLocation().getX()<12){
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("pink"), "1quad", null);
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("orange"), "", null);
        }   
        
        //pega o tanto de tots remnescentes
        if(game.getCurrentState().getDotLocations().size()<123){
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("cyan"), "half", null);
        }else if(game.getCurrentState().getDotLocations().size()<98){
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("orange"), "40p", null);
        }else if(game.getCurrentState().getDotLocations().size()<74){
          MessageDispenser.getInstance().DispatchMessage(this, EntityManager.getInstance().getEntity("pink"), "30p", null);
        }
      }

    @Override
    public StateMachine<Red> getStateMachine() {
        return stateMach;        
    }

}
