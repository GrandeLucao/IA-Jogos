package ghosts.Orange;

import ghosts.EntityManager;
import ghosts.Messages;
import ghosts.States;

public class IdleState implements States<Orange> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  private static IdleState instance=null;

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
    if(message.getStringMessage().compareTo("scatter")==0){
        npc.getStateMachine().changeState(ScatterState.getInstance());
        return true;
  }else if(message.getStringMessage().compareTo("chase")==0){
      npc.getStateMachine().changeState(StalkerState.getInstance());
      return true;
}else{return false;}
    }

    public static IdleState getInstance(){
        if(instance==null){
            instance=new IdleState();
        }
        return instance;
    }

}
