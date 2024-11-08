package players;

import java.util.List;

import game.BoardSquare;
import game.Move;
import game.Game;
import game.OthelloGame;

/**
 *
 * @author Marcelo Paglione
 */
public class HumanPlayerDisplay extends AbstractPlayer {

	@Override
	public synchronized BoardSquare play(int[][] tab) {
		OthelloGame jogo = new OthelloGame();
		List<Move> jogadas = jogo.getValidMoves(tab, getMyBoardMark());
		BoardSquare casa = new BoardSquare(-1, -1);
		if (jogadas.size() > 0) {
			casa = Game.displayOtello.get();
			return casa;
		} else {
			return casa;
		}

	}

}
