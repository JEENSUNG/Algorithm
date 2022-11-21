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
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		arr = new int[r][c];
		queue = new LinkedList<N>();
		visit = new boolean[r][c];
		v = new boolean[r][c];
		temp = new LinkedList<N>();
		for(int i = 0; i < r; i++) {
			String str = scan.next();
			for(int j = 0; j < c; j++) {
				if(str.charAt(j) == 'D') {
					arr[i][j] = 2;
					endX = i;
					endY = j;
				}else if(str.charAt(j) == '.') {
					arr[i][j] = 0;
				}else if(str.charAt(j) == '*') {
					arr[i][j] = -1;
					v[i][j] = true;
					temp.offer(new N(i, j, 0));
				}
				else if(str.charAt(j) == 'X') {
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
			boolean isOk = false;
			int size = temp.size();
			while(size--> 0) {
				N now = temp.poll();
				for(int i = 0; i < 4; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];	
					if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
					if(v[nx][ny])continue; 
					if(arr[nx][ny] == 0) {
						arr[nx][ny] = -1;
						temp.add(new N(nx, ny, 0));
						v[nx][ny] = true;
					}
				}
			}
			bfs();
			for(int i = 0; i < 4; i++) {
				int nx = endX + dir[i][0];
				int ny = endY + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
				if(arr[nx][ny] == 0) {
					isOk = true;
					break;
				}
			}
			if(!isOk) break;
		}
		System.out.print("KAKTUS");
	}
	static void bfs() {
		int size = queue.size();
		Queue<N> temp = new LinkedList<N>();
		for(int j = 0; j < size; j++) {
			N now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
				if(visit[nx][ny]) continue;
				if(arr[nx][ny] == 2) {
					answer = Math.min(answer, now.time);
					System.out.print(now.time + 1);
					System.exit(0);
				}
				if(arr[nx][ny] == 0) {
					temp.offer(new N(nx, ny, now.time + 1));
					visit[nx][ny] = true;
				}
			}
		}
		queue.addAll(temp);
	}

}
