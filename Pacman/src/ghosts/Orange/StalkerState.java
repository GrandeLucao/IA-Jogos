package ghosts.Orange;

import ghosts.Messages;
import ghosts.States;

public class StalkerState implements States<Orange> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  private static StalkerState instance=null;

  public void Move(Orange ghost){
    
  }

  @Override
  public void Enter(Orange ghost) {

  }

  @Override
  public void Exit(Orange ghost) {

  }

  @Override
  public boolean onGetMessage(Orange npc, Messages message) {
    if(message.getStringMessage().compareTo("2quad")!=0){
      npc.getStateMachine().changeState(RandomState.getInstance());
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
