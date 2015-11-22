package assignment1_1;
/**
 * The class DoubleNode holds two pointers and a character. It is used to
 * represent a single node on a double linked list.
 * 
 * @author zhangyang
 * 
 */
public class DoubleNode {
	private char _char;
	private DoubleNode _next;
	private DoubleNode _prev;

	/**
	 * Constructor with no arguments. Assign null values to previous, next and
	 * the null character to c.
	 */
	public DoubleNode() {
		_char = '\0';
		_next = null;
		_prev = null;
	}

	/**
	 * Constructor
	 * @param p is a pointer to a previous node.
	 * @param ch is a pointer to a next node.
	 * @param n is a character for this node.
	 */
	public DoubleNode(DoubleNode p, char ch, DoubleNode n) {
		_char = ch;
		_next = n;
		_prev = p;
	}

	public char getC() {
		return this._char;
	}

	public DoubleNode getNext() {
		return this._next;
	}

	public DoubleNode getPrev() {
		return this._prev;
	}

	/**
	 * Test driver for DoubleNode
	 */
	public static void main(java.lang.String[] args) {

	}

	public void setC(char c) {
		this._char = c;
	}

	public void setNext(DoubleNode next) {
		this._next = next;
	}

	public void setPrev(DoubleNode prev) {
		this._prev = prev;
	}

}
