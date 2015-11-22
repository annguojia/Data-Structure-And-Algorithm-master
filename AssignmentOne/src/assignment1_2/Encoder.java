package assignment1_2;

import java.math.BigInteger;

public class Encoder {
	BigIntegersSinglyLinkedList w;
	BigIntegersSinglyLinkedList b;
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
	private static BigIntegersSinglyLinkedList createB(
		BigIntegersSinglyLinkedList w, BigInteger q, BigInteger r) {
		BigIntegersSinglyLinkedList B = new BigIntegersSinglyLinkedList();
		BigIntegersNode cur = w.head;

		while (cur != null) {

			B.addToTail(cur.value.multiply(r).mod(q));
			cur = cur.next;
		}
		return B;
	}

	/**
	 * Create a new W sequence
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post a new W sequence will be generate and returned by this method
	 * @return W
	 */
	private static BigIntegersSinglyLinkedList createW() {
		BigIntegersSinglyLinkedList W = new BigIntegersSinglyLinkedList();
		BigInteger tmp_sum = BigInteger.ONE;
		for (int i = 0; i < 80 * 8; i++) {
			W.addToTail(tmp_sum);
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
	private static BigInteger chooseQ(BigIntegersSinglyLinkedList W) {

		BigInteger sum = W.computeSum();
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

		BigIntegersNode cur = b.head;
		while (cur != null) {
			if (tmp[cur.index]) {
				ret = ret.add(cur.value);
			}
			cur = cur.next;
		}
		return ret;
	}

}
