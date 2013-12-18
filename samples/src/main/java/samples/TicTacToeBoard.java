package samples;

import java.util.*;

public class TicTacToeBoard {
	private ArrayList<TicTacToeMove> moves;
	private int boardSize;
	
	public TicTacToeBoard(int boardSize) {
		moves = new ArrayList<TicTacToeMove>();
		this.boardSize = boardSize;
	}

	public TicTacToeResult addMove(int x, int y, String player) {
		TicTacToeMove move = new TicTacToeMove(boardSize, x, y, player);

		if (!TicTacToeMoveList.exists(moves, move)) {
			moves.add(move);
			
			List<TicTacToeMove> playerMoves = TicTacToeMoveList.samePlayer(moves, move.getPlayer());
			if (move.isDiagonal()) {
				if (TicTacToeMoveList.inDiagonal(playerMoves, move).size() == this.boardSize) {
					return TicTacToeResult.WIN;
				}
			} else {
				if (TicTacToeMoveList.inSameRow(playerMoves, move).size() == this.boardSize) {
					return TicTacToeResult.WIN;
				}
				
				if (TicTacToeMoveList.inSameColumn(playerMoves, move).size() == this.boardSize) {
					return TicTacToeResult.WIN;
				}
			}
			
			if (moves.size() == boardSize * boardSize) {
				// there is are more ways to get a draw, for simplicity sake we'll make the players fill up the board
				return TicTacToeResult.DRAW;
			}
			
			return TicTacToeResult.CONTINUE;
		}
		
		return TicTacToeResult.INVALID;
	}
}