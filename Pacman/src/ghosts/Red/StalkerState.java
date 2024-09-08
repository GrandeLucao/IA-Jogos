package ghosts.Red;

import ghosts.Messages;
import ghosts.States;

public class StalkerState implements States<Red> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  private static StalkerState instance=null;

  public void Move(Red ghost){
    
  }

  @Override
  public void Enter(Red ghost) {

  }

  @Override
  public void Exit(Red ghost) {

  }

  @Override
  public boolean onGetMessage(Red npc, Messages message) {
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

    public static StalkerState getInstance(){
        if(instance==null){
            instance=new StalkerState();
        }
        return instance;
    }

}
