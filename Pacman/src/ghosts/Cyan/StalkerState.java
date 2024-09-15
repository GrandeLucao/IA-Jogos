package ghosts.Cyan;

import ghosts.Messages;
import ghosts.States;
import pacman.Game;


public class StalkerState implements States<Cyan> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  private static StalkerState instance=null;

  public void Move(Cyan ghost){
    
  }

  @Override
  public void Enter(Cyan ghost) {

  }

  @Override
  public void Exit(Cyan ghost) {

  }

  @Override
  public boolean onGetMessage(Cyan npc, Messages message) {
    if(message.getStringMessage().compareTo("")==0){
      return true;
  }else{return false;}
    }

    public static StalkerState getInstance(){
        if(instance==null){
            instance=new StalkerState();
        }
        return instance;
    }

}
