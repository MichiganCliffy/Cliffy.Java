package samples;

import java.io.Console;

public class TicTacToe {

	public static void main(String[] args) {
		Console console = System.console();
		TicTacToeBoard board = new TicTacToeBoard(3);
		boolean isFirstPlayer = true;
		
		String move = console.readLine("Move:");
	}
}
