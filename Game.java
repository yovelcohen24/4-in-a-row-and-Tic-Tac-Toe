package game; /*game package*/

//import Scanner library
import java.util.Scanner;

//define Game Class that extends from
//Board that have Player array, Scanner,
//constructor, method that check if
//the action is the winning action,
//method that do one play move, and
//method that activate the game
public class Game extends Board {
	protected Player[] players; /* define Player array */
	protected Scanner s; /* define Scanner */
	// define Game constructor

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		s = new Scanner(System.in);
	}

	// define method that check if
	// the action is the winning action
	protected boolean doesWin(int i, int j) {
		if (i != 0 || j != 0) {
			return false;
		}
		return true;
	}

	// define method that do one play move
	protected boolean onePlay(Player p) {
		int x, y; /* define integers for user choice */
		// ask for integers from user
		System.out.println(p.toString() + ": please enter x and y:");
		// receive the user choice
		x = s.nextInt();
		y = s.nextInt();
		// receive choices again and again
		// while the point is not empty yet
		while (set(x, y, p) != true) {
			// ask from the user for another choices
			System.out.println("There is a piece there already...");
			System.out.println(p.toString() + ": please enter x and y:");
			// receive the choices
			x = s.nextInt();
			y = s.nextInt();
		}
		// present the player
		System.out.println(super.toString());
		// return true if the player won
		// in that move and false if not
		if (doesWin(x, y)) {
			return true;
		}
		return false;
	}

	// define method that activate the game
	public Player play() {
		// continue play while the board
		// still have at least one empty
		// point in the board
		while (!(super.isFull())) {
			// if one of the players won the
			// game present it and return the player
			if (onePlay(players[0])) {
				System.out.println(players[0].toString() + " Won!");
				return players[0];
			}
			// if the board is full
			// go out from the loop
			if (super.isFull()) {
				break;
			}
			if (onePlay(players[1])) {
				System.out.println(players[1].toString() + " Won!");
				return players[1];
			}
		}
		// if there is no winner return null
		return null;
	}
}
