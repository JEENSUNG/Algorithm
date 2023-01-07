import java.util.*;
class Diff{
	int x;
	int cost;
	Diff(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}
public class Main {
	static int n, m, t;
	static int s, g, h;
	static List<Diff>[] list;
	static List<Integer> aList;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while(q--> 0) {
			n = scan.nextInt();
			m = scan.nextInt();
			t = scan.nextInt();
			s = scan.nextInt();
			g = scan.nextInt();
			h = scan.nextInt();
			list = new List[n + 1];
			visit = new boolean[n + 1];
			arr = new int[n + 1];
			aList = new ArrayList<Integer>();
			for(int i = 0; i <= n; i++)
				list[i] = new ArrayList<Diff>();
			for(int i = 0; i < m; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int d = scan.nextInt();
				list[a].add(new Diff(b, d));
				list[b].add(new Diff(a, d));
			}
			for(int i = 0; i < t; i++)
				aList.add(scan.nextInt());
			List<Integer> temp = new ArrayList<Integer>();
			for(int next : aList) {
				long res1 = dfs(s, g) + dfs(g, h) + dfs(h, next);
				long res2 = dfs(s, h) + dfs(h, g) + dfs(g, next);
				long res3 = dfs(s, next);
				if(Math.min(res1, res2) == res3) 
					temp.add(next);
			}
			Collections.sort(temp);
			for(int now : temp)
				System.out.print(now + " ");
		}
		scan.close();

	}
	static int dfs(int start, int end) {
		PriorityQueue<Diff> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
		queue.offer(new Diff(start, 0));
		visit = new boolean[n + 1];
		for(int i = 0; i <= n; i++)
			arr[i] = 10000000;
		arr[start] = 0;
		while(!queue.isEmpty()) {
			Diff now = queue.poll();
			if(visit[now.x])continue;
			visit[now.x] = true;
			for(Diff next : list[now.x]) {
				if(arr[next.x] > now.cost + next.cost) {
					arr[next.x] = now.cost + next.cost;
					queue.offer(new Diff(next.x, arr[next.x]));
				}
			}
		}
		return arr[end];
	}
}
