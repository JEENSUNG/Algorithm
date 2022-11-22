import java.util.*;
class Node{
	int x;
	int y;
	int dir;
	int cnt;
	Node(int x, int y, int dir, int cnt){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}
}
class Main{
	static int n;
	static int[][] arr;
	static boolean[][][]visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static ArrayList<Node> list;
	static PriorityQueue<Node> queue;
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n][n];
		visit = new boolean[n][n][4];
		int startX = 0;
		int startY = 0;
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < n; j++) {
				if(str.charAt(j) == '*')
					arr[i][j] = -1; //벽
				else if(str.charAt(j) == '!') 
					arr[i][j] = 1; //거울
				else if(str.charAt(j) == '.')
					arr[i][j] = 0; //암것도없음
				else {
					arr[i][j] = 2;//문
					startX = i;
					startY = j;
				}
			}
		}
		arr[startX][startY] = -2;
		bfs(startX, startY);
	}
	static void bfs(int x, int y) {
		queue = new PriorityQueue<Node>((o1, o2) -> o1.cnt - o2.cnt);
		queue.offer(new Node(x, y, 4, 0));
		for(int i = 0; i < 4; i++)
			visit[x][y][i] = true;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(arr[now.x][now.y] == 2) {
				System.out.println(now.cnt);
				break;
			}
			if(now.dir == 4) {
				for(int i = 0; i < 4; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if(arr[nx][ny] != -1) {
						visit[nx][ny][i] = true;
						queue.offer(new Node(nx, ny, i, now.cnt));
					}
				}
			}else {
				if(arr[now.x][now.y] == 1) {
					if(now.dir == 2 || now.dir == 3) {
						for(int i = 0; i < 2; i++) {
							int nx = now.x + dir[i][0];
							int ny = now.y + dir[i][1];
							if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
							if(arr[nx][ny] != -1 && !visit[nx][ny][i]) {
								queue.offer(new Node(nx, ny, i, now.cnt + 1));
								visit[nx][ny][i] = true;
							}
						}
					}
					else {
						for(int i = 2; i < 4; i++) {
							int nx = now.x + dir[i][0];
							int ny = now.y + dir[i][1];
							if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
							if(arr[nx][ny] != -1 && !visit[nx][ny][i]) {
								queue.offer(new Node(nx, ny, i, now.cnt + 1));
								visit[nx][ny][i] = true;
							}
						}
					}
				}
				int nx = now.x + dir[now.dir][0];
				int ny = now.y + dir[now.dir][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(arr[nx][ny] != -1 && !visit[nx][ny][now.dir]) {
					queue.offer(new Node(nx, ny, now.dir, now.cnt));
					visit[nx][ny][now.dir] = true;
				}
			}
		}
	}
}