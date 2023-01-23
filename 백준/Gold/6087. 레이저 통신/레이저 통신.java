import java.util.*;
class NN{
	int x;
	int y;
	int d;
	int cost;
	NN(int x, int y, int d, int cost){
		this.x = x;
		this.y = y;
		this.d = d;
		this.cost = cost;
	}
}
public class Main {
	static int w, h, sx, sy;
	static int[][] arr, map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		w = scan.nextInt();
		h = scan.nextInt();
		arr = new int[h][w];
		int ex = 0, ey = 0;
		boolean isOk = false;
		for(int i = 0; i < h; i++) {
			String str = scan.next();	
			for(int j = 0; j < w; j++) {
				if(str.charAt(j) == '*') {
					arr[i][j] = -1;
				}
				if(str.charAt(j) == 'C') {
					arr[i][j] = 2;
					if(!isOk) {
						sx = i;
						sy = j;
						isOk = true;
					}else {
						ex = i;
						ey = j;
					}
				}
			}
		}
		bfs(sx, sy);
		System.out.println(map[ex][ey]);
	}
	static void bfs(int x, int y) {
		PriorityQueue<NN> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
		queue.offer(new NN(x, y, -1, 0));
		map = new int[h][w];
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				map[i][j] = 987654321;
		map[x][y] = 0;
		while(!queue.isEmpty()) {
			NN now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;
				if(arr[nx][ny] == -1)
					continue;
				if(now.d == -1) {
					map[nx][ny] = now.cost;
					queue.offer(new NN(nx, ny, i, map[nx][ny]));
				}else {
					if(now.d != i) {
						if(map[nx][ny] >= now.cost + 1) {
							map[nx][ny] = now.cost + 1;
							queue.offer(new NN(nx, ny, i, map[nx][ny]));
						}
					}else {
						if(map[nx][ny] >= now.cost) {
							map[nx][ny] = now.cost;
							queue.offer(new NN(nx, ny, i, map[nx][ny]));
						}
					}
				}
			}
		}
	}
}
