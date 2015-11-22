package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TuringMachine {
	static int n;

	public static void main(String args[]) throws IOException {

		System.out.println("How many bit positions?");
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		String line = is.readLine();
		n = Integer.parseInt(line);

		double now = System.nanoTime();
		double now2 = System.currentTimeMillis() / 1000;
		// This is a three state machine. It has states 0, and 1, and a halt
		// state of 2.
		Turing machine = new Turing(3);

		// System.out.println("Adding transitions to state 0");

		machine.addTransition(0, 'B', new Transition('0', Transition.LEFT, 2));
		machine.addTransition(0, '0', new Transition('1', Transition.LEFT, 2));
		machine.addTransition(0, '1', new Transition('0', Transition.LEFT, 1));

		// System.out.println("Adding transitions to state 1");

		machine.addTransition(1, '1', new Transition('0', Transition.LEFT, 1));
		machine.addTransition(1, 'B', new Transition('1', Transition.LEFT, 2));
		machine.addTransition(1, '0', new Transition('1', Transition.LEFT, 2));

		// place n B’s on tape
		initializeTapeWithBlanks(machine);

		System.out.println("Running machine on an initially empty tape");

		while (true) {
			// machine is in state 0
			// tape head points to least significant bit
			machine.execute(); // execute until halt state is entered
			if (checkTape(machine)) {
				//displayTape(machine);
			} else {
				break;
			}
		}

		System.out.println("Program complete in " + (System.nanoTime() - now)
				+ " nano seconds");
		System.out.println("Program complete in "
				+ (System.currentTimeMillis() / 1000 - now2) + " seconds");

	}

	/**
	 * initialize tape
	 * @pre machine has tape field and is not empty
	 * @post the content of tape is filled with 'B'
	 * @param machine
	 * @return
	 */
	static void initializeTapeWithBlanks(Turing machine) {
		Arrays.fill(machine.tape, 'B');
	}

	/**
	 * print out the tape's content
	 * @pre machine has tape field and is not empty
	 * @post the content of tape is displayed 
	 * @param machine
	 * @return
	 */
	static void displayTape(Turing machine) {
		String s = new String(machine.tape);
		System.out.println(s.replace("B", ""));
	}

	/**
	 * check if we get enough binary numbers
	 * @pre machine has tape field and is not empty
	 * @post whether we should continue computing is returned as a boolean
	 * @param machine
	 * @return
	 */
	static boolean checkTape(Turing machine) {
		return machine.checkTape(n);
	}

}
