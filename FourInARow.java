package game; /*game package*/

//define FourInRow Class that extends
//from Game and have constructor, method
//that return if the move is a winning
//move, method for one play(move), and method
//that check if specific column is full
public class FourInARow extends Game {
	// define FourInRow constructor using
	// player constructor
	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	@Override
	// define method that return if
	// the move is a winning move
	protected boolean doesWin(int i, int j) {
		// use maxLineContaining method
		if (super.maxLineContaining(i, j) <4) {
			return false;
		}
		return true;
	}

	// define method for one play(move)
	protected boolean onePlay(Player p) {
		int x, k; /* define index and user choice integers */
		// ask from the user for column index
		System.out.println(p.toString() + ": please enter column:");
		x = s.nextInt(); /* receive the index */
		// while the user choose full column
		// continue ask from him for another
		// index of column
		while (colisFull(x)) {
			// ask for another index of column
			System.out.println(p.toString() + ":the column is full, please enter column again:");
			x = s.nextInt(); /* receive the index */
		}
		// put the user choice according
		// to his index choice and the space
		// that is still empty in the column
		for (k = (n - 1); k > -1; k--) {
			// check if the space is
			// still empty for insert
			if (super.isEmpty(k, x)) {
				// insert the choice
				// and get out from
				// the loop
				super.set(k, x, p);
				break;
			}
		}
		// present the next player
		System.out.println(super.toString());
		// check if the move is
		// a winning move and
		// return boolean value
		// according the result
		if (doesWin(k, x)) {
			return true;
		}
		return false;
	}

	// define method that check
	// if the column is full
	private boolean colisFull(int i) {
		if (super.isEmpty(0, i)) {
			return false;
		}
		return true;
	}
}


