package samples;

import java.util.*;

/**
 * Static methods for searching lists of moves.
 * @author William Clifford
 *  
 */
public final class TicTacToeMoveList {

	/**
	 * Checks to make sure that a move hasn't been made already
	 * @param list - the entire list of moves.
	 * @param move - the players desired move.
	 * @return
	 */
	public static boolean exists(List<TicTacToeMove> list, TicTacToeMove move) {
		boolean output = false;
		
		for(TicTacToeMove item : list) {
			if (item.getPointX() == move.getPointX() && item.getPointY() == move.getPointY()) {
				output = true;
				break;
			}
		}
		
		return output;
	}
	
	/**
	 * Returns all of the moves for the specified player.
	 * @param list - the entire list of moves.
	 * @param player - the player moves to return.
	 * @return - all of the moves associated with this player.
	 */
	public static List<TicTacToeMove> samePlayer(List<TicTacToeMove> list, String player) {
		ArrayList<TicTacToeMove> output = new ArrayList<TicTacToeMove>();
		
		for(TicTacToeMove item : list) {
			if (player.equals(item.getPlayer())) {
				output.add(item);
			}
		}
		
		return output;
	}
	
	/**
	 * Return all of the moves that are in the same column for the same player.
	 * @param list - the entire list of moves.
	 * @param item - look for moves that are in the same column as this move.
	 * @return - all moves that belong in the same column for the same player.
	 */
	public static List<TicTacToeMove> inSameColumn(List<TicTacToeMove> list, TicTacToeMove item) {
		ArrayList<TicTacToeMove> output = new ArrayList<TicTacToeMove>();
		
		for(TicTacToeMove listItem : list) {
			if (item.inSameColumn(listItem)) {
				output.add(listItem);
			}
		}
		
		return output;
	}

	/**
	 * Return all of the moves that are in the same row for the same player.
	 * @param list - the entire list of moves.
	 * @param item - look for moves that are in the same row as this move.
	 * @return - all moves that belong in the same row for the same player.
	 */
	public static List<TicTacToeMove> inSameRow(List<TicTacToeMove> list, TicTacToeMove item) {
		ArrayList<TicTacToeMove> output = new ArrayList<TicTacToeMove>();
		
		for(TicTacToeMove listItem : list) {
			if (item.inSameRow(listItem)) {
				output.add(listItem);
			}
		}
		
		return output;
	}

	/**
	 * Return all of the moves that are in the same diagonal for the sample player.
	 * @param list - the entire list of moves.
	 * @param item - look for moves that are in the same diagonal as this move.
	 * @return - all moves that belong in the same diagonal for the same player.
	 */
	public static List<TicTacToeMove> inDiagonal(List<TicTacToeMove> list, TicTacToeMove item) {
		ArrayList<TicTacToeMove> output = new ArrayList<TicTacToeMove>();
		
		for(TicTacToeMove listItem : list) {
			if (item.inDiagonal(listItem)) {
				output.add(listItem);
			}
		}
		
		return output;
	}
}