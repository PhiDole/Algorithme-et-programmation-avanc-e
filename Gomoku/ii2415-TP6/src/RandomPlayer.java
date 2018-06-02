
public class RandomPlayer extends Player{

	public RandomPlayer(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] getMove(int[][] board) {
		int[] move = new int[2];
		boolean valid = false;
		while (!valid) {
			int x = (int)(Math.random()*board.length);
			int y = (int)(Math.random()*board.length);
			move[0] = x;
			move[1] = y;
			valid = Gomoku.valid(move, board);
		}
		return move;
	}

	
}
