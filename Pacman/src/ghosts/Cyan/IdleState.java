package ghosts.Cyan;

import ghosts.Messages;
import ghosts.States;

public class IdleState implements States<Cyan> {
  
  /**
   * Chooses a move deterministically based on the last State in the history.
   * Tries to come after Pac-Man, using straightline distance.
   * This means that this ghost can reverse direction.
   */

  private static IdleState instance=null;

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
    if(message.getStringMessage().compareTo("half")==0){
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
