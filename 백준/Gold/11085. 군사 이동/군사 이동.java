import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Edge{
	int from;
	int to;
	int cost;
	Edge(int from, int to, int cost){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}
class Main{
	static int p, w, c, v;
	static int[] parents;
	static int[] arr;
	static int answer = 0;
	static PriorityQueue<Edge> queue = new PriorityQueue<Edge>((o1, o2) -> (o2.cost - o1.cost));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		parents = new int[p];
		c = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		for(int i = 0; i < p; i++)
			parents[i] = i;
		for(int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			queue.offer(new Edge(from, to, cost));
		}
		while(!queue.isEmpty()) {
			Edge now = queue.poll();
			union(now.from, now.to);
			if(find(c) == find(v)) {
				System.out.println(now.cost);
				break;
			}
		}
	}
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb)
			parents[pb] = pa;
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
}