import java.awt.Point;
import java.util.*;
class Nodf{
	int x;
	int cost;
	Nodf(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}
class Main{
	static int n, m;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] arr;
	static boolean[][] visit;
	static int color;
	static int answer = Integer.MAX_VALUE;
	static List<Nodf>[] edge;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				arr[i][j] = scan.nextInt();
		color = 1;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(arr[i][j] == 1 && !visit[i][j]) {
					bfs(i, j, color);
					color++;
				}
		edge = new List[color];
		for(int i = 1; i < color; i++)
			edge[i] = new ArrayList<Nodf>();
		v = new boolean[color];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) continue;
				bridge(i, j);
			}
		}
		prim();
	}
	static void bfs(int x, int y, int color) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		arr[x][y] = color;
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(visit[nx][ny]) continue;
				if(arr[nx][ny] == 0) continue;
				queue.offer(new Point(nx, ny));
				visit[nx][ny] = true;
				arr[nx][ny] = color;
			}
		}
	}
	static void bridge(int x, int y) {
		for(int i = 0; i < 4; i++) {
			for(int j = 1;; j++) {
				int nx = x + dir[i][0] * j;
				int ny = y + dir[i][1] * j;
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) break;
				if(arr[nx][ny] == 0) continue;
				if(arr[nx][ny] == arr[x][y]) break;
				if(j <= 2 && arr[nx][ny] != arr[x][y])
					break;
				if(arr[x][y] != arr[nx][ny]) {
					if(j > 2) {
						edge[arr[x][y]].add(new Nodf(arr[nx][ny], j - 1));
						break;
					}
				}
			}
		}
	}
	static void prim() {
		PriorityQueue<Nodf> queue = new PriorityQueue<Nodf>((o1, o2) -> (o1.cost - o2.cost));
		int result = 0;
		int cnt = 0;
		for(int i = 1; i < color; i++) {
			if(edge[i].size() == 0) {
				System.out.println(-1);
				return;
			}
		}
		for(Nodf no : edge[1]) 
			queue.offer(no);
		v[1] = true;
		while(!queue.isEmpty()) {
			Nodf now = queue.poll();
			if(v[now.x]) continue;
			result += now.cost;
			v[now.x] = true;
			if(cnt++ == color - 1) break;
			for(Nodf no : edge[now.x]) {
				if(v[no.x]) continue;
				queue.offer(no);
			}
		}
		for(int i = 1; i < color; i++) {
			if(!v[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(result);
	}
}