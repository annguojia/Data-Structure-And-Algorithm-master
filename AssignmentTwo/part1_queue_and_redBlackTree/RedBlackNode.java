package part1_queue_and_redBlackTree;
public class RedBlackNode {
	public static final int BLACK = 0;
	public static final int RED = 1;
    
	public int color;
	private String data;
	private RedBlackNode Lc;
	private RedBlackNode Rc;
	private RedBlackNode P;

	public RedBlackNode(String data, int color, RedBlackNode p,
			RedBlackNode lc, RedBlackNode rc) {
		this.color = color;
		this.data = data;
		this.P = p;
		this.Lc = lc;
		this.Rc = rc;

	}

	public int getColor() {
		return (color == BLACK ? BLACK : RED);
	}

	public String getData() {
		return data;
	}

	public RedBlackNode getLc() {
		return Lc;
	}

	public RedBlackNode getRc() {
		return Rc;
	}

	public RedBlackNode getP() {
		return P;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setLc(RedBlackNode Lc) {
		this.Lc = Lc;
	}

	public void setRc(RedBlackNode Rc) {
		this.Rc = Rc;
	}

	public void setP(RedBlackNode P) {
		this.P = P;
	}

}
