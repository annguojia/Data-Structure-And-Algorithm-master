package RPNCalculatorWithMemory;

public class SinglyLinkedList {
	
	public Node head;
	
	public SinglyLinkedList(){
		this.head = null;
	}
	
	/**
	 * Check if the list is empty
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post return true if the list is empty otherwise false
	 * @param 
	 */
	public boolean isEmpty(){
		return this.head == null;
	}
	
	/**
	 * Add item at front
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post item is added after this function returns
	 * @param item
	 */
	public void addFirst(Object item){
		Node newHead = new Node(item, head);
		head = newHead;
	}
	
	/**
	 * Get the first item's value
	 * It doesn't make sense to talk about cases
	 * @pre The head of this list is not none 
	 * @post The value of the first item is returned
	 * @param 
	 */
	public Object getFirst(){
		return head.value;
	}
	
	/**
	 * Remove the first item of the list
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post the first item of the list is removed
	 * @param 
	 */
	public void removeFirst(){
		if(head != null){
			head = head.next;
		}
	}
	
	class Node {
		private Object value;
		private Node next;
		
		public Node(Object v, Node n){
			this.value = v;
			this.next = n;
		}
	}

}
