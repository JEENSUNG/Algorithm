import java.util.*;
class Node{
	int start;
	int end;
	int cost;
	Node(int start, int end, int cost){
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}
public class Main {
	static int n, m;
	static int[] parents;
	static PriorityQueue<Node> queue;
	static List<Node> list = new ArrayList<Node>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		parents = new int[n + 1];
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			list.add(new Node(x, y, z));
		}
		for(int i = 1; i <= n; i++) 
			parents[i] = i;
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		int answer = 0;
		int max = 0;
		for(int i = 0; i < list.size(); i++) {
			Node now = list.get(i);
			if(find(now.start) != find(now.end)) {
				answer += now.cost;
				union(now.start, now.end);
				max = now.cost;
			}
		}
		System.out.println(answer - max);
	}
	static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y)
			parents[y] = x;
	}
}
