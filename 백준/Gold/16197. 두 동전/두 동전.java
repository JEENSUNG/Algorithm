import java.util.*;
class FF{
	int x;
	int y;
	int px;
	int py;
	int time;
	FF(int x, int y, int px, int py, int time){
		this.x = x;
		this.y = y;
		this.px = px;
		this.py = py;
		this.time = time;
	}
}
public class Main {
	static int x, y, px, py;
	static int n, m;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] arr;
	static int answer = Integer.MAX_VALUE;
	static boolean[][][][]visit;
	static Queue<FF> queue = new LinkedList<FF>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m][n][m];
		boolean isOk = false;
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == '#')
					arr[i][j] = 1;
				else if(str.charAt(j) == 'o') {
					if(isOk) {
						px = i;
						py = j;
					}else {
						x = i;
						y = j;
						isOk = true;
					}
				}
			}
		}
		bfs();
		if(answer > 10)
			System.out.println(-1);
		else System.out.println(answer);
	}
	static void bfs() {
		queue.offer(new FF(x, y, px, py, 0));
		visit[x][y][px][py] = visit[px][py][x][y] = true;
		while(!queue.isEmpty()) {
			FF now = queue.poll();
			if(now.time > 10)
				continue;
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				int pnx = now.px + dir[i][0];
				int pny = now.py + dir[i][1];
				if((nx < 0 || ny < 0 || nx >= n || ny >= m) && (pnx < 0 || pny < 0 || pnx >= n || pny >= m))
					continue;
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					if(pnx >= 0 && pny >= 0 && pnx < n && pny < m) {
						answer = Math.min(answer, now.time + 1);
						continue;
					}
				}if(pnx < 0 || pny < 0 || pnx >= n || pny >= m) {
					if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
						answer = Math.min(answer, now.time + 1);
						continue;
					}
				}
				if(visit[nx][ny][pnx][pny] || visit[pnx][pny][nx][ny])
					continue;
				if(arr[nx][ny] == 1 && arr[pnx][pny] == 1)
					continue;
				if(arr[nx][ny] == 0 && arr[pnx][pny] == 0) {
					visit[nx][ny][pnx][pny] = visit[pnx][pny][nx][ny] = true;
					queue.offer(new FF(nx, ny, pnx, pny, now.time + 1));
				}else if(arr[nx][ny] == 0 && arr[pnx][pny] == 1) {
					visit[nx][ny][now.px][now.py] = visit[now.px][now.py][nx][ny] = true;
					queue.offer(new FF(nx, ny, now.px, now.py, now.time + 1));
				}else if(arr[nx][ny] == 1 && arr[pnx][pny] == 0) {
					visit[now.x][now.y][pnx][pny] = visit[pnx][pny][now.x][now.y] = true;
					queue.offer(new FF(now.x, now.y, pnx, pny, now.time + 1));
				}
			}
		}
	}
}
