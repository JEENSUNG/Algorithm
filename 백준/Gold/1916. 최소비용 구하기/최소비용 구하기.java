import java.util.*;
class Min{
	int x;
	int dir;
	Min(int x, int dir) {
		this.x = x;
		this.dir = dir;
	}
}
public class Main {
	static int n, m, start, end;
	static List<Min>[] list;
	static int[] arr;
	static boolean[] visit;
	static PriorityQueue<Min> queue;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		list = new List[n + 1];
		visit = new boolean[n + 1];
		queue = new PriorityQueue<Min>((o1, o2) -> (o1.dir - o2.dir));
		for(int i = 0; i < n + 1; i++)
			list[i] = new ArrayList<Min>();
		arr = new int[n + 1];
		for(int i = 0; i < n + 1; i++)
			arr[i] = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			list[a].add(new Min(b, c));
		}
		start = scan.nextInt();
		end = scan.nextInt();
		dfs(start, end);
	}
	static void dfs(int x, int y) {
		arr[x] = 0;
		queue.offer(new Min(x, 0));
		while(!queue.isEmpty()) {
			Min now = queue.poll();
			if(visit[now.x])continue;
			visit[now.x] = true; 
			if(now.dir < arr[now.x])continue; 
			for(Min next : list[now.x]) {
				if(arr[next.x] > now.dir + next.dir) {
					arr[next.x] = now.dir + next.dir;
					queue.offer(new Min(next.x, arr[next.x]));
				}
			}
		}
		System.out.println(arr[y]);
	}

}
