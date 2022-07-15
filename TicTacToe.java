package game; /*game package*/

//define TicTacToe Class that extends from
//Game and have constructor and method
//that check if the move is winning move
public class TicTacToe extends Game {
	// define TicTacToe constructor
	// using Player constructor
	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}

	@Override
	// define method that check
	// if the move is winning move
	// and return boolean value
	// according to the result
	protected boolean doesWin(int x, int y) {
		// use maxLineContaining method
		if (super.maxLineContaining(x, y) != 3) {
			return false;
		}
		return true;
	}
}
