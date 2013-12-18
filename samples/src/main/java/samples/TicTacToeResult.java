package samples;

/**
 * Defines the result of a move.
 * @author William Clifford
 *
 */
public enum TicTacToeResult {
	/**
	 * The move resulted in a win!
	 */
	WIN,
	
	/**
	 * This is an invalid move.
	 */
	INVALID,
	
	/**
	 * Not a winning move, continue the game.
	 */
	CONTINUE,
	
	/**
	 * Game is over with a draw.
	 */
	DRAW
}
