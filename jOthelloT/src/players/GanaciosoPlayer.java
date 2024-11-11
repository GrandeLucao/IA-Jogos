package players;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import game.BoardSquare;
import game.HeuristicsEvaluator;
import game.Move;
import game.OthelloGame;
import game.SuperStratCheck;

public class GanaciosoPlayer extends AbstractPlayer{

    int depth=1;
    Double score;
    Random random=new Random();

    @Override
    public BoardSquare play(int[][] board) {
		OthelloGame game = new OthelloGame();
		List<Move> validMoves = game.getValidMoves(board, getMyBoardMark());
        Move newMove=getNextMoves(validMoves);
        return newMove.getBoardSquare();
        
    }

    Move getNextMoves(List<Move> validMoves){
        Move moveToSend=null;
        Double scoreToSend=0d;
        Map<Move, Double> movesScore=new HashMap<>();
        for(Move move:validMoves){
            Move stratMove=SuperStratCheck.superStrat(move);
            if(stratMove!=null){
                return stratMove;
            }
        }
        for(Move move:validMoves){
            if(!SuperStratCheck.superStrat2(move)){
                Double moveScore=ganacioso(move, depth);
                movesScore.put(move,moveScore);
            }
        }

        if(movesScore.isEmpty()){
            for(Move move:validMoves){
                Double moveScore=ganacioso(move, depth);
                movesScore.put(move,moveScore);                
            }

        }

        
        for(Map.Entry<Move, Double> entry:movesScore.entrySet()){
            if(moveToSend==null){
                moveToSend=entry.getKey();
                scoreToSend=entry.getValue();
            }
            if(entry.getValue()>scoreToSend){
                moveToSend=entry.getKey();
                scoreToSend=entry.getValue();
            }
        }
        return moveToSend;

    }
    double ganacioso(Move move, int depth){
        List<Move> nextMoves = getGame().getValidMoves(move.getBoard(), getMyBoardMark());
        if(depth==0){
            return evaluateMove(move);
        }else{
           double maxEval= Double.NEGATIVE_INFINITY;
            for(Move newMove:nextMoves){
                double eval=ganacioso(newMove, depth-1);
                maxEval=max(maxEval,eval);
            }
            return maxEval;
        }
    }

    Double evaluateMove(Move move){
        Double score=HeuristicsEvaluator.heuristic3(move,0);
        return score;
    }

    double max(double var1,double var2){
        if(var1>var2){return var1;}
        else{return var2;}
    }
}
