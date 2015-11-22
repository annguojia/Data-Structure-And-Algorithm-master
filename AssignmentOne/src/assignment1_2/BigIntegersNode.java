package assignment1_2;
import java.math.BigInteger;

	public class BigIntegersNode{
		public BigInteger value;
		public BigIntegersNode next;
		public int index;
		public BigIntegersNode(BigInteger V, BigIntegersNode N, int I){
			value = V;
			next = N;
			index = I;
		}
	}