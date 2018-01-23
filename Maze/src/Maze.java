import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Maze {
	final static Point[] move = 
		{new Point(0, -1), new Point(0, 1), new Point(1, 0), new Point(-1, 0)};
	
	public static void findPath(int[][] maze, Point[][] path, Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		maze[start.x][start.y] = -1;
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for(Point step : move) {
				
				if (inMaze(maze, cur.x + step.x, cur.y + step.y) 
						&& maze[cur.x + step.x][cur.y + step.y] == 1) {
					Point temp = cur.add(step);
					maze[temp.x][temp.y] = -1;
					
					if (temp.equal(end)) {
						path[temp.x][temp.y] = cur;
						backTracking(path, start, end);// final step
						return;
					} else {
						q.add(temp);
						path[temp.x][temp.y] = cur;
					}
					
				}
				
			}
			
		}
		
	}
	
	// Check if the point is Maze, return false if it's not, otherwise return true
	public static boolean inMaze(int[][] maze, int x, int y) {
		int n = maze.length, m = maze[0].length;
		if (x >= 0 && y >= 0 && x < n && y < m) return true;
		return false;
	}
	
	// print the path from start point to end point
	public static void backTracking(Point[][] path, Point s, Point e) {
		Stack<Point> stack = new Stack<>();
		stack.push(e);
		Point cur;
		while (!stack.peek().equal(s)) {
			cur = path[stack.peek().x][stack.peek().y];
			stack.push(cur);
		}
		while (!stack.empty()) {
			System.out.println(stack.pop().toString());
		}
	}
	
	public static void main(String[] arge) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] board = new int[n][m];
		Point[][] Path = new Point[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = scan.nextInt();
			}
		}
		scan.close();
		for (int[] arr : board) {
			System.out.println(Arrays.toString(arr));
		}
		findPath(board, Path, new Point(0, 0), new Point(0, 5));
	}
}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point add(Point p) {
		return new Point(x + p.x, y + p.y);
	}
	public boolean equal(Point p) {
		if (x == p.x && y == p.y) return true;
		return false;
	}
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

