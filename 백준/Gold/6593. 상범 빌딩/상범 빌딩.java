import java.util.*;
class B{
	int z;
	int x;
	int y;
	int time;
	B(int z, int x, int y, int time){
		this.z = z;
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
public class Main {
	static int[][][] arr;
	static boolean[][][] visit;
	static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}};
	static int n, r, c, answer;
	static Queue<B> queue;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			answer = Integer.MAX_VALUE;
			n = scan.nextInt();
			r = scan.nextInt();
			c = scan.nextInt();
			if(n == 0 && r == 0 && c == 0) break;
			arr = new int[n][r][c];
			visit = new boolean[n][r][c];
			queue = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < r; j++) {
					String str = scan.next();
					for(int k = 0; k < c; k++) {
						if(str.charAt(k) == 'S') {
							queue.offer(new B(i, j, k, 0));
							visit[i][j][k] = true;
						}
						else if(str.charAt(k) == '.')
							arr[i][j][k] = 0;
						else if(str.charAt(k) == '#')
							arr[i][j][k] = 1;
						else
							arr[i][j][k] = 2;
					}
				}
			}
			bfs();
			if(answer == Integer.MAX_VALUE)
				System.out.println("Trapped!");
			else System.out.println("Escaped in " + answer + " minute(s).");
		}
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			B now = queue.poll();
			if(arr[now.z][now.x][now.y] == 2) {
				answer = Math.min(answer, now.time);
				continue;
			}
			for(int i = 0; i < 6; i++) {
				int nz = now.z + dir[i][0];
				int nx = now.x + dir[i][1];
				int ny = now.y + dir[i][2];
				if(nz < 0 || nx < 0 || ny < 0 || nz >= n || nx >= r || ny >= c)
					continue;
				if(visit[nz][nx][ny]) continue;
				if(arr[nz][nx][ny] == 2 || arr[nz][nx][ny] == 0) {
					visit[nz][nx][ny] = true;
					queue.offer(new B(nz, nx, ny, now.time + 1));
				}
			}
		}
	}
}
