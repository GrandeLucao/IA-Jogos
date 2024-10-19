package player;

import java.util.List;
import java.util.Random;

import util.*;
import pacman.*;

public class Equipe22BuscaGanaciosa implements PacManPlayer{

    static Random random = new Random();
    private Move lastMove = null;

    @Override
    public Move chooseMove(Game game) {
        State s=game.getCurrentState();
        List<Move> legalMoves=game.getLegalPacManMoves();
        Counter<Move> scores=new Counter<Move>();

        for(Move m:legalMoves){
            //search method
        }

        scores=scores.exp().normalize();
        Move move=scores.sampleFromDistribution(random);

        lastMove=move;
        return move;    
    }

}
