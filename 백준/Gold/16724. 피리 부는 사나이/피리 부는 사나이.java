import java.util.*;
class Point2{
	int x;
	int y;
	Point2(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m, id;
	static int[][] arr, map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<Point2> queue = new LinkedList<Point2>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == 'U')
					arr[i][j] = 0;
				else if(str.charAt(j) == 'D')
					arr[i][j] = 1;
				else if(str.charAt(j) == 'L')
					arr[i][j] = 2;
				else arr[i][j] = 3;
			}
		}
		visit = new boolean[n][m];
		queue = new LinkedList<Point2>();
		id = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visit[i][j]) {
					bfs(i, j);
					id++;
				}
			}
		}
		System.out.println(id);
	}
	static void bfs(int x, int y) {
		queue = new LinkedList<>();
		queue.offer(new Point2(x, y));
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Point2 now = queue.poll();
			int d = arr[now.x][now.y];
			int kx = now.x + dir[d][0];
			int ky = now.y + dir[d][1];
			if(!visit[kx][ky]) {
				queue.offer(new Point2(kx, ky));
				visit[kx][ky] = true; 
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(visit[nx][ny]) continue;
				if(i == 0) {
					if(arr[nx][ny] == 1) {
						queue.offer(new Point2(nx, ny));
						visit[nx][ny] = true; 
					}
				}else if(i == 1) {
					if(arr[nx][ny] == 0) {
						queue.offer(new Point2(nx, ny));
						visit[nx][ny] = true; 
					}
				}else if(i == 2) {
					if(arr[nx][ny] == 3) {
						queue.offer(new Point2(nx, ny));
						visit[nx][ny] = true; 
					}
				}else {
					if(arr[nx][ny] == 2) {
						queue.offer(new Point2(nx, ny));
						visit[nx][ny] = true; 
					}
				}
			}
		}
	}
}
