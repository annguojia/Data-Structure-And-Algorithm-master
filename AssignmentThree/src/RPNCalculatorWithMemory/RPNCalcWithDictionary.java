package RPNCalculatorWithMemory;

public class RPNCalcWithDictionary {
	private Stack myStack;
	private RedBlackTreeWithDictionary dictionary = new RedBlackTreeWithDictionary();
	
	public RPNCalcWithDictionary(){
		myStack = new Stack();
	}
	
	/**
	 * perform equal operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void equal(){
		float num1 = (Float)myStack.pop();
		String a = (String)myStack.pop();
		dictionary.put(a, num1);
		myStack.push(a);
	}
	
	/**
	 * perform add operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from add operation is pushed into stack
	 * @param 
	 */
	public void add() throws Exception{
		Object n1;
		Object n2;
		
		n1 = myStack.pop();
			
		if(n1 instanceof String){
			n1 = dictionary.get((String)n1);
		}
		
		n2 = myStack.pop();
		
		if(n2 instanceof String){
			n2 = dictionary.get((String)n2);
		}
		
		
		myStack.push((Float)n1 + (Float)n2);
	}
	
	
	/**
	 * perform divide operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void divide() throws Exception{
		Object n1;
		Object n2;
		
		n1 = myStack.pop();
		
		if(n1 instanceof String){
			n1 = dictionary.get((String)n1);
		}
		
		n2 = myStack.pop();
		
		if(n2 instanceof String){
			n2 = dictionary.get((String)n2);
		}
		
		myStack.push( ((Float)n2) / ((Float)n1));
	}

	/**
	 * perform multiply operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void multiply() throws Exception{
		Object n1;
		Object n2;
		
		n1 = myStack.pop();
		
		if(n1 instanceof String){
			n1 = dictionary.get((String)n1);
		}
		
		n2 = myStack.pop();
		
		if(n2 instanceof String){
			n2 = dictionary.get((String)n2);
		}
		
		myStack.push(((Float)n2) * ((Float)n1));
	}
	
	/**
	 * perform substract operation
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least two items  
	 * @post the result from the operation is pushed into stack
	 * @param 
	 */
	public void subtract() throws Exception{
		Object n1;
		Object n2;
		
		n1 = myStack.pop();
		
		if(n1 instanceof String){
			n1 = dictionary.get((String)n1);
		}
		
		n2 = myStack.pop();
		
		if(n2 instanceof String){
			n2 = dictionary.get((String)n2);
		}
		
		myStack.push(((Float)n2) - ((Float)n1));
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
	 * push a variable into the stack
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post the variable is pushed into stack
	 * @param item
	 */
	public void variable(String item){
		myStack.push(item);
	}
	
	
	/**
	 * return a value from the top of the stack
	 * It doesn't make sense to talk about cases
	 * @pre the stack has at least one item
	 * @post the number on the top of the stack is returned 
	 * @param 
	 */
	public float top() throws Exception{
		
		if(myStack.isEmpty()){
			return 0;
		}
		
		Object ret = myStack.pop();
		
		if(ret instanceof String){
			ret = dictionary.get((String)ret);
		}
		
		myStack.push(ret);
		
		return (Float) ret;
	}
	
	
	
	

}
