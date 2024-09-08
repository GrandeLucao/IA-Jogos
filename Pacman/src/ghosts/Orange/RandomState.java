package ghosts.Orange;

import ghosts.Messages;
import ghosts.States;

public class RandomState implements States<Orange> {

    private static RandomState instance=null;

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
    if(message.getStringMessage().compareTo("2quad")==0){
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
