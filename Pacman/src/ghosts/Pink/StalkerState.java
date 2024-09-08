package ghosts.Pink;

import ghosts.Messages;
import ghosts.States;


public class StalkerState implements States<Pink> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  private static StalkerState instance=null;

  public void Move(Pink ghost){
    
  }

  @Override
  public void Enter(Pink ghost) {

  }

  @Override
  public void Exit(Pink ghost) {

  }

  @Override
  public boolean onGetMessage(Pink npc, Messages message) {
    if(message.getStringMessage().compareTo("1quad")!=0){
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
