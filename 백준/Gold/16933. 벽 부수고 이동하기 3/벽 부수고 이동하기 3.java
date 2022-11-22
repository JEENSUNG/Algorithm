import java.util.*;
class B{
	int x;
	int y;
	int z;
	int day;
	int time;
	B(int x, int y, int z, int day, int time){
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
		this.time = time;
	}
}
public class Main {
	static int n, m, k;
	static int[][] arr;
	static boolean[][][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Queue<B> queue;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m][k + 1];
		queue = new LinkedList<B>();
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		bfs();
		if(answer == Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(answer);
	}
	static void bfs() {
		queue.offer(new B(0, 0, k, 0, 1));
		visit[0][0][k] = true;
		while(!queue.isEmpty()) {
			B now = queue.poll();
			if(now.x == n - 1 && now.y == m - 1) {
				answer = Math.min(answer, now.time);
				break;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(now.z > 0 &&!visit[nx][ny][now.z - 1] && arr[nx][ny] == 1 && now.day % 2 == 0) {
					queue.offer(new B(nx, ny, now.z - 1, now.day + 1, now.time + 1));
					visit[nx][ny][now.z - 1] = true;
				}else if(!visit[nx][ny][now.z] && arr[nx][ny] == 0) {
					queue.offer(new B(nx, ny, now.z, now.day + 1, now.time + 1));
					visit[nx][ny][now.z] = true;
				}
				if(arr[nx][ny] == 1 && now.day % 2 == 1)
					queue.offer(new B(now.x, now.y, now.z, now.day + 1, now.time + 1));	
			}
		}
	}
}
