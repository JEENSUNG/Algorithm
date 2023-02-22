import java.util.*;
class Point{
	int x;
	int cost;
	Point(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}
public class Main {
	static int n, m;
	static int[] arr;
	static int[] dp;
	static boolean[] visit;
	static int answer = 0;
	static List<Point>[] list;
	static PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n + 1];
		list = new List[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<Point>();
		for(int i = 1; i <= m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			list[x].add(new Point(y, z));
			list[y].add(new Point(x, z));
		}
		for(int i = 1; i <= n; i++)
			arr[i] = 1000000000;
		visit = new boolean[n + 1];
		dfs(2);
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(go(1));
	}
	static int go(int x) {
		if(dp[x] != -1) return dp[x];
		if(x == 2) return dp[x] = 1;
		dp[x] = 0;
		for(Point now : list[x]) {
			if(arr[x] > arr[now.x])
				dp[x] += go(now.x);
		}
		return dp[x];
	}
	static void dfs(int start) {
		queue.offer(new Point(start, 0));
		arr[start] = 0;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			if(visit[now.x])
				continue;
			visit[now.x] = true;
			for(Point next : list[now.x]) {
				if(arr[next.x] > now.cost + next.cost) {
					arr[next.x] = now.cost + next.cost;
					queue.offer(new Point(next.x, arr[next.x]));
				}
			}
		}
	}
}
