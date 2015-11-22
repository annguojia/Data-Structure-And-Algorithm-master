package myPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turing {
	int max_len = 100;
	char[] tape = new char[max_len];

	Map<Character, Object> rules = new HashMap<Character, Object>();
	ArrayList<HashMap<Character, Transition>> listOfMaps = new ArrayList<HashMap<Character, Transition>>();
	int numberOfStates;

	int header = max_len - 1;
	int currentState = 0;

	/**
	 * create an array of hashMap to store transition matrix
	 * @pre machine has listOfMaps field
	 * @post an array of hashMap is created
	 * @param n
	 * @return
	 */
	public Turing(int n) {
		this.numberOfStates = n;
		for (int i = 0; i < n; i++) {
			listOfMaps.add(new HashMap<Character, Transition>());
		}
	}

	/**
	 * initialize an array of hashMap to store transition matrix
	 * @pre machine has listOfMaps field
	 * @post an array of hashMap is initialized
	 * @param int state, char symbol, Transition t
	 * @return
	 */
	public void addTransition(int state, char symbol, Transition t) {
		listOfMaps.get(state).put(symbol, t);
	}

	/**
	 * execute turing machine until it enters halt state
	 * @pre machine has listOfMaps, tape and header field
	 * @post tape is updated after execution
	 * @param 
	 * @return
	 */
	public void execute() {
		header = 99;
		currentState = 0;
		do {
			char temp = tape[header];
			tape[header] = listOfMaps.get(currentState).get(tape[header]).writeTapeC;
			switch (listOfMaps.get(currentState).get(temp).direction) {
			case 'l':
				header--;
				break;
			case 'r':
				header++;
				break;
			}
			currentState = listOfMaps.get(currentState).get(temp).nextState;
		} while (currentState != 2);

	}

	/**
	 * check if we get enough binary numbers
	 * @pre machine has tape field and is not empty
	 * @post whether we should continue computing is returned as a boolean
	 * @param 
	 * @return
	 */
	public boolean checkTape(int n) {
		int counter = 0;
		for (int i = max_len - 1; i >= 0; i--) {
			if (tape[i] != 'B') {
				counter++;
			}
		}
		return counter <= n;
	}

}
