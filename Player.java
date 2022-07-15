package game; /*game package*/

//define Player Class that have name,
//mark, method that return the name,
//method that return the mark,
//method that present the player,
//and constructor
public class Player {
	private String name; /* player name */
	private char mark; /* player mark */
	// Player constructor

	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	// define method return
	// the name of the player
	public String getName() {
		return name;
	}

	// define method that return
	// the mark of the player
	public char getMark() {
		return mark;
	}

	// define method that present the player
	public String toString() {
		return name + "(" + mark + ")";
	}
}