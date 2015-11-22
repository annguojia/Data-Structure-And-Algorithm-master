package part1_queue_and_redBlackTree;

public class RedBlackTree {
	public RedBlackNode header;
	public RedBlackNode nullNode;
	public static final int BLACK = 0;
	public static final int RED = 1;
	private int recentCompares = 0;

	public static void main(String[] args) throws Exception {

		RedBlackTree rbt = new RedBlackTree();

		for (int j = 1; j <= 5; j++)
			rbt.insert("" + j);

		// after 1..5 are inserted
		System.out.println("RBT in order");
		rbt.inOrderTraversal();
		System.out.println("RBT level order");
		rbt.levelOrderTraversal();

		// is 3 in the tree

		if (rbt.contains("" + 3))
			System.out.println("Found 3");
		else
			System.out.println("No 3 found");

		// display the height
		System.out.println("The height is " + rbt.height());

	}

	public RedBlackTree() {
		nullNode = new RedBlackNode(null, BLACK, null, null, null);
		header = new RedBlackNode(null, BLACK, nullNode, nullNode, nullNode);
	}

	
	/**
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post the size of the tree will be returned
	 */
	public int getSize() {
		if (header == null) {
			return 0;
		}
		return dfs(header);
	}

	private int dfs(RedBlackNode n) {
		if (n == nullNode) {
			return 0;
		}
		return 1 + dfs(n.getLc()) + dfs(n.getRc());

	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre t is a valid RedBlackNode
	 * @post print nodes in inOrder order
	 */
	public void inOrderTraversal(RedBlackNode t) {
		if (t == nullNode) {
			return;
		}
		// go left
		inOrderTraversal(t.getLc());

		// deal with the root
		String color = t.getColor() == 0 ? "Black" : "Red";
		String parent = t.getP() == nullNode ? "-1" : t.getP().getData();
		String lc = t.getLc() == nullNode ? "-1" : t.getLc().getData();
		String rc = t.getRc() == nullNode ? "-1" : t.getLc().getData();
		System.out
				.println("[data = " + t.getData() + ":Color = " + color
						+ ":Parent = " + parent + ": LC = " + lc + ": RC = "
						+ rc + "]");

		// go right
		inOrderTraversal(t.getRc());
	}

	public void inOrderTraversal() {
		inOrderTraversal(header);
	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre t is a valid RedBlackNode
	 * @post print nodes in reverseOrder order
	 */
	public void reverseOrderTraversal(RedBlackNode t) {
		if (t == nullNode) {
			return;
		}

		// go right
		inOrderTraversal(t.getRc());
		
		// deal with the root
		String color = t.getColor() == 0 ? "Black" : "Red";
		String parent = t.getP() == nullNode ? "-1" : t.getP().getData();
		String lc = t.getLc() == nullNode ? "-1" : t.getLc().getData();
		String rc = t.getRc() == nullNode ? "-1" : t.getLc().getData();
		// deal with the root
		System.out
				.println("[data = " + t.getData() + ":Color = " + color
						+ ":Parent = " + parent + ": LC = " + lc + ": RC = "
						+ rc + "]");

		// go left
		inOrderTraversal(t.getLc());
	}

	public void reverseOrderTraversal() {
		reverseOrderTraversal(header);
	}

	/**
	 * @best: O(1)
	 * @worst: O(Log(n))
	 * @pre data is String 
	 * @post a new node will be inserted into the red black tree
	 */
	public void insert(String data) {

		if (header.getData() == null) {
			header.setData(data);
			return;
		}

		RedBlackNode tmpParent = nullNode;
		RedBlackNode tmpChild = header;
		while (tmpChild != nullNode) {
			tmpParent = tmpChild;
			if (data.compareTo(tmpChild.getData()) < 0) {
				tmpChild = tmpChild.getLc();
			} else {
				tmpChild = tmpChild.getRc();
			}
		}
		// now tmpParent is the parent node of the place where we should insert
		// a new node

		if (data.compareTo(tmpParent.getData()) < 0) {
			tmpParent.setLc(new RedBlackNode(data, RED, tmpParent, nullNode,
					nullNode));
			RBInsertFixup(tmpParent.getLc());
		} else {
			tmpParent.setRc(new RedBlackNode(data, RED, tmpParent, nullNode,
					nullNode));
			RBInsertFixup(tmpParent.getRc());
		}

	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre x is a valid RedBlackNode
	 * @post tree will be left rotated
	 */
	public void leftRotate(RedBlackNode x) {

		RedBlackNode y = x.getRc();
		x.setRc(y.getLc());
		y.getLc().setP(x);
		y.setP(x.getP());

		if (x.getP() == nullNode) {
			header = y;
		} else {
			if (x == x.getP().getLc()) {
				x.getP().setLc(y);
			} else {
				x.getP().setRc(y);
			}
		}

		y.setLc(x);
		x.setP(y);
	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre x is a valid RedBlackNode
	 * @post tree will be right rotated
	 */
	public void rightRotate(RedBlackNode x) {

		RedBlackNode y = x.getLc();
		x.setLc(y.getRc());
		y.getRc().setP(x);
		y.setP(x.getP());

		if (x.getP() == nullNode) {
			header = y;
		} else {
			if (x == x.getP().getLc()) {
				x.getP().setLc(y);
			} else {
				x.getP().setRc(y);
			}
		}

		y.setRc(x);
		x.setP(y);
	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre z is a valid RedBlackNode
	 * @post tree will be fixed up
	 */
	public void RBInsertFixup(RedBlackNode z) {

		while (z.getP().getColor() == RED) {
			if (z.getP() == z.getP().getP().getLc()) {
				// z's parent is a left child.
				RedBlackNode y = z.getP().getP().getRc();
				if (y.getColor() == RED) {

					// Case 1: z's uncle y is red.
					z.getP().setColor(BLACK);
					y.setColor(BLACK);
					z.getP().getP().setColor(RED);
					z = z.getP().getP();

				} else {
					if (z == z.getP().getRc()) {
						// Case 2: z's uncle y is black and z is a right child.
						z = z.getP();
						leftRotate(z);
					}

					// Case 3: z's uncle y is black and z is a left child.
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					rightRotate(z.getP().getP());
				}
			} else {
				// z's parent is a right child. Do the same as when z's
				// parent is a left child, but exchange "left" and "right."
				// z's parent is a left child.
				RedBlackNode y = z.getP().getP().getLc();
				if (y.getColor() == RED) {

					// Case 1: z's uncle y is red.
					z.getP().setColor(BLACK);
					y.setColor(BLACK);
					z.getP().getP().setColor(RED);
					z = z.getP().getP();

				} else {
					if (z == z.getP().getLc()) {
						// Case 2: z's uncle y is black and z is a left child.
						z = z.getP();
						rightRotate(z);
					}

					// Case 3: z's uncle y is black and z is a right child.
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					leftRotate(z.getP().getP());
				}

			}

			// The root is always black.
			header.setColor(BLACK);
		}

	}

	/**
	 * @best: O(1)
	 * @worst: O(Log(n))
	 * @pre v is a String
	 * @post return true if the tree contains v otherwise false
	 */
	public boolean contains(String v) {
		RedBlackNode cur = header;
		while (cur != nullNode) {
			recentCompares++;
			if (v.compareTo(cur.getData()) > 0) {
				cur = cur.getRc();
			} else if (v.compareTo(cur.getData()) < 0) {
				cur = cur.getLc();
			} else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * It doesn't make sense to talk about cases
	 * pre none
	 * post return the recentCompares
	 */
	public int getRecentCompares() {
		return recentCompares;
	}

	/**
	 * @best: O(1)
	 * @worst: O(Log(n))
	 * @pre v is a String
	 * @post return the value of node which is closest to the value of v
	 */
	public String closeBy(String v) {
		RedBlackNode mostRecentNodeBeforeFailOff = header;
		RedBlackNode pCur = header;
		while (pCur != nullNode) {

			if (v.compareTo(pCur.getData()) > 0) {
				mostRecentNodeBeforeFailOff = pCur;
				pCur = pCur.getRc();
			} else if (v.compareTo(pCur.getData()) < 0) {
				mostRecentNodeBeforeFailOff = pCur;
				pCur = pCur.getLc();
			} else {
				return v;
			}
		}
		return mostRecentNodeBeforeFailOff.getData();
	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post return height of the tree
	 */	
	public int height() {
		return dfs2(header);
	}

	private int dfs2(RedBlackNode n) {
		if (n == nullNode) {
			return 0;
		}
		return Math.max(dfs2(n.getLc()), dfs2(n.getRc()) + 1);
	}

	/**
	 * It doesn't make sense to talk about cases
	 * @pre none
	 * @post print tree nodes in level order
	 */
	public void levelOrderTraversal() throws Exception {
		Queue q = new Queue();
		q.enQueue(header);
		while (!q.isEmpty()) {
			RedBlackNode t = (RedBlackNode) q.deQueue();
			String color = t.getColor() == 0 ? "Black" : "Red";
			String parent = t.getP() == nullNode ? "-1" : t.getP().getData();
			String lc = t.getLc() == nullNode ? "-1" : t.getLc().getData();
			String rc = t.getRc() == nullNode ? "-1" : t.getLc().getData();
			System.out.println("[data = " + t.getData() + ":Color = " + color
					+ ":Parent = " + parent + ": LC = " + lc + ": RC = " + rc
					+ "]");
			if (t.getLc() != nullNode) {
				q.enQueue(t.getLc());
			}
			if (t.getRc() != nullNode) {
				q.enQueue(t.getRc());
			}
		}
	}
}
