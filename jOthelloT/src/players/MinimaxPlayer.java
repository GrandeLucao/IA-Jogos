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

public class MinimaxPlayer extends AbstractPlayer{
    int depth=3;
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
                Double moveScore=minimax(move, depth, Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY, true);
                movesScore.put(move,moveScore);
            }
        }
        if(movesScore.isEmpty()){
            for(Move move:validMoves){
                Double moveScore=minimax(move, depth, Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY, true);
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

    double minimax(Move move, int depth, double alpha,double beta,boolean isMax){
        List<Move> nextMoves = getGame().getValidMoves(move.getBoard(), getMyBoardMark());
        if(depth==0){
            return evaluateMove(move);
        }

        if(isMax){
           double maxEval= Double.NEGATIVE_INFINITY;
            for(Move newMove:nextMoves){
                double eval=minimax(newMove, depth-1, alpha, beta, false);
                maxEval=max(maxEval,eval);
                alpha=max(alpha,eval);
                if(beta<=alpha){break;}
            }
            return maxEval;
        }
        else{
            double minEval=Double.POSITIVE_INFINITY;
            for(Move newMove:nextMoves){
                double eval=minimax(newMove, depth-1, alpha, beta, true);
                minEval=min(minEval,eval);
                beta=min(beta,eval);
                if(beta<= alpha){break;}
            }
            return minEval;
        }
    }

    Double evaluateMove(Move move){
        Double score=HeuristicsEvaluator.heuristic3(move,1);
        return score;
    }

    double max(double var1,double var2){
        if(var1>var2){return var1;}
        else{return var2;}
    }

    double min(double var1,double var2){
        if(var1<var2){return var1;}
        else{return var2;}
    }

}
