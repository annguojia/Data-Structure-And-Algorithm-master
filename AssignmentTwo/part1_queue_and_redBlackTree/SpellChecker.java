package part1_queue_and_redBlackTree;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpellChecker {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		RedBlackTree RBT = new RedBlackTree();
		String file = "/Users/zhangyang/Documents/workspaceAWSDATA/AssignmentTwo/src/words.txt";
		FileInputStream fs = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		String line = null;
		while ((line = br.readLine()) != null) {
			RBT.insert(line);
		}
		br.close();
		fs.close();

		System.out.println("Red Black Tree is loaded with " + RBT.getSize()
				+ " words");
		System.out.println("The height of the tree is " + RBT.height());
		System.out.println("2 * Lg( n+1) = " + 2
				* (Math.log(RBT.getSize() + 1) / Math.log(2)));
		System.out.println("Legal commands are: ");
		System.out
				.println("<d> display the entire word tree with a level order traversal.");
		System.out
				.println("<s>  print the words of the tree in sorted order (use an inorder traversal).");
		System.out
				.println("<r>  print the words of the tree in reverse sorted order.");
		System.out.println("<!> to quit.");
		System.out.println("<c> <word> to spell check this word");
		System.out.println("<a> <word> add word to tree.");
		System.out
				.println("<f> <fileName> to spell check a text file for spelling errors.");

		while (true) {
			Scanner in = new Scanner(System.in);
			String input_string = in.nextLine();
			String[] parts = input_string.split(" ");
			if (parts[0].equals(">!")) {
				System.out.println("Bye");
				break;
			} else if (parts[0].equals(">d")) {
				RBT.levelOrderTraversal();
			} else if (parts[0].equals(">s")) {
				RBT.inOrderTraversal();
			} else if (parts[0].equals(">r")) {
				RBT.reverseOrderTraversal();
			} else if (parts[0].equals(">c")) {
				if (RBT.contains(parts[1])) {
					System.out.println("Found " + parts[1] + " after "
							+ RBT.getRecentCompares() + " steps.");
				} else {
					System.out
							.println("Not in the dictionary. Perhaps you mean");
					System.out.println(RBT.closeBy(parts[1]));
				}
			} else if (parts[0].equals(">a")) {
				RBT.insert(parts[1]);
			} else if (parts[0].equals(">f")) {
				String checkFile = parts[1];
				FileInputStream fs2 = new FileInputStream(checkFile);
				BufferedReader br2 = new BufferedReader(new InputStreamReader(fs2));
				String line2 = null;
				while ((line2 = br2.readLine()) != null) {
					String[] parts2 = line2.split(" ");
					
					if(parts2.length == 1){
						if (!RBT.contains(line2)) {
							System.out
							.println(line2 + " was not in the dictionary.");
						}
					}else{
						for(String s : parts2){
							if (!RBT.contains(s)) {
								System.out
								.println(s + " was not in the dictionary.");
							}
						}
					}
				}
				br2.close();
				fs2.close();

			}
		}

	}

}
