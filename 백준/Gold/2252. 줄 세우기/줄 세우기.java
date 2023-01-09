import java.util.*;
public class Main {
	static int n, m;
	static int[] degree;
	static List<Integer>[] list;
	static List<Integer> answer = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		list = new List[n + 1];
		degree = new int[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			list[a].add(b);
			degree[b]++;
		}
		topology();
		for(int i : answer)
			System.out.print(i + " ");
	}
	static void topology() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++)
			if(degree[i] == 0)
				queue.offer(i);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			answer.add(now);
			for(int next : list[now]) {
				degree[next]--;
				if(degree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
}
