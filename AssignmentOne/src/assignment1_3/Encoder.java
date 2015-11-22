package assignment1_3;

import java.math.BigInteger;

public class Encoder {
	BigInteger [] w;
	BigInteger [] b;
	BigInteger q;
	BigInteger r;

	/**
	 * Constructs a new Encoder object with r w q and b.
	 */
	public Encoder() {

		this.r = new BigInteger("9550991");
		this.w = createW();
		this.q = chooseQ(w);
		this.b = createB(w, q, r);

	}

	/**
	 * Create a new B sequence
	 * It doesn't make sense to talk about cases
	 * @pre W sequence has already been generated before this method
	 * @post a new B sequence will be generate and returned by this method
	 */
	private static BigInteger[] createB(
			BigInteger[] w, BigInteger q, BigInteger r) {
		BigInteger[] B = new BigInteger[640];
		for(int i=0 ; i<80 * 8; i++){

			B[i] =(w[i].multiply(r).mod(q));
		}
		return B;
	}

	/**
	 * Create a new W sequence
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post a new W sequence will be generate and returned by this method
	 */
	private static BigInteger[] createW() {
		BigInteger[] W = new BigInteger[640];
		BigInteger tmp_sum = BigInteger.ONE;
		for (int i = 0; i < 80 * 8; i++) {
			W[i] = tmp_sum;
			tmp_sum = tmp_sum.multiply(new BigInteger("2")).add(BigInteger.ONE);
		}
		return W;
	}

	/**
	 * Create a new Q parameter
	 * It doesn't make sense to talk about cases
	 * @pre W sequence has already been generated before this method
	 * @post a new parameter Q will be generate and returned by this method
	 * @param W
	 * @return Q 
	 */
	private static BigInteger chooseQ(BigInteger[] W) {

		BigInteger sum = BigInteger.ZERO;
		
		for(int i = 0; i<80 * 8; i++){
			sum = sum.add(W[i]);
		}
		
		return sum.add(new BigInteger("17"));
	}

	/**
	 * Encode a input string into a integer
	 * It doesn't make sense to talk about cases
	 * @pre W,B,Q,R have already been generated before this method
	 * @post a new encoded Integer will be generate and returned by this method
	 * @param str
	 * @return the encoded integer
	 */
	public BigInteger encode(String str) {
		byte[] bytes = str.getBytes();
		BigInteger ret = BigInteger.ZERO;
		boolean[] tmp = new boolean[640];
		int ind = 0;

		for (byte b1 : bytes) {
			int val = b1;
			for (int i = 0; i < 8; i++) {
				tmp[ind] = ((val & 128) == 0 ? false : true);
				val = val << 1;
				ind++;
			}
		}

		for(int i=0; i<80 * 8; i++){
			if(tmp[i]){
				ret = ret.add(b[i]);
			}
		}

		return ret;
	}

}
