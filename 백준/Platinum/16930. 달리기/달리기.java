import java.util.*;
class Point{
	int x;
	int y;
	int time;
	Point(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
public class Main {
	static int n, m, k;
	static int s1, s2, e1, e2;
	static int[][] arr;
	static int[][] visit;
	static int answer = Integer.MAX_VALUE;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Queue<Point> queue = new LinkedList<Point>();
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		arr = new int[n][m];
		visit = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == '#')
					arr[i][j] = 1;
			}
		}
		s1 = scan.nextInt() - 1;
		s2 = scan.nextInt() - 1;
		e1 = scan.nextInt() - 1;
		e2 = scan.nextInt() - 1;
		bfs(s1, s2);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	static void bfs(int x, int y) {
		visit[x][y] = 0;
		queue.offer(new Point(x, y, 0));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			if(now.x == e1 && now.y == e2) {
				answer = Math.min(answer, now.time);
				continue;
			}
			for(int i = 0; i < 4; i++) {
				for(int a = 1; a <= k; a++) {
					int nx = now.x + (dir[i][0] * a);
					int ny = now.y + (dir[i][1] * a);
					if(nx < 0 || ny < 0 || nx >= n || ny >= m)
						break;
					if(arr[nx][ny] == 1)
						break;
					if(visit[nx][ny] > 0 && visit[nx][ny] < now.time + 1)
						break;
					if(visit[nx][ny] == 0) {
						queue.offer(new Point(nx, ny, now.time + 1));
						visit[nx][ny] = now.time + 1;
					}else if(visit[nx][ny] > now.time + 1) {
						visit[nx][ny] = now.time + 1;
						queue.offer(new Point(nx, ny, now.time + 1));
					}
				}
			}
		}
	}
}
