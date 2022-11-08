import java.util.*;
class Node{
	int x;
	int dir;
	Node(int x, int dir){
		this.x = x;
		this.dir = dir;
	}
}
class Main{
	static int n, e, v1, v2;
	static PriorityQueue<Node> queue;
	static int[] map;
	static List<Node>[] list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		e = scan.nextInt();
		map = new int[n + 1];
		list = new List[n + 1];
		for(int i = 0; i <= n; i++)
			map[i] = 10000000;
		for(int i = 0; i < n + 1; i++)
			list[i] = new ArrayList<Node>();
		for(int i = 0; i < e; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		v1 = scan.nextInt();
		v2 = scan.nextInt();
		int path1 = dfs(1, v1) + dfs(v1, v2) + dfs(v2, n);
		int path2 = dfs(1, v2) + dfs(v2, v1) + dfs(v1, n);
		int answer = Math.min(path1, path2);
		if(answer >= 10000000) System.out.println(-1);
		else System.out.println(answer);
	}
	private static int dfs(int x, int end) {
		int[] ans = map.clone();
		queue = new PriorityQueue<>((o1, o2) -> (o1.dir - o2.dir));
		queue.offer(new Node(x, 0));
		ans[x] = 0;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(ans[now.x] < now.dir)
				continue;
			for(Node next : list[now.x]) {
				if(now.dir + next.dir < ans[next.x]) {
					ans[next.x] = now.dir + next.dir;
					queue.offer(new Node(next.x, ans[next.x]));
				}
			}
		}
		return ans[end];
	}
	
}