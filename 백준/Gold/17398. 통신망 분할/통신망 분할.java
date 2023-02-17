import java.awt.Point;
import java.util.*;
public class Main {
	static int n, m, q;
	static int[] parents;
	static boolean[] visit;
	static List<Point>[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		q = scan.nextInt();
		parents = new int[n + 1];
		Arrays.fill(parents, -1);
		list = new List[m + 1];
		visit = new boolean[m + 1];
		for(int i = 1; i <= m; i++)
			list[i] = new ArrayList<Point>();
		for(int i = 1; i <= m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			list[i].add(new Point(a, b));
		}
		long answer = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 1; i <= q; i++) {
			int t = scan.nextInt();
			stack.add(t);
			visit[t] = true;
		}
		for(int i = 1; i <= m; i++) {
			if(visit[i]) continue;
			union(list[i].get(0).x, list[i].get(0).y);
		}
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(find(list[now].get(0).x) == find(list[now].get(0).y)) {
				union(list[now].get(0).x, list[now].get(0).y);
			}else {
				answer += (long) parents[find(list[now].get(0).x)] * (long)parents[find(list[now].get(0).y)];
				union(list[now].get(0).x, list[now].get(0).y);
			}
		}
		System.out.println(answer);
	}
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			parents[pa] += parents[pb];
			parents[pb] = pa;
		}
	}
	static int find(int x) {
		if(parents[x] < 0)
			return x;
		return parents[x] = find(parents[x]);
	}
}
