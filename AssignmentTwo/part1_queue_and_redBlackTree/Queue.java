package part1_queue_and_redBlackTree;

public class Queue {
	public Node front;
	public Node back;

	public Queue() {
		front = back = null;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void enQueue(Object x) {
		if (isEmpty()) {
			back = front = new Node(x, null);
		} else {
			back = back.next = new Node(x, null);
		}
	}

	public Object deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("empty dequeue");
		}
		Object ret = front.value;
		front = front.next;
		return ret;
	}

	public Object getFront() {
		if (isEmpty()) {
			return null;
		} else {
			return front.value;
		}
	}

	public boolean isFull() {
		return false;
	}

	class Node {
		private Object value;
		private Node next;

		public Node(Object V, Node N) {
			this.value = V;
			this.next = N;
		}
	}

}
