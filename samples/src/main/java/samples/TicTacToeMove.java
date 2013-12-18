package samples;

/**
 * Defines a move on a tic tac toe board.
 * @author William Clifford
 *
 */
public class TicTacToeMove {
	private int pointX;
	private int pointY;
	private String player;
	private int boardSize;
	
	/**
	 * Return the X axis point for this move.
	 * @return
	 */
	public int getPointX() {
		return pointX;
	}
	
	/**
	 * Return the Y axis point for this move.
	 * @return
	 */
	public int getPointY() {
		return pointY;
	}

	/**
	 * Return the player who made the move.
	 * @return
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * Constructor.
	 * @param boardSize - the dimensions of the tic tac toe board (ex. 3 would mean a 3 by 3 board)
	 * @param x - the x axis point for the move
	 * @param y - the y axis point for the move
	 * @param player - the player who made the move
	 */
	public TicTacToeMove(int boardSize, int x, int y, String player) {
		this.boardSize = boardSize;
		this.pointX = x;
		this.pointY = y;
		this.player = player;
	}
	
	/**
	 * Is the provided point in the same row as this point?
	 * @param point - the point to compare to
	 * @return
	 */
	public boolean inSameRow(TicTacToeMove point) {
		if (this.player.equals(point.getPlayer())) {
			if (this.pointX - point.getPointX() == 0) { 
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Is this provided point in the same column as this point?
	 * @param point - the point to compare to
	 * @return
	 */
	public boolean inSameColumn(TicTacToeMove point) {
		if (this.player.equals(point.getPlayer())) {
			if (this.pointY - point.getPointY() == 0) { 
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Is this point a diagonal move?
	 * @return
	 */
	public boolean isDiagonal() {
		if (this.pointX == this.pointY) {
			return true;
		} else if (this.boardSize - (this.pointX - 1) == this.pointY) {
			// 4 - (1 - 1) = 4 
			// 4 - (2 - 1) = 3
			// 4 - (3 - 1) = 2
			// 4 - (4 - 1) = 1
			return true;
		} else if (this.boardSize - (this.pointY - 1) == this.pointX) {
			// 4 - (4 - 1) = 1 
			// 4 - (3 - 1) = 2
			// 4 - (2 - 1) = 3
			// 4 - (1 - 1) = 4
			return true;
		}
		
		return false;
	}
	
	/**
	 * Is this provided point diagonal to this point?
	 * @param point - the point to compare to
	 * @return
	 */
	public boolean inDiagonal(TicTacToeMove point) {
		if (this.player.equals(point.getPlayer())) {
			if (this.isDiagonal() && point.isDiagonal()) {
				return true;
			}
		}
		
		return false;
	}
}