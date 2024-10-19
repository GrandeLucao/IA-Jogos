package player;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import util.*;
import pacman.*;

public class Equipe22BuscaGanaciosa implements PacManPlayer{

    static Random random = new Random();
    private Move lastMove = null;

    @Override
    public Move chooseMove(Game game) {
        State s=game.getCurrentState();
        List<Move> legalMoves=game.getLegalPacManMoves();
        Counter<Move> scores=new Counter<Move>();

        for(Move m:legalMoves){            
            List<State> stateList = Game.getProjectedStates(s, m); 
            State last = stateList.get(stateList.size() - 1);
            double stateScore = evaluateState(s, last);
            double turnaroundPenalty = (lastMove == m.getOpposite() ? -10.0 : 0.0);
            scores.setCount(m, stateScore + turnaroundPenalty); 
            
        }

        scores=scores.exp().normalize();
        Move move=scores.argmax();

        lastMove=move;
        return move;    
    }

    public double evaluateState(State s, State next) {
        if (Game.isLosing(next))
          return -1000.0; // really bad to get eaten
        if (Game.isWinning(next))
          return 0.0; // really good to win
        double score = 0.0;
        Location pacManLocation = next.getPacManLocation();
        score -= s.getDotLocations().size(); // more dots left on the board is bad
        score += getMaxDistance(pacManLocation, s.getDotLocations()); 
        return score;
      }

       /**
   * Returns the distance from the source location to the closest of the target
   * locations.
   * 
   * @param sourceLocation
   * @param targetLocations
   * @return
   */
  private double getMaxDistance(Location sourceLocation, Collection<Location> targetLocations) {
    double maxDistance = Double.NEGATIVE_INFINITY;
    for (Location dotLocation : targetLocations) {
      double distance = Location.euclideanDistance(sourceLocation, dotLocation); // one
                                                                                  // way
                                                                                  // to
                                                                                  // measure
                                                                                  // distance
      if (distance > maxDistance) {
        maxDistance = distance;
      }
    }
    if (Double.isInfinite(maxDistance))
      throw new RuntimeException();
    return maxDistance;
  }

}
