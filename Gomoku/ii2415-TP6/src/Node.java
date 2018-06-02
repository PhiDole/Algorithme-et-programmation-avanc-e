import java.util.List;

public class Node {
	
	private int nbrWins;
	private int simuPerso;
	private int simuTotal;
	private int[][] board;
	private Node parent;
	private List<Node> children;
	
	public Node() {
		super();
	}
	
	public Node(int nbrWins, int simuPerso, int simuTotal, int[][] board, Node parent, List<Node> children) {
		super();
		this.nbrWins = nbrWins;
		this.simuPerso = simuPerso;
		this.simuTotal = simuTotal;
		this.board = board;
		this.parent = parent;
		this.children = children;
	}



	public int getNbrWins() {
		return nbrWins;
	}

	public void setNbrWins(int nbrWins) {
		this.nbrWins = nbrWins;
	}

	public int getSimuPerso() {
		return simuPerso;
	}

	public void setSimuPerso(int simuPerso) {
		this.simuPerso = simuPerso;
	}

	public int getSimuTotal() {
		return simuTotal;
	}

	public void setSimuTotal(int simuTotal) {
		this.simuTotal = simuTotal;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	
}
