import java.util.*;
class N{
	int x;
	int y;
	N(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] arr;
	static boolean[][] visit, v;
	static List<N>[][] list;
	static int answer = 0;
	static Queue<N> queue;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int m = scan.nextInt();
		arr = new int[n][n];
		list = new List[n][n];
		visit = new boolean[n][n];
		v = new boolean[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				list[i][j] = new ArrayList<N>();
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			int a = scan.nextInt() - 1;
			int b = scan.nextInt() - 1;
			list[x][y].add(new N(a, b));
		}
		int count = bfs() + 1;
		System.out.print(count);
	}
	static int bfs() {
		int count = 0;
		visit = new boolean[n][n];
		visit[0][0] = true;
		v[0][0] = true;
		boolean turn = false;
		queue = new LinkedList<>();
		queue.offer(new N(0, 0));
		while(!queue.isEmpty()) {
			N now = queue.poll();
			for(N next : list[now.x][now.y]) {
				if(!v[next.x][next.y]) {
					v[next.x][next.y] = true;
					count++;
					turn = true;
				}
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(!v[nx][ny] || visit[nx][ny]) continue;
				queue.offer(new N(nx, ny));
				visit[nx][ny] = true;
			}
		}
		if(turn)
			count += bfs();
		return count;
	}
}