import java.awt.Point;
import java.util.*;
class Main{
	static int h, w;
	static char[][] arr;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static HashSet<Character> hashSet;
	static int answer = 0;
	static boolean[][] visit;
	static int dx; 
	static int dy;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0){
			h = scan.nextInt();
			w = scan.nextInt();
			dx = 0;
			dy = 0;
			answer = 0;
			hashSet = new HashSet<Character>();
			arr = new char[h][w];
			visit = new boolean[h][w];
			for(int i = 0; i < h; i++){
				String str = scan.next();
				for(int j = 0; j < w; j++)
					arr[i][j] = str.charAt(j);
			}
			String s = scan.next().toUpperCase();
			if(!s.equals("0".toUpperCase()))
				for(int i = 0; i < s.length(); i++)
					hashSet.add(s.charAt(i));
			while(dx < h) {
				if((dx == 0 || dy == 0 || dx == h - 1 || dy == w - 1) && arr[dx][dy] == '.') {
					bfs(dx, dy);
				}else if((dx == 0 || dy == 0 || dx == h - 1 || dy == w - 1) && arr[dx][dy] == '$') {
					answer++;
					arr[dx][dy] = '.';
					bfs(dx, dy);
				}else if((dx == 0 || dy == 0 || dx == h - 1 || dy == w - 1) && arr[dx][dy] >= 'a' && arr[dx][dy] <= 'z') {
					String b = "" + arr[dx][dy];
					b = b.toUpperCase();
					hashSet.add(b.charAt(0));
					arr[dx][dy] = '.';
					bfs(dx,dy);
					dx = 0;
					dy = 0;
				}else if((dx == 0 || dy == 0 || dx == h - 1 || dy == w - 1) && arr[dx][dy] >= 'A' && arr[dx][dy] <= 'Z' && hashSet.contains(arr[dx][dy])) {
					arr[dx][dy] = '.';
					bfs(dx, dy);
				}
				dy++;
				if(dy == w) {
					dx++;
					dy = 0;
				}
			}		
			System.out.println(answer);
		}
	}
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visit = new boolean[h][w];
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
				if(visit[nx][ny]) continue;
				if(arr[nx][ny] == '*') continue;
				if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z' && !hashSet.contains(arr[nx][ny])) continue;
				if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z' && hashSet.contains(arr[nx][ny])) {
					queue.offer(new Point(nx, ny));
					arr[nx][ny] = '.';
					visit[nx][ny] = true;
				}else if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'z') {
					String c = "" + arr[nx][ny];
					c = c.toUpperCase();
					hashSet.add(c.charAt(0));
					arr[nx][ny] = '.';
					queue.offer(new Point(nx, ny));
					dx = 0;
					dy = 0;
					visit = new boolean[h][w];
					visit[nx][ny] = true;
				}else if(arr[nx][ny] == '$') {
					answer++;
					arr[nx][ny] = '.';
					visit[nx][ny] = true;
					queue.offer(new Point(nx, ny));
				}
				else {
					queue.offer(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
}