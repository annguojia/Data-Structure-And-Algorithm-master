package assignment1_1;
/**
 * This class implements a doubly linked list of characters in Java. The
 * instance variables head and tail are initially null. As elements are added
 * head points to the first element on the list and tail points to the last
 * element. Each node on the list is of type DoubleNode. Each DoubleNode holds a
 * pointer to the previous node and a pointer to the next node in the list.
 * 
 * @author zhangyang
 * 
 */
public class DoublyLinkedList {
	public DoubleNode head;
	public DoubleNode tail;

	/**
	 * Constructs a new DoublyLinkedList object with head and tail as null.
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * Add a character node containing the character c to the end of the linked
	 * list.
	 * It doesn't make sense to talk about cases
	 * @pre the input is char 
	 * @post a character node is added to the end of the linked list
	 * @param c
	 */
	public void addCharAtEnd(char c) {
		if(this.isEmpty()){
			this.tail = new DoubleNode(null, c, null);
			this.head = this.tail;
		}else{
			DoubleNode new_tail = new DoubleNode(this.tail, c, null);
			this.tail.setNext(new_tail);
			this.tail = new_tail;
		}
	}

	/**
	 * Add a character node containing the character c to the front of the
	 * linked list.
	 * It doesn't make sense to talk about cases
	 * @pre the input is char 
	 * @post a character node is added to the front of the linked list
	 * @param c
	 */
	public void addCharAtFront(char c) {
		if(this.isEmpty()){
			this.head = new DoubleNode(null, c, null);
			this.tail = this.head;
		}else{
			DoubleNode old_head = this.head;
			this.head = new DoubleNode(null, c, old_head);
			old_head.setPrev(this.head);
		}
	}

	/**
	 * Counts the number of nodes in the list
	 * It doesn't make sense to talk about cases
	 * @pre this list has at least a head node 
	 * @post the number of nodes in the list is returned
	 * @return - the number of nodes in the list
	 */
	public int countNodes() {
		if(this.head ==null){
			return 0;
		}
		int count = 1;
		DoubleNode cur = this.head;
		while (cur.getNext() != null) {
			cur = cur.getNext();
			count++;
		}
		return count;
	}

	/**
	 * Deletes the first occurence of the character c from the list. if the
	 * character c is not in the list then no modifications are made. This
	 * method needs to search the list.
	 * The best case run time complexity is O(1)
	 * The worst case run time complexity is O(n)
	 * @pre the input is char 
	 * @post return true if a deletion occurred and false otherwise
	 * @param c the character to be searched for.
	 * @return true if a deletion occurred and false otherwise
	 */
	public boolean deleteChar(char c) {
		DoubleNode tmpNode = this.head;
		DoubleNode prevNode = null;

		while (tmpNode!= null) {
			
			if (tmpNode.getC() == c) {
				if(tmpNode == this.head && tmpNode == this.tail){
					this.head = null;
					this.tail = null;
					break;
				}
				
				if(tmpNode == this.head){
					if(tmpNode.getNext() != null){ // the head is not the only node
					this.head = head.getNext();
					this.head.setPrev(null);
					}else{ // the head is the only node
						this.head = null;
					}
				}
				else if(tmpNode == this.tail){
					if(tmpNode.getPrev() != null){
						tmpNode.getPrev().setNext(null);
						this.tail = this.tail.getPrev();
					}else{
						this.tail = null;
					}
				}
				else{
					prevNode.setNext(tmpNode.getNext());
					tmpNode.getNext().setPrev(tmpNode.getPrev());
				}
				return true;
			}
			
			prevNode = tmpNode;
			tmpNode = tmpNode.getNext();
		}
		return false;
	}
	
	/**
	 * return true if the list is empty false otherwise 
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post return true if a the list is empty and false otherwise
	 * @return true if the list is empty false otherwise 
	 */
	public boolean isEmpty(){
		return (this.head == null);
	}
	
	public static void main(java.lang.String[] a){
		
	}
	
	/**
	 * Remove and return the character at the end of the doubly linked list.
	 * It doesn't make sense to talk about cases
	 * @pre The list has at least a tail node
	 * @post Remove and return the character at the end of the doubly linked list
	 * @return the character at the end of the doubly linked list
	 */
	public char removeCharAtEnd(){
		if(this.head == this.tail){
			char ret = this.tail.getC();
			this.head = null;
			this.tail = null;
			return ret;
		}
		
		char ret = this.tail.getC();
		this.tail = this.tail.getPrev();
		this.tail.setNext(null); // we just break the connection in one direction 
		return ret;
	}
	
	/**
	 * Remove and return the character at the front of the doubly linked list.
	 * It doesn't make sense to talk about cases
	 * @pre The list has at least a head node
	 * @post Remove and return the character at the front of the doubly linked list
	 * @return the character at the front of the doubly linked list
	 */
	public char removeCharFromFront(){
		if(this.head == this.tail){
			char ret = this.head.getC();
			this.head = null;
			this.tail = null;
			return ret;
		}
		
		char ret = this.head.getC();
		this.head = this.head.getNext();
		if(head != null){
			this.head.setPrev(null); // we just break the connection in one direction 
		}

		return ret;		
	}
	
	/**
	 * reverse the list
	 * It doesn't make sense to talk about cases
	 * @pre the list has at least a head and a tail node
	 * @post the list is reversed
	 */
	public void reverse(){
		DoubleNode tmp_node;
		for(DoubleNode cur = head; cur != null; cur = tmp_node){
			tmp_node = cur.getNext();
			cur.setNext(cur.getPrev());
			cur.setPrev(tmp_node);
		}
		DoubleNode tmp = head;
		head = tail;
		tail = tmp;
	}
	
	/**
	 * Return the list as a string 
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post the list is returned as a string
	 */
	public String toString(){
		String ret = "";
		DoubleNode cur = head;
		while(cur != null){
			ret += cur.getC();
			cur = cur.getNext();
		}
		return ret;
	}

}
