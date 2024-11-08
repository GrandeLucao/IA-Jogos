package ghosts.Cyan;
import ghosts.Messages;
import ghosts.States;

public class ScatterState implements States<Cyan>{

  private static ScatterState instance=null;

@Override
public void Enter(Cyan ghost) {
}

@Override
public void Move(Cyan ghost) {
}

@Override
public void Exit(Cyan ghost) {
}

@Override
public boolean onGetMessage(Cyan myOwner, Messages message) {
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
