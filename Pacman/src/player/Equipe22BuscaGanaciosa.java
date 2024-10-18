package player;

import pacman.Game;
import pacman.Move;
import pacman.PacManPlayer;

public class Equipe22BuscaGanaciosa implements PacManPlayer{

    @Override
    public Move chooseMove(Game game) {
        
        return Move.UP;
    }

}
