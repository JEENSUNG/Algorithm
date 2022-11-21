import java.util.*;
class N{
	int x;
	int y;
	int time;
	N(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
public class Main {
	static int answer = Integer.MAX_VALUE;
	static int r, c, endX, endY;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] arr;
	static boolean[][] visit, v;
	static Queue<N> queue;
	static Queue<N> temp;
	static boolean isOk = false;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			isOk = false;
			answer = Integer.MAX_VALUE;
			r = scan.nextInt();
			c = scan.nextInt();
			arr = new int[c][r];
			queue = new LinkedList<N>();
			visit = new boolean[c][r];
			v = new boolean[c][r];
			temp = new LinkedList<N>();
			for(int i = 0; i < c; i++) {
				String str = scan.next();
				for(int j = 0; j < r; j++) {
					if(str.charAt(j) == '.') {
						arr[i][j] = 0;
					}else if(str.charAt(j) == '*') {
						arr[i][j] = -1;
						v[i][j] = true;
						temp.offer(new N(i, j, 0));
					}
					else if(str.charAt(j) == '#') {
						arr[i][j] = -2;
					}
					else {
						arr[i][j] = 1;
						queue.offer(new N(i, j, 0));
						visit[i][j] = true;
					}
				}
			}
			while(!queue.isEmpty()) {
				int size = temp.size();
				while(size--> 0) {
					N now = temp.poll();
					for(int i = 0; i < 4; i++) {
						int nx = now.x + dir[i][0];
						int ny = now.y + dir[i][1];	
						if(nx < 0 || ny < 0 || nx >= c || ny >= r) continue;
						if(v[nx][ny])continue; 
						if(arr[nx][ny] == 0) {
							arr[nx][ny] = -1;
							temp.add(new N(nx, ny, 0));
							v[nx][ny] = true;
						}
					}
				}
				bfs();
				if(isOk) break;
			}
			if(!isOk)
				System.out.println("IMPOSSIBLE");
		}
	}
	static void bfs() {
		int size = queue.size();
		Queue<N> tempg = new LinkedList<N>();
		for(int j = 0; j < size; j++) {
			N now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= c || ny >= r) {
					answer = Math.min(answer, now.time);
					System.out.println(now.time + 1);
					isOk = true;
					return;
				}
				if(visit[nx][ny]) continue;
				if(arr[nx][ny] == 0) {
					tempg.offer(new N(nx, ny, now.time + 1));
					visit[nx][ny] = true;
				}
			}
		}
		queue.addAll(tempg);
	}

}