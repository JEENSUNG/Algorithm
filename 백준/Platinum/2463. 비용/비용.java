import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point{
	int x;
	int y;
	int cost;
	Point(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class Main {
	static int n, m;
	static int[] parents;
	static int[] child;
	static List<Point> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		long sum = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sum += c;
			list.add(new Point(Math.min(a, b), Math.max(a, b), c));
		}
		parents = new int[n + 1];
		child = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
			child[i] = 1;
		}
		long answer = 0;
		Collections.sort(list, (o1, o2) -> (o2.cost - o1.cost));
		for(Point now : list) {
			answer += sum * union(now.x, now.y);
			answer %= 1000000000;
			sum -= now.cost;
		}
		System.out.println(answer);
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
	static long union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			parents[pb] = pa;
			long cnt = (long) child[pa] * child[pb];
			child[pa] += child[pb];
			child[pb] = 0;
			return cnt;
		}
		return 0;
	}
}
