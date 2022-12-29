import java.util.*;
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m;
	static int[][] arr, answer, map;
	static boolean[][] visit;
	static int temp;
	static HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	static Queue<Point> queue = new LinkedList<Point>();
	static int id = 2;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		answer = new int[n][m];
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1) continue;
				if(!visit[i][j]) {
					temp = 1;
					map[i][j] = id;
					visit[i][j] = true;
					bfs(i, j);
					hashMap.put(id, temp);	
					id++;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) continue;
				HashSet<Integer> temp = new HashSet<Integer>();
				for(int z = 0; z < 4; z++) {
					int nx = i + dir[z][0];
					int ny = j + dir[z][1];
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if(map[nx][ny] == 0) continue;
					temp.add(map[nx][ny]);
				}
				for(Integer now : temp) 
					answer[i][j] += hashMap.get(now);
				answer[i][j]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for(int j = 0; j < m; j++) {
				if(answer[i][j] >= 10)
					answer[i][j] = answer[i][j] % 10;
				sb.append(answer[i][j]);
			}
			System.out.println(sb);
		}
	}
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(visit[nx][ny]) continue;
				if(arr[nx][ny] == 0) {
					visit[nx][ny] = true;
					queue.offer(new Point(nx, ny));
					map[nx][ny] = id;
					temp++;
				}
			}
		}
	}
}
