
public class SinglyLinkedList {
	
	public Node head;
	public SinglyLinkedList(){
		this.head = null;
	}
	
	public void addToHead(int V){
		this.head = new Node(V,this.head);
	}
	
	public void addToTail(int V){
		
		Node cur = this.head;
		
		if(cur == null){
			addToHead(V);
		}else{
			while((cur.next) != null)
				cur = cur.next; 
			// now cur is the last node of the list
			cur.next = new Node(V , null);
		}
	}
	
	private class Node{
		private int value;
		private Node next;
		public Node(int V, Node N){
			this.value = V;
			this.next = N;
		}
	}

}
