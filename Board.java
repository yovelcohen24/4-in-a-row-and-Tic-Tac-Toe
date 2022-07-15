package game; /*game package*/

//define Board Class that have Player
//array, n and m integer, constructor,
//method that set player into a specific
//point at the board, method that check
//if specific point at the board is empty,
//method that return player from specific
//point in the board, method that check
//if the board is full, method that present
//the board, method that return the
//largest line that is marked by specific
//mark in specific point, method that check
//length at specific direction(sequence of
//specific mark), method that if specific
//point is exist, and method that find the
//maximum between 4 integers
// and method that check if the point have the same mark 
public class Board {
	protected Player[][] board; /* the board */
	protected int n, m; /* the length of the board */
	// define Board constructor

	public Board(int n, int m) {
		board = new Player[n][m];
		this.n = n;
		this.m = m;
	}

	// define method that set player into
	// a specific point at the board
	protected boolean set(int i, int j, Player p) {
		// check if you can set
		if (isEmpty(i, j)) {
			board[i][j] = p;
			return true;
		}
		// return false if you can't
		return false;
	}

	// define method that check if
	// specific point in the board
	// is empty
	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null) {
			return true;
		}
		return false;
	}

	// define method that return a player
	// from specific point in the board
	public Player get(int i, int j) {
		return board[i][j];
	}

	// define method that check if the
	// board is full
	public boolean isFull() {
		int index1, index2;
		// check the board and return
		// false if you need
		for (index1 = 0; index1 < n; index1++) {
			for (index2 = 0; index2 < m; index2++) {
				if (isEmpty(index1, index2)) {
					return false;
				}
			}
		}
		return true;
	}

	// define method that present
	// all of the board
	public String toString() {
		int index1, index2;
		String str = "";
		// present the board itself
		for (index1 = 0; index1 < n; index1++) {
			for (index2 = 0; index2 < m; index2++) {
				// check if the point is not
				// marked and print '.' if need
				if (isEmpty(index1, index2)) {
					str += ".";
				}
				// print the mark in the point
				else {
					str += board[index1][index2].getMark();
				}
			}
			str += '\n'; /* go down one line */
		}
		return str;
	}

	// define method that return the
	// largest line that is marked by
	// specific mark in specific point
	protected int maxLineContaining(int i, int j) {
		// define integer variables for
		// all of 8 directions
		int right, left, up, down;
		int right_up, left_up, right_down, left_down;
		// calculate the length for each direction
		right = rayLength(i, j, 0, 1);
		left = rayLength(i, j, 0, -1);
		up = rayLength(i, j, -1, 0);
		down = rayLength(i, j, 1, 0);
		right_up = rayLength(i, j, -1, 1);
		left_up = rayLength(i, j, -1, -1);
		right_down = rayLength(i, j, 1, 1);
		left_down = rayLength(i, j, 1, -1);
		// find the maximum between the line-length
		// (add 1 for the player itself)
		return MaximumOfFour((right + left) + 1, (up + down) + 1, (right_up + left_down) + 1,
				(left_up + right_down) + 1);
	}

	// define method that check length
	// at specific direction(sequence of
	// specific mark)
	private int rayLength(int x, int y, int dx, int dy) {
		// define and initialize the indexes
		// for checking and the counter
		int cnt = 0, index1 = x + dx, index2 = y + dy;
		// find the player(for the mark)
		Player p = board[x][y];
		// do the search on the board
		// and count the length
		while (isExist(index1, index2)) {
			// check if the point have the
			// same mark and proceed the
			// counter if you need
			if (theSameMark(p,(board[index1][index2]))) {
				cnt++;
			}
			// return the counter if
			// the sequence over
			else {
				return cnt;
			}
			// proceed the indexes
			// according to the direction
			index1 += dx;
			index2 += dy;
		}
		return cnt;
	}

	// define method that check if
	// the point is exist on the board
	// and return boolean value
	// according to the results
	private boolean isExist(int index0, int index1) {
		if (index0 >= 0 && index0 < n && index1 >= 0 && index1 < m) {
			return true;
		}
		return false;
	}

	// define method that find the maximum value
	// between 4 integers
	private int MaximumOfFour(int len1, int len2, int len3, int len4) {
		int max1, max2;
		// compare between the
		// first and the second
		// integers
		if (len1 > len2) {
			max1 = len1;
		} else {
			max1 = len2;
		}
		// compare between the
		// third and the fourth
		// integers
		if (len3 > len4) {
			max2 = len3;
		} else {
			max2 = len4;
		}
		// compare the maximums
		// and return the result
		if (max1 > max2) {
			return max1;
		}
		return max2;
	}
	// define method that check if the point have the same mark 
	private boolean theSameMark(Player p1, Player p2) {
		if  (p1==null || p2==null) {return p1==p2;}
		else {	return p1.getMark()==p2.getMark();}
		
	}
		
}