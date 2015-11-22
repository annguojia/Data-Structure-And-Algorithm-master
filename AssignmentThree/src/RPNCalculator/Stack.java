package RPNCalculator;

import java.util.EmptyStackException;

public class Stack {
	
	public SinglyLinkedList list;
	
	public Stack(){
		this.list = new SinglyLinkedList();
	}
	
	/**
	 * Check if the stack is empty
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post return true if the stack is empty otherwise false
	 * @param 
	 */
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	/**
	 * return the top item of the stack
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post the first item of the stack is returned
	 * @param 
	 */
	public Object peek(){
		if(list.isEmpty()){
			throw new EmptyStackException();
		}
		return list.getFirst();
	}
	
	/**
	 * return the top item of the stack and then pop it
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post the first item of the stack is returned and poped
	 * @param 
	 */
	public Object pop(){
		if(list.isEmpty()){
			throw new EmptyStackException();
		}
		Object ret = list.getFirst();
		list.removeFirst();
		return ret;
	}
	
	/**
	 * push a new item into the stack
	 * It doesn't make sense to talk about cases
	 * @pre none 
	 * @post the item is pused into the stack
	 * @param item
	 */
	public void push(Object item){
		list.addFirst(item);
	}
	

}
