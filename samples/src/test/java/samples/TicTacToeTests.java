package samples;

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTests {
	@Test
	public void inSameRowTest() {
		TicTacToeMove a = new TicTacToeMove(3, 1, 1, "A");
		TicTacToeMove b = new TicTacToeMove(3, 1, 2, "A");
		TicTacToeMove c = new TicTacToeMove(3, 1, 3, "A");
		TicTacToeMove d = new TicTacToeMove(3, 2, 1, "A");
		TicTacToeMove e = new TicTacToeMove(3, 2, 2, "B");
		
		assertTrue(a.inSameRow(b));
		assertTrue(a.inSameRow(c));
		assertFalse(a.inSameRow(d));
		assertTrue(b.inSameRow(a));
		assertTrue(b.inSameRow(c));
		assertFalse(b.inSameRow(e));
		assertFalse(d.inSameRow(e));
	}

	@Test
	public void inSameColumnTest() {
		TicTacToeMove a = new TicTacToeMove(3, 1, 1, "A");
		TicTacToeMove b = new TicTacToeMove(3, 1, 2, "A");
		TicTacToeMove c = new TicTacToeMove(3, 2, 1, "A");
		TicTacToeMove d = new TicTacToeMove(3, 2, 2, "B");
		TicTacToeMove e = new TicTacToeMove(3, 3, 1, "A");
		
		assertTrue(a.inSameColumn(c));
		assertTrue(a.inSameColumn(e));
		assertFalse(a.inSameColumn(d));
		assertTrue(e.inSameColumn(a));
		assertTrue(c.inSameColumn(a));
		assertFalse(b.inSameColumn(d));
	}
	
	@Test
	public void inDiagonalTest() {
		TicTacToeMove a = new TicTacToeMove(4, 1, 4, "A");
		TicTacToeMove b = new TicTacToeMove(4, 2, 3, "A");
		TicTacToeMove c = new TicTacToeMove(4, 3, 2, "A");
		TicTacToeMove d = new TicTacToeMove(4, 4, 1, "A");
		
		assertTrue(a.inDiagonal(b));
		assertTrue(a.inDiagonal(c));
		assertTrue(a.inDiagonal(d));
		assertTrue(b.inDiagonal(a));
		assertTrue(b.inDiagonal(c));
		assertTrue(b.inDiagonal(d));
		assertTrue(c.inDiagonal(a));
		assertTrue(c.inDiagonal(b));
		assertTrue(c.inDiagonal(d));
		assertTrue(d.inDiagonal(a));
		assertTrue(d.inDiagonal(b));
		assertTrue(d.inDiagonal(c));
	}
	
	@Test
	public void simpleGame() {
		TicTacToeBoard game = new TicTacToeBoard(3);

		//  | X |   |   |
		//  |   |   |   |
		//  |   |   |   |
		assertSame(game.addMove(1, 1, "X"), TicTacToeResult.CONTINUE);

		//  | X | Y |   |
		//  |   |   |   |
		//  |   |   |   |
		assertSame(game.addMove(1, 2, "Y"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  |   |   |   |
		//  |   |   |   |
		assertSame(game.addMove(1, 3, "X"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  |   | Y |   |
		//  |   |   |   |
		assertSame(game.addMove(2, 2, "Y"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  |   | Y |   |
		//  |   | X |   |
		assertSame(game.addMove(3, 2, "X"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  |   | Y |   |
		//  |   | X | Y |
		assertSame(game.addMove(3, 3, "Y"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  | X | Y |   |
		//  |   | X | Y |
		assertSame(game.addMove(2, 1, "X"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  | X | Y | Y |
		//  |   | X | Y |
		assertSame(game.addMove(2, 3, "Y"), TicTacToeResult.CONTINUE);

		//  | X | Y | X |
		//  | X | Y | Y |
		//  | X | X | Y |
		assertSame(game.addMove(3, 1, "X"), TicTacToeResult.WIN);
	}
	
	@Test
	public void diagonalGame() {
		TicTacToeBoard game = new TicTacToeBoard(4);
		
		//  |   |   |   | X |
		//  |   |   |   |   |
		//  |   |   |   |   |
		//  |   |   |   |   |
		assertSame(game.addMove(1, 4, "X"), TicTacToeResult.CONTINUE);
		
		//  |   | Y |   | X |
		//  |   |   |   |   |
		//  |   |   |   |   |
		//  |   |   |   |   |
		assertSame(game.addMove(1, 2, "Y"), TicTacToeResult.CONTINUE);
		
		//  |   | Y |   | X |
		//  |   |   | X |   |
		//  |   |   |   |   |
		//  |   |   |   |   |
		assertSame(game.addMove(2, 3, "X"), TicTacToeResult.CONTINUE);

		//  |   | Y |   | X |
		//  |   | Y | X |   |
		//  |   |   |   |   |
		//  |   |   |   |   |
		assertSame(game.addMove(2, 2, "Y"), TicTacToeResult.CONTINUE);

		//  |   | Y |   | X |
		//  |   | Y | X |   |
		//  |   | X |   |   |
		//  |   |   |   |   |
		assertSame(game.addMove(3, 2, "X"), TicTacToeResult.CONTINUE);

		//  | Y | Y |   | X |
		//  |   | Y | X |   |
		//  |   | X |   |   |
		//  |   |   |   |   |
		assertSame(game.addMove(1, 1, "Y"), TicTacToeResult.CONTINUE);
		
		//  | Y | Y |   | X |
		//  |   | Y | X |   |
		//  |   | X |   |   |
		//  | X |   |   |   |
		assertSame(game.addMove(4, 1, "X"), TicTacToeResult.WIN);
	}
}