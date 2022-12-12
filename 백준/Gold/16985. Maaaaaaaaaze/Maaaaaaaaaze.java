import java.util.*;
class Point{
	int z;
	int x;
	int y;
	int cost;
	Point(int z, int x, int y, int cost){
		this.z = z;
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
class Main{
	static int[][][] arr = new int[5][5][5];
	static int[][][] map = new int[5][5][5];
	static boolean[][][] visit = new boolean[5][5][5];
	static boolean[] v = new boolean[5];
	static int[][] dir = {{-1 ,0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
	static int[] ans = new int[5];
	static int[] an = new int[5];
	static int[][][][] temp = new int[5][4][5][5];
	static int answer = Integer.MAX_VALUE;
	static Queue<Point> queue;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				for(int k = 0; k < 5; k++)
					arr[i][j][k] = scan.nextInt();
		scan.close();
		for(int index = 0; index < 5; index++) {
			for(int d = 0; d < 4; d++) {
				Queue<Integer> tt = new LinkedList<>();
				if(d == 0) {
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
							temp[index][d][i][j] = arr[index][i][j];
				}else if(d == 1) {
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
							tt.offer(arr[index][i][j]);
					for(int i = 4; i >= 0; i--) 
						for(int j = 0; j < 5; j++)
							temp[index][d][j][i] = tt.poll();
				}else if(d == 2) {
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
							tt.offer(arr[index][i][j]);
					for(int i = 4; i >= 0; i--)
						for(int j = 4; j >= 0; j--)
							temp[index][d][i][j] = tt.poll();
				}else {
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 5; j++)
							tt.offer(arr[index][i][j]);
					for(int i = 0; i < 5; i++)
						for(int j = 4; j >= 0; j--)
							temp[index][d][j][i] = tt.poll();
				}
			}
		}
		bruteForce(0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(answer);
	}
	//회전
	static void bruteForce(int count) {
		if(count == 5) {
			backTracking(0);
			return;
		}
		for(int i = 0; i < 4; i++) {
			ans[count] = i;
			bruteForce(count + 1);
		}
	}
	//순서 바꾸기
	static void backTracking(int count) {
		if(count == 5) {
			bfs();
			return;
		}
		for(int i = 0; i < 5; i++) {
			if(!v[i]) {
				v[i] = true;
				an[count] = i;
				backTracking(count + 1);
				v[i] = false;
			}
		}
	}
	static void bfs() {
		int index = 0;
		map = new int[5][5][5];
		while(index < 5) {
			int direction = ans[index];
			int tir = an[index];
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					map[tir][i][j] = temp[index][direction][i][j];
			index++;
		}
		if(map[0][0][0] == 1)
			bfs2(0, 0);
		else if(map[0][0][4] == 1)
			bfs2(0, 4);
		else if(map[0][4][0] == 1)
			bfs2(4, 0);
		else if(map[0][4][4] == 1)
			bfs2(4, 4);
	}
	static void bfs2(int x, int y) {
		queue = new LinkedList<Point>();
		visit = new boolean[5][5][5];
		queue.offer(new Point(0, x, y, 0));
		visit[0][x][y] = true;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			if(now.z == 4) {
				if(x == now.x || y == now.y)continue; 
				if((now.x == 4 && now.y == 4) || (now.x == 4 && now.y == 0) || (now.x == 0 && now.y == 0) || (now.x == 0 && now.y == 4)) {
					answer = Math.min(answer, now.cost);
					break;
				}
			}
			for(int i = 0; i < 6; i++) {
				int nz = now.z + dir[i][0];
				int nx = now.x + dir[i][1];
				int ny = now.y + dir[i][2];
				if(nz < 0 || nx < 0 || ny < 0 || nz >= 5 || nx >= 5 || ny >= 5)
					continue;
				if(visit[nz][nx][ny]) continue;
				if(map[nz][nx][ny] == 0) continue;
				queue.offer(new Point(nz, nx, ny, now.cost + 1));
				visit[nz][nx][ny] = true;
			}
		}
	}
}