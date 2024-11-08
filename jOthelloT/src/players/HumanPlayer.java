package players;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import game.BoardSquare;
import game.Move;
import game.OthelloGame;

/**
 *
 * @author Lucas M. Oliveira
 */
public class HumanPlayer extends AbstractPlayer {

	@Override
	public BoardSquare play(int[][] tab) {
		BoardSquare casa = new BoardSquare();

		try (Scanner leitor = new Scanner(System.in)) {
			int i, j;

			System.out.println("Insira a linha");
			i = leitor.nextInt();
			System.out.println("Insira a coluna");
			j = leitor.nextInt();
			if (tab[i][j] == 0) {
				casa.getRow(i);
				casa.setCol(j);
			}
		}

		return casa;
	}

}
