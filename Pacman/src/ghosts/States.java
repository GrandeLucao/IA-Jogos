package ghosts;

import pacman.Game;
import pacman.Move;

public interface States<GhostPlayer>{
    public void Enter(GhostPlayer ghost);
    public void Move(GhostPlayer ghost);
    public void Exit ( GhostPlayer ghost);
    public boolean onGetMessage(GhostPlayer myOwner, Messages message);  

}
