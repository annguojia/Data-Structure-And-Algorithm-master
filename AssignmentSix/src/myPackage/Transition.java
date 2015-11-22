package myPackage;

public class Transition {
	static char LEFT = 'l';
	static char RIGHT = 'r';
	char writeTapeC;
	char direction;
	int nextState;

	public Transition(char writeTapeC, char direction, int nextState) {
		this.writeTapeC = writeTapeC;
		this.direction = direction;
		this.nextState = nextState;
	}
}
