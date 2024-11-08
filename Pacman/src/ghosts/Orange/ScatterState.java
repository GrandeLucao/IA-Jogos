package ghosts.Orange;
import ghosts.Messages;
import ghosts.States;

public class ScatterState implements States<Orange>{

  private static ScatterState instance=null;

@Override
public void Enter(Orange ghost) {
}

@Override
public void Move(Orange ghost) {
}

@Override
public void Exit(Orange ghost) {
}

@Override
public boolean onGetMessage(Orange myOwner, Messages message) {
    if(message.getStringMessage().compareTo("chase")==0){
        myOwner.getStateMachine().changeState(StalkerState.getInstance());
        return true;
    }else{return false;}
  }

public static ScatterState getInstance(){
    if(instance==null){
        instance=new ScatterState();
    }
    return instance;
}

}
