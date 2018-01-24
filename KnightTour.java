import java.util.Arrays;

public class KnightTour {
	int[][] board;
	int n, m;
	int counter = 0;
	public KnightTour(int n, int m) {
		board = new int[n][m];
		this.n= n;
		this.m = m;
	}
	
	public void tourDFS(int x, int y, int cur) {
		cur++;
		if (inboard(x, y) && board[x][y] == 0) {
			board[x][y] = cur;
			if (cur == n*m) {
				System.out.println("case: " + ++counter);
				for (int[] row : board) {
					System.out.println(Arrays.toString(row));
				}
				board[x][y] = 0;
				return;
			} else {
				tourDFS(x - 1, y + 2, cur);
				tourDFS(x - 2, y + 1, cur);
				tourDFS(x - 2, y - 1, cur);
				tourDFS(x - 1, y - 2, cur);
				tourDFS(x + 1, y - 2, cur);
				tourDFS(x + 2, y - 1, cur);
				tourDFS(x + 2, y + 1, cur);
				tourDFS(x + 1, y + 2, cur);
				
				
				
				board[x][y] = 0;
			}
		} else return;
	}
	
	public boolean inboard(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) return true;
		return false;
	}
	
	public static void main(String[] args) {
		KnightTour kt = new KnightTour(5,5);
		kt.tourDFS(0, 0, 0);
	}
}
