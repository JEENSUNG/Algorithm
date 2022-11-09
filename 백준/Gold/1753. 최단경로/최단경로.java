import java.util.*;
class Nod{
	int x;
	int dir;
	Nod(int x, int dir){
		this.x = x;
		this.dir = dir;
	}
}
public class Main {
	static int v, e, start;
	static int[] arr;
	static List<Nod>[] list;
	static PriorityQueue<Nod> queue;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		v = scan.nextInt();
		e = scan.nextInt();
		start = scan.nextInt();
		list = new List[v + 1];
		for(int i = 0; i < v + 1; i++)
			list[i] = new ArrayList<Nod>();
		arr = new int[v + 1];
		for(int i = 0; i < v + 1; i++)
			arr[i] = 200000;
		for(int i = 0; i < e; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			list[u].add(new Nod(v, w));
		}
		dfs(start);
		for(int i = 1; i <= v; i++)
			if(arr[i] >= 200000) sb.append("INF\n");
			else sb.append(arr[i] + "\n");
		System.out.print(sb);
	}
	static void dfs(int x) {
		queue = new PriorityQueue<Nod>((o1, o2) -> o1.dir - o2.dir);
		visit = new boolean[v + 1];
		arr[x] = 0;
		queue.offer(new Nod(x, 0));
		while(!queue.isEmpty()) {
			Nod now = queue.poll();
			if(visit[now.x]) continue;
			visit[now.x]= true; 
			if(now.dir > arr[now.x]) continue;
			for(Nod next : list[now.x]) {
				if(now.dir + next.dir < arr[next.x]) {
					arr[next.x] = now.dir + next.dir;
					queue.offer(new Nod(next.x, arr[next.x]));
				}
			}
		}
	}
}
