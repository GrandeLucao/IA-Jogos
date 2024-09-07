package ghosts;

import java.util.List;

import pacman.Game;
import pacman.GhostPlayer;
import pacman.Location;
import pacman.Move;
import pacman.State;
import util.*;


public class StalkingGhostPlayer implements States<GhostPlayer> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  public void Move(GhostPlayer ghost){
    
  }

  @Override
  public void Enter(GhostPlayer ghost) {

  }

  @Override
  public void Exit(GhostPlayer ghost) {

  }

  @Override
  public boolean onGetMessage(GhostPlayer npc, Messages message) {
    if(message.getStringMessage().compareTo("1quad")==0){
      return true;
  }else if(message.getStringMessage().compareTo("2quad")==0){
      return true;
  }else if(message.getStringMessage().compareTo("3quad")==0){
    return true;
  }else if(message.getStringMessage().compareTo("4quad")==0){
  return true;
  }else{return false;}
    }

}
