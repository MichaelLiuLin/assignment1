package tictactoe;

/**
 * The two-player game of TicTacToe.
 *
 * The goal is to get three cells in a row.
 *
 * @author Mark Utting
 */
public class TicTacToe {
	private int[][] board = new int [3][3];
	/**
	 * Checks to see if a cell is already taken.
	 * @param row must be 0..2
	 * @param col must be 0..2
	 * @return true if cell (row,col) is already full.
	 */
//	board[0][0] > 0
	public boolean isTaken(int row, int col) {
//		if (board [row][col] > 0){
//			return true;
//		}else{
//			return false;
//		}
		return board[row][col] > 0;
	}

	/**
	 * Get a given cell.
	 *
	 * @return the contents of a given cell (0, 1 or 2).
	 */
	public int getCell(int row, int col) {
		return board[row][col];
	}

	/**
	 * Tells which player has won.
	 * If there is no winner yet, the result will be zero.
	 * If the game is over, but is a draw, the result is 3 (=2+1).
	 *
	 * @return 1 or 2, or 3 (draw), or 0 (no winner yet)
	 */
	public int winner() {
		if(getCell(0, 0) == 1 && getCell(1, 1) == 1 && getCell(2, 2) == 1){
			System.out.println("player1  win");
			return 1;
		}else if(getCell(0, 0) == 1 && getCell(0, 1) == 1 && getCell(0, 2) == 1){
			System.out.println("player1  win");
			return 1;
		}else if(getCell(0, 0) == 1 && getCell(1, 0) == 1 && getCell(2, 0) == 1){
			System.out.println("player1  win");
			return 1;
		}

		return 0;

	}

	/**
	 * Player 1 makes a move.
	 *
	 * The result is true if the requested move was valid,
	 * and in that case, the cell (row,col) will be filled.
	 * A valid move requires:
	 * <ul>
	 *   <li>the cell (row,col) was empty before the move;</li>
	 *   <li>it was this player's turn to play (either player can start);</li>
	 *   <li>the game was not already won.</li>
	 * </ul>
	 *
	 * The result is false if the move was invalid,
	 * and in that case the board will be left unchanged.
	 *
	 * @param row 0..2
	 * @param col 0..2
	 * @return true iff this was a valid move
	 */
	public  boolean move1( int row,  int col) {
		if (isTaken(row, col) == true){
			return false;
		}

		else{
			board[row][col] = 1;
			return true;
		}

	}

	/**
	 * Player 2 makes a move.
	 *
	 * The result is true if the requested move was valid,
	 * and in that case, the cell (row,col) will be filled.
	 * A valid move requires:
	 * <ul>
	 *   <li>the cell (row,col) was empty before the move;</li>
	 *   <li>it was this player's turn to play (either player can start);</li>
	 *   <li>the game was not already won.</li>
	 * </ul>
	 *
	 * The result is false if the move was invalid,
	 * and in that case the board will be left unchanged.
	 *
	 * @param row 0..2
	 * @param col 0..2
	 * @return true iff this was a valid move
	 */
	public boolean move2(int row, int col) {
//		if (isTaken(row, col) == true){
//			return false;
//		}
		if (isTaken(row, col) == true){
			return false;
		}

		else{
			board[row][col] = 2;
			return true;
		}
	}

	/**
	 * Returns three strings that display the current state of the game.
	 * Example:
	 * <pre>
	 *  row[0]: " 2 . 1 "
	 *  row[1]: " 2 1 . "
	 *  row[2]: " 1 . . "
	 * </pre>
	 * @return three strings, one per row.
	 */
	public String[] display() {
		String lines[] = new String[3];
		for (int row = 0; row < 3; row++) {
			// A StringBuilder is like a String, but with update methods.
			StringBuilder str = new StringBuilder();
			for (int col = 0; col < 3; col++) {
				int cell = getCell(row, col);
				if (cell == 0) {
					str.append(" .");
				} else {
					str.append(" " + cell);
				}
			}
			lines[row] = str.toString();
		}
		return lines;
	}

}
