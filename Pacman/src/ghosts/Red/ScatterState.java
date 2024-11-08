package ghosts.Red;
import ghosts.Messages;
import ghosts.States;

public class ScatterState implements States<Red>{

  private static ScatterState instance=null;

@Override
public void Enter(Red ghost) {
}

@Override
public void Move(Red ghost) {
}

@Override
public void Exit(Red ghost) {
}

@Override
public boolean onGetMessage(Red myOwner, Messages message) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'onGetMessage'");
}

public static ScatterState getInstance(){
    if(instance==null){
        instance=new ScatterState();
    }
    return instance;
}

}
