package assignment1_3;
import java.math.BigInteger;
import java.util.Scanner;



public class MerkleHellmanKnapsackCryptosystem {

	public static void main(String[] args) {
		System.out.println("Enter a string and I will encrypt it as single large integer.");
		int length = Integer.MAX_VALUE;
		String raw_string = "";
		while (length > 80){
			Scanner in = new Scanner(System.in);
			String input_string = in.nextLine();
			System.out.println("Clear text:");
			System.out.println(input_string);
			System.out.println("Number of clear text bytes = " + input_string.length());
			if((length =input_string.length()) > 80){
				System.out.println("The length of the input should be less than or equal 80");
			}else{
				raw_string = input_string;
			}
		}
		
		// for encode
		Encoder encoder = new Encoder();
		BigInteger encoded_integer = encoder.encode(raw_string);
		System.out.println("Welcome to Data Structures and Algorithms is encrypted as "+encoded_integer);
		
		// for decode
		Decoder decoder = new Decoder(encoder.w, encoder.q, encoder.r);
		String decoded_string = decoder.decode(encoded_integer);
		System.out.println("Result of decryption: "+decoded_string);
	}
	

	
	
	
	

	

	
	

}
