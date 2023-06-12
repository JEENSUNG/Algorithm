import java.util.*;
class Mutal{
	int x;
	int y;
	int z;
	int cost;
	Mutal(int x, int y, int z, int cost){
		this.x = x;
		this.y = y;
		this.z = z;
		this.cost = cost;
	}
}
public class Main {
	static int n;
	static int[] arr;
	static int[][] dir = {{-9, -3, -1}, {-3, -1, -9}, {-9, -1, -3}, {-3, -9, -1}, {-1, -3, -9}, {-1, -9, -3}};
	static int answer = Integer.MAX_VALUE;
	static boolean[][][] visit;
	static Queue<Mutal> queue = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n];
		for(int i = 0; i < n;i++)
			arr[i] = scan.nextInt();
		visit = new boolean[arr[0] + 1][61][61];
		if(n == 1) {
			visit[arr[0]][0][0] = true;
			queue.offer(new Mutal(arr[0], 0, 0, 0));
		}else if(n == 2) {
			visit[arr[0]][arr[1]][0] = true;
			queue.offer(new Mutal(arr[0], arr[1], 0, 0));
		}else {
			visit[arr[0]][arr[1]][arr[2]] = true;
			queue.offer(new Mutal(arr[0], arr[1], arr[2], 0));
		}
		bfs();
		System.out.println(answer);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Mutal now = queue.poll();
			if(now.x == 0 && now.y == 0 && now.z == 0)
				answer = Math.min(answer, now.cost);
			for(int i = 0; i < 6; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				int nz = now.z + dir[i][2];
				if(nx < 0) nx = 0;
				if(ny < 0) ny = 0;
				if(nz < 0) nz = 0;
				if(visit[nx][ny][nz]) continue;
				visit[nx][ny][nz] = true;
				queue.offer(new Mutal(nx, ny, nz, now.cost + 1));
			}
		}
	}
}
