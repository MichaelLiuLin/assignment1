package tictactoe;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is a simple text-based user interface for playing TicTacToe.
 *
 * @author Mark Utting
 */
public class TextUI {
	private Scanner in;
	private PrintStream out;

	/**
	 * Creates a textual user interface for playing TicTacToe.
	 *
	 * @param input
	 *            where to read the user commands from
	 * @param output
	 *            where to display the game output
	 */
	public TextUI(Scanner input, PrintStream output) {
		this.in = input;
		this.out = output;
	}

	/**
	 * A simple text-based user interface for playing the game.
	 * 
	 * Note: this uses exception handling to catch errors in the user
	 * input, so that the game is more robust.
	 *
	 * Limitations: player 1 always starts first.
	 */
	public void playTextGame(TicTacToe game) {
		int player = 1;
		System.out.println("Welcome to TicTacToe for two players.");
		System.out.println("The goal is to get 3 cells in a line.");
		while (game.winner() == 0) {
			System.out.println();
			String[] rows = game.display();
			for (String r : rows) {
				System.out.println(r);
			}
			boolean good = false;
			int row = 0;
			int col = 0;
			try {
				out.printf("Player %d's turn...\n", player);
				out.printf("     row (1..3)? ");
				row = in.nextInt();
				out.printf("  column (1..3)? ");
				col = in.nextInt();
				if (1 <= row && row <= 3 && 1 <= col && col <= 3) {
					good = true;
				}
			} catch (InputMismatchException ex) {
				good = false;
				in.nextLine(); // skip the bad input
			} catch (NoSuchElementException ex) {
				good = false;
			}
			if (good) {
				// System.out.printf("Good input. Trying move%d(%d,%d)\n", player, row - 1, col - 1);
				if (player == 1) {
					good = game.move1(row - 1, col - 1);
				} else {
					good = game.move2(row - 1, col - 1);
				}
			}
			if (good) {
				player = (player % 2) + 1; // move to the other player
			} else {
				out.println("Bad move, try again...");
			}
		}
		out.printf("\nWinner was player %d!\n", game.winner());
	}

	/**
	 * Plays a single game of TicTacToe, using a textual user interface.
	 *
	 * @param args ignored.
	 */
	public static void main(String[] args) {
		TextUI ui = new TextUI(new Scanner(System.in), System.out);
		TicTacToe game = new TicTacToe();
		ui.playTextGame(game);
	}
}
