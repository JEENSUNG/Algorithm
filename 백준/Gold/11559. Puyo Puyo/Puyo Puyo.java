import java.awt.Point;
import java.util.*;
class Main{
	static char[][] arr;
	static boolean[][] visit;
	static boolean isOk;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int answer = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		arr = new char[12][6];
		for(int i = 0; i < 12; i++) {
			String str = scan.next();
			for(int j = 0; j < 6; j++)
				arr[i][j] = str.charAt(j);
		}
		while(true) {
			isOk = false;
			visit = new boolean[12][6];
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(arr[i][j] != '.' && !visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			move();
			if(isOk) answer++;
			else break;
		}
		System.out.println(answer);
	}
	static void move() {
		for(int j = 0; j < 6; j++) {
			for(int i = 10; i >= 0; i--) {
				if(arr[i][j] != '.') {
					if(arr[i + 1][j] == '.') {
						for(int k = i + 1; k < 12; k++) {
							if(k == 11 && arr[k][j] == '.') {
								arr[k][j] = arr[i][j];
								arr[i][j] = '.';
							}
							else if(arr[k][j] != '.') {
								arr[k - 1][j] = arr[i][j];
								arr[i][j] = '.';
								break;
							}
						}
					}
				}
			}
		}
	}
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		Queue<Point> temp = new LinkedList<>();
		temp.offer(new Point(x, y));
		queue.offer(new Point(x, y));
		visit[x][y] = true;
		int count = 1;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
				if(visit[nx][ny]) continue;
				if(arr[x][y] != arr[nx][ny]) continue;
				queue.offer(new Point(nx, ny));
				temp.offer(new Point(nx, ny));
				visit[nx][ny] = true;
				count++;
			}
		}
		if(count >= 4) {
			isOk = true;
			while(!temp.isEmpty()) {
				Point now = temp.poll();
				arr[now.x][now.y] = '.'; 
			}
		}
	}
}