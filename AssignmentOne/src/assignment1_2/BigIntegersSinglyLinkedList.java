package assignment1_2;
import java.math.BigInteger;


public class BigIntegersSinglyLinkedList {
	public BigIntegersNode head;
	public BigIntegersSinglyLinkedList(){
		this.head = null;
	}
	public void addToHead(BigInteger V){
		this.head = new BigIntegersNode(V,this.head, 0);
	}
	
	public void addToTail(BigInteger V){
		if(this.head == null){
			addToHead(V);
		}else{
			BigIntegersNode cur = this.head;
			int index = 0;
			while(cur.next != null){
				cur = cur.next;
				index +=1;
			}
			index +=1;
			cur.next = new BigIntegersNode(V, null, index);
		
		}
	}
	
	public BigInteger computeSum(){
		BigInteger sum = BigInteger.ZERO;
		BigIntegersNode cur = this.head;
		while (cur != null){
			sum = sum.add(cur.value);
			cur = cur.next;
		}
		
		return sum;
	}
	
}
