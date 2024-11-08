package players;

import java.util.List;
import java.util.Random;

import game.BoardSquare;
import game.Move;
import game.OthelloGame;

public class RandomPlayer extends AbstractPlayer {

	public BoardSquare play(int[][] board) {
		OthelloGame game = new OthelloGame();
		Random random = new Random();
		List<Move> validMoves = game.getValidMoves(board, getMyBoardMark());

		if (validMoves.size() > 0) {
			Move chosenMove = validMoves.get(random.nextInt(validMoves.size()));
			return chosenMove.getBoardSquare();
		} else {
			return new BoardSquare(-1, -1);
		}
	}
}
