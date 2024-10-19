package pacman;

import java.util.Collection;

/**
 * An interface for classes which can estimate the value of a state in a Pac-Man game.
 * @author grenager
 *
 */
public class StateEvaluator {
  
  /**
   * Computes an estimate of the value of the State.
   * @param s the State to evaluate.
   * @return an estimate of the value of the State.
   */
  public static double evaluateState1(State s, State next){
      if (Game.isLosing(next))
        return -1000.0; // really bad to get eaten
      if (Game.isWinning(next))
        return 0.0; // really good to win
      double score = 0.0;
      Location pacManLocation = next.getPacManLocation();
      score += getMinDistance(pacManLocation, s.getGhostLocations());
      return score;
  }

  public static double evaluateState2(State s, State next){
    if (Game.isLosing(next))
      return -1000.0; // really bad to get eaten
    if (Game.isWinning(next))
      return 0.0; // really good to win
    double score = 0.0;
    Location pacManLocation = next.getPacManLocation();
    score += getMinDistance(pacManLocation, s.getDotLocations()); 
    score+=getMinDistance(pacManLocation, s.getGhostLocations());
    return score;
}

public static double evaluateState3(State s, State next){
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

public static double evaluateState4(State s, State next){
  if (Game.isLosing(next))
    return -1000.0; // really bad to get eaten
  if (Game.isWinning(next))
    return 0.0; // really good to win
  double score = 0.0;
  Location pacManLocation = next.getPacManLocation();
  score += s.getDotLocations().size(); // more dots left on the board is bad
  score+= next.getDotLocations().size();
  score+=getMaxDistance(pacManLocation, s.getGhostLocations());
  System.out.println(score);
  return score;
}


  private static double getMaxDistance(Location sourceLocation, Collection<Location> targetLocations) {
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

  private static double getMinDistance(Location sourceLocation, Collection<Location> targetLocations) {
    double minDistance = Double.POSITIVE_INFINITY;
    for (Location dotLocation : targetLocations) {
      double distance = Location.manhattanDistance(sourceLocation, dotLocation); // one
                                                                                  // way
                                                                                  // to
                                                                                  // measure
                                                                                  // distance
      if (distance < minDistance) {
        minDistance = distance;
      }
    }
    if (Double.isInfinite(minDistance))
      throw new RuntimeException();
    return minDistance;
  }
}
