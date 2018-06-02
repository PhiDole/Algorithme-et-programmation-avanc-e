import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonteCarloPlayer extends Player{
	
	List<Node> tree;
	

	public MonteCarloPlayer(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] getMove(int[][] board) {
		long debut = System.currentTimeMillis();
		tree = new ArrayList<>();
		Node start = new Node();
		start.setBoard(board);
		start.setParent(null);
		start.setNbrWins(0);
		start.setSimuPerso(0);
		start.setSimuTotal(0);
		tree.add(start);
		List<Node> children = expension(start);
		for(Node n : children) {
			 n = simulation(n);
			update(n);
		}
		
		while (System.currentTimeMillis() - debut < 3000){
			Node node = start;
			selection(node);
			List<Node> possibilites = expension(node);
			for (Node n : possibilites) {
				simulation(n);
				update(n);
			}
		}
		Node selection = selectionFinale(start);
		int[][] boardFinal = selection.getBoard();
		int[] result = new int[2];
		for (int i = 0; i< board.length; i++) {
			for (int j = 0; j<board[0].length; j++) {
				if (board[i][j]==0 && boardFinal[i][j]==2) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	
	public void selection (Node begin) {
		float max = 0;
		Node nodeMax = new Node();
		for (Node child : begin.getChildren()) {
			float ucb = (float) (child.getNbrWins()/child.getSimuPerso() + 2*Math.sqrt(Math.log(child.getSimuTotal())/child.getSimuPerso()));
			if (ucb > max) {
				max = ucb;
				nodeMax = child;
			}
		}
		begin = nodeMax;
		if (nodeMax.getChildren()!=null) {
			selection(begin);
		}
	}
	
	public Node selectionFinale (Node begin) {
		float max = 0;
		Node nodeMax = new Node();
		for (Node child : begin.getChildren()) {
			float ucb = (float) (child.getNbrWins()/child.getSimuPerso() + 2*Math.sqrt(Math.log(child.getSimuTotal())/child.getSimuPerso()));
			if (ucb > max) {
				max = ucb;
				nodeMax = child;
			}
		}
		return nodeMax;		
	}
	
	
	public List<Node> expension(Node begin) {
		
		int[][] board = begin.getBoard();
   		List<Node> possibilites = new ArrayList<>();
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j<board[i].length; j++) {
				if (board[i][j]==0) {
					int[][] newBoard = new int[9][9];
					for (int k = 0; k<9; k++) {
						newBoard[k] = board[k].clone();
					}
					newBoard[i][j] = 2;
					Node node = new Node();
					node.setBoard(newBoard);
					node.setParent(begin);
					node.setSimuTotal(begin.getSimuTotal());
					simulation(node);
					possibilites.add(node);
					
				}
			}
		}
		begin.setChildren(possibilites);
		return possibilites;
	}

	public Node simulation(Node node) {
		int[][] board = new int[9][9];
		board = node.getBoard();
		int[][] newBoard = new int[9][9];
		for (int i = 0; i<9; i++)
		{
			newBoard[i] = board[i].clone();			
		}
		int win = 0;
		int color = 1;
		while (win==0) {
			if (color == 1) { color = 2;}
			else {color = 1;}
			boolean valid = false;
			int[] move = new int[2];
			while (valid==false) {
				String test = "";
				for (int i = 0; i<newBoard.length; i++) {
					test += Arrays.toString(newBoard[i]);
				}
				if (!test.contains("0")) {
					valid = true;
				}
				else {
					int x = (int)(Math.random()*newBoard.length);
					int y = (int)(Math.random()*newBoard.length);
					move[0] = x;
					move[1] = y;
					valid = Gomoku.valid(move, newBoard);
				}

			}
			newBoard[move[0]][move[1]] = color;
			win = Gomoku.evaluate(newBoard);
		}
		if (win == 2) {
			node.setNbrWins(1);
		}
		else {
			node.setNbrWins(0);
		}
		node.setSimuPerso(1);
		int simuTotal = node.getSimuTotal();
		node.setSimuTotal(simuTotal + 1);	
		return node;
	}
	
	public void update(Node node) {
		for (Node n : tree) {
			int simu = n.getSimuTotal();
			n.setSimuTotal(simu+1);
		}
		Node parent = node.getParent();
		while (parent.getParent()!=null) {
			int simu = parent.getSimuPerso();
			parent.setSimuPerso(simu+1);
			if (node.getNbrWins()==1) {
				int win = parent.getNbrWins();
				parent.setNbrWins(win+1);
			}
			parent = parent.getParent();
		}
		tree.add(node);
	}
}
