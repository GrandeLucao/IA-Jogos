package ghosts.Pink;

import ghosts.Messages;
import ghosts.States;

public class RandomState implements States<Pink> {

    private static RandomState instance=null;

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
    if(message.getStringMessage().compareTo("1quad")==0){
      npc.getStateMachine().changeState(StalkerState.getInstance());
      return true;      
  }else{return false;}
    }

    public static RandomState getInstance(){
        if(instance==null){
            instance=new RandomState();
        }
        return instance;
    }

}
