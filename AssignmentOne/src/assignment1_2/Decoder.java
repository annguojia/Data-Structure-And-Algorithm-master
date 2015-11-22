package assignment1_2;
import java.math.BigInteger;
import java.util.Arrays;


public class Decoder {
	BigIntegersSinglyLinkedList w;
	BigInteger q;
	BigInteger r_reverse;
	BigInteger r;
	
	/**
	 * Constructs a new Decoder object with r w and q.
	 */
	public Decoder(BigIntegersSinglyLinkedList w, BigInteger q, BigInteger r) {
		this.w = w;
		this.q = q;
		this.r = r;
		this.r_reverse = r.modInverse(q);
	}

	/**
	 * Decode a integer to a string
	 * It doesn't make sense to talk about cases
	 * @pre the input integer is a valid encoded integer
	 * @post a decoded string will be returned
	 * @param an encoded integer
	 * @return a decoded string
	 */	
	public String decode(BigInteger encoded_integer){
		String ret = "";
		boolean []index = new boolean[640];
		Arrays.fill(index, false);

        // decode integer into binary
		BigInteger tmp = encoded_integer.multiply(r_reverse).mod(q);
		while(tmp.compareTo(BigInteger.ZERO)>0){
			BigIntegersNode cur = w.head;
			while(cur != null){
				
				if(cur.next == null){
					index[cur.index] = true;
					tmp = tmp.subtract(cur.value);
					break;
				}
				
				if(cur.value.compareTo(tmp) <= 0 && cur.next.value.compareTo(tmp)>0){
					index[cur.index] = true;
					tmp = tmp.subtract(cur.value);
					break;
				}
				cur = cur.next;
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
