import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], zeroCnt = 0, ans = Integer.MAX_VALUE;
	static List<Point> list;
	static Point sel[];
	static class birus{
		int r, c, time;
		public birus(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					zeroCnt ++;
				if(map[i][j] == 2)
					list.add(new Point(i, j));
			}
		}
		sel = new Point[M];
		comb(0, 0);
		System.out.println((ans==Integer.MAX_VALUE)? -1 : ans);
	}
	private static void comb(int idx, int s_idx) {
		if(s_idx == M) {
			bfs();
			return;
		}
		if(idx == list.size())
			return;
		sel[s_idx] = list.get(idx);
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
	
	private static void bfs() {
		int zero = zeroCnt;
		boolean visit[][] = new boolean[N][N];
		Queue<birus> queue = new LinkedList<birus>();
		for (int i = 0; i < M; i++) {
			visit[sel[i].x][sel[i].y] = true;
			queue.add(new birus(sel[i].x, sel[i].y, 0));
		}
		int time = 0;
		while(!queue.isEmpty()) {
			birus b = queue.poll();
			time = b.time;
			for (int d = 0; d < 4; d++) {
				int nr = b.r + dr[d];
				int nc = b.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 1)
					continue;
				visit[nr][nc] = true;
				queue.add(new birus(nr, nc, b.time+1));
				if(map[nr][nc] == 0)
					zero --;
			}
		}
		if(zero == 0) {
			ans = Math.min(ans, time);
		}
	}
}