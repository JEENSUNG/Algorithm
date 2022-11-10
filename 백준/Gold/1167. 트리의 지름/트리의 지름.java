import java.util.*;
class No{
	int x;
	int dir;
	No(int x, int dir){
		this.x = x;
		this.dir = dir;
	}
}
class Main{
	static int v;
	static int answer = 0;
	static int[] arr;
	static boolean[] visit;
	static PriorityQueue<No> queue;
	static List<No>[] list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		v = scan.nextInt();
		list = new List[v + 1];
		for(int i = 1; i <= v; i++)
			list[i] = new ArrayList<No>();
		arr = new int[v + 1];
		visit = new boolean[v + 1];
		int t = v;
		while(t--> 0) {
			int x = scan.nextInt();
			while(true) {
				int a = scan.nextInt();
				if(a == -1) break;
				int b = scan.nextInt();
				list[x].add(new No(a, b));
			}
		}
		for(int i = 1; i <= v; i++)
			if(!visit[i])
				bfs(i);
		visit = new boolean[v + 1];
		int b = 0;
		for(int i = 1; i <= v; i++) {
			if(answer < arr[i]) {
				answer = arr[i];
				b = i;
			}
		}
		bfs(b);
		for(int i = 1; i <= v; i++)
			answer = Math.max(answer, arr[i]);
		System.out.print(answer);
	}
	static void bfs(int x) {
		arr = new int[v + 1];
		queue = new PriorityQueue<No>((o1, o2) -> o2.dir - o1.dir);
		queue.offer(new No(x, 0));
		visit[x] = true;
		while(!queue.isEmpty()) {
			No now = queue.poll();
			for(No next : list[now.x]) {
				if(!visit[next.x]) {
					arr[next.x] = now.dir + next.dir;
					queue.offer(new No(next.x, arr[next.x]));
					visit[next.x] = true; 
				}
			}
		}
	}
}