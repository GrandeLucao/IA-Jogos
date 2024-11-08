package ghosts.Pink;
import ghosts.Messages;
import ghosts.States;

public class ScatterState implements States<Pink>{

  private static ScatterState instance=null;

@Override
public void Enter(Pink ghost) {
}

@Override
public void Move(Pink ghost) {
}

@Override
public void Exit(Pink ghost) {
}

@Override
public boolean onGetMessage(Pink myOwner, Messages message) {
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
