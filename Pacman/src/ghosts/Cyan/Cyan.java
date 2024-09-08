package ghosts.Cyan;

import java.util.List;

import ghosts.StateMachine;
import pacman.Game;
import pacman.GhostPlayer;
import pacman.Location;
import pacman.Move;
import pacman.State;
import util.Utils;

public class Cyan extends GhostPlayer{

    private StateMachine<Cyan> stateMach;

    public Cyan() {
        super("cyan");
        stateMach=new StateMachine<Cyan>(this);
        stateMach.setCurrentState(IdleState.getInstance());
    }

    public Move chooseMove(Game game, int ghostIndex) { 
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
    }else {
      return null;
    }
    }

    @Override
    public StateMachine<Cyan> getStateMachine() {
        return stateMach;        
    }

}
