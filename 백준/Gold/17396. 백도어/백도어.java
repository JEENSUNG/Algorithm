import java.util.*;
class Back implements Comparable<Back>{
	int x;
	long cost;
	Back(int x, long cost){
		this.x = x;
		this.cost = cost;
	}
	@Override
	public int compareTo(Back o) {
		if(this.cost - o.cost > 0) return 1;
		return -1;
	}
}
public class Main {
	static int n, m;
	static long answer = Long.MAX_VALUE;
	static int[] arr;
	static List<Back>[] list;
	static long[] map;
	static PriorityQueue<Back> queue = new PriorityQueue<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n];
		map = new long[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		list = new List[n];
		for(int i = 0; i < n; i++)
			list[i] = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			list[x].add(new Back(y, z));
			list[y].add(new Back(x, z));
		}
		for(int i = 1; i < n; i++)
			map[i] = Long.MAX_VALUE;
		queue.offer(new Back(0, 0));
		dijkstra();
		if(answer != Long.MAX_VALUE)
			System.out.println(answer);
		else System.out.println(-1);
	}
	static void dijkstra() {
		while(!queue.isEmpty()) {
			Back now = queue.poll();
			if(now.cost > map[now.x]) continue;
			if(now.x == n - 1)
				answer = Math.min(answer, now.cost);
			for(Back next : list[now.x]) {
				if(arr[next.x] == 1 && next.x != n - 1) continue;
				if(map[next.x] > next.cost + now.cost) {
					map[next.x] = next.cost + now.cost;
					queue.offer(new Back(next.x, map[next.x]));
				}
			}
		}
	}
}
