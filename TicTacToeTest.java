package tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This tests the TicTacToe class.
 *
 * @author Mark Utting
 */
public class TicTacToeTest {

	protected TicTacToe game;

	@Before
	public void setUp() {
		this.game = new TicTacToe();
	}

	@Test
	public void testEmpty() {
		// check that the four corners are empty
		assertFalse(this.game.isTaken(0, 0));
		assertFalse(this.game.isTaken(0, 2));
		assertFalse(this.game.isTaken(2, 0));
		assertFalse(this.game.isTaken(2, 2));
		assertEquals(0, this.game.winner());
	}

	@Test
	public void testFirstMove() {
		assertFalse(this.game.isTaken(1, 1));
		this.game.move1(1, 1);
		assertTrue(this.game.isTaken(1, 1));
	}

	/** A correct game where player 1 wins along a row. */
	@Test
	public void testWinner1Row() {
		assertEquals(0, this.game.winner());
		this.game.move1(0,0);
		this.game.move2(1,0);
		this.game.move1(0,1);
		this.game.move2(1,1);
		assertEquals(0, this.game.winner());
		this.game.move1(0,2);
		assertEquals(1, this.game.winner());
	}

	/** A correct game where player 2 wins down a column. */
	@Test
	public void testWinner2Col() {
		assertTrue(this.game.move2(2,1));
		assertTrue(this.game.move1(1,2));
		assertTrue(this.game.move2(0,1));
		assertTrue(this.game.move1(0,2));
		assertEquals(0, this.game.winner());
		assertTrue(this.game.move2(1,1));
		assertEquals(2, this.game.winner());
	}

	/** A correct game where player 1 wins along a diagonal. */
	@Test
	public void testWinner1Diag() {
		assertTrue(this.game.move1(0,2));
		assertTrue(this.game.move2(0,0));
		assertTrue(this.game.move1(1,1));
		assertTrue(this.game.move2(1,0));
		assertEquals(0, this.game.winner());
		assertTrue(this.game.move1(2,0));
		assertEquals(1, this.game.winner());
	}

	@Test
	public void testGetCell() {
		assertEquals(0, this.game.getCell(0, 0));
		assertEquals(0, this.game.getCell(1, 1));
		this.game.move2(0, 0);
		assertEquals(2, this.game.getCell(0, 0));
		this.game.move1(1, 1);
		assertEquals(1, this.game.getCell(1, 1));
	}

	@Test
	public void testDisplay() {
		this.game.move2(0, 0);
		this.game.move1(1, 1);
		this.game.move2(2, 0);
		this.game.move1(2, 2);
		// check the display of this game
		String[] strs = this.game.display();
		assertEquals(3, strs.length);
		assertEquals(" 2 . . ", strs[0]);
		assertEquals(" . 1 . ", strs[1]);
		assertEquals(" 2 . 1 ", strs[2]);
	}

	@Test
	public void testInvalidCells() {
		assertTrue(this.game.move2(0,2));
		assertFalse(this.game.move1(0,2)); // cell taken
		assertTrue(this.game.move1(0,1));
	}

	@Test
	public void testInvalidTurn1() {
		assertTrue(this.game.move1(0,0));
		assertFalse(this.game.move1(1,1)); // not his/her turn
		assertTrue(this.game.move2(1,1)); // but player 2 can move there
	}

	@Test
	public void testInvalidTurn2() {
		assertTrue(this.game.move2(0,0));
		assertTrue(this.game.move1(1,1));
		assertFalse(this.game.move1(2, 2)); // not his/her turn
		assertTrue(this.game.move2(2, 0));  // but player 2 can move
		assertFalse(this.game.move2(2, 2)); // another wrong turn
	}

	@Test
	public void testInvalidMoveGameOver() {
		assertTrue(this.game.move1(0, 2));
		assertTrue(this.game.move2(1, 1));
		assertTrue(this.game.move1(1, 2));
		assertTrue(this.game.move2(0, 1));
		assertTrue(this.game.move1(2, 2)); // player 1 wins
		assertFalse(this.game.move2(2, 1)); // game already won
	}

}
