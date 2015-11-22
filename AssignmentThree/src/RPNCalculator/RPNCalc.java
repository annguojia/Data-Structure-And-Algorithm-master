package RPNCalculator;

public class RPNCalc {
	private Stack myStack;
	
	public RPNCalc(){
		myStack = new Stack();
	}
	
	/**
	 * perform add operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from add operation is pushed into stack
	 * @param 
	 */
	public void add(){
		myStack.push((Float)myStack.pop() + (Float)myStack.pop());
	}
	
	/**
	 * perform divide operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void divide(){
		float num1 = (Float)myStack.pop();
		myStack.push( (Float)myStack.pop()/num1);
	}
	
	/**
	 * perform multiply operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void multiply(){
		myStack.push((Float)myStack.pop() * (Float)myStack.pop());
	}
	
	/**
	 * perform substract operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void subtract(){
		float num1 = (Float)myStack.pop();
		myStack.push( (Float)myStack.pop() - num1);
	}
	
	
	/**
	 * push a number into the stack
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post the number is pushed into stack
	 * @param 
	 */
	public void number(float item){
		myStack.push(item);
	}
	
	/**
	 * return a value from the top of the stack
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least one item
	 * @post the number is popped from stack
	 * @param 
	 */
	public float top(){
		
		if(myStack.isEmpty()){
			return 0;
		}
		
		return (Float) myStack.pop();
	}
	
	
	
	

}
