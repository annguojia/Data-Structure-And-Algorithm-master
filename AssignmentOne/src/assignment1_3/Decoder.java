package assignment1_3;
import java.math.BigInteger;
import java.util.Arrays;


public class Decoder {
	BigInteger[] w;
	BigInteger q;
	BigInteger r_reverse;
	BigInteger r;
	
	/**
	 * Constructs a new Decoder object with r w and q.
	 */
	public Decoder(BigInteger[] w, BigInteger q, BigInteger r) {
		this.w = w;
		this.q = q;
		this.r = r;
		this.r_reverse = r.modInverse(q);
	}

	public String decode(BigInteger encoded_integer){
		String ret = "";
		boolean []index = new boolean[640];
		Arrays.fill(index, false);

        // decode integer into binary
		BigInteger tmp = encoded_integer.multiply(r_reverse).mod(q);
		while(tmp.compareTo(BigInteger.ZERO)>0){
			for(int i = 0; i < 640; i++){
				if(i == 639){
					index[639] = true;
					tmp = tmp.subtract(w[i]);
					break;
				}
				if(w[i].compareTo(tmp) <= 0 && w[i + 1].compareTo(tmp) > 0){
					index[i] = true;
					tmp = tmp.subtract(w[i]);
					break;
				}
			}
			
		}
		
		// decode binary into string
		String tmp_string = "";
		int tmp_integer = 0;
		for(int i=0; i<640; i++){
			if(index[i]){
				tmp_string+='1';
			}else{
				tmp_string+='0';
			}
			if(i!= 0 && (i+1) % 8 == 0){
				
				tmp_integer = (Integer.parseInt(tmp_string, 2));
				ret += (char)tmp_integer; // convert integer to char for example 87 - W
				tmp_string = "";
			}
		}
		

		return ret;
	}
	

}
