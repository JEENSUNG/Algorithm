import java.util.*;
class Main{
	static int n, k;
	static int[] time;
	static int[] degree; 
	static List<Integer>[] list;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			n = scan.nextInt();
			k = scan.nextInt();
			time = new int[n + 1];
			dp = new int[n + 1];
			for(int i = 1; i <= n; i++)
				time[i] = scan.nextInt();
			degree = new int[n + 1];
			list = new List[n + 1];
			for(int i = 1; i <= n; i++)
				list[i] = new ArrayList<Integer>();
			for(int i = 0; i < k; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				list[x].add(y);
				degree[y]++;
			}
			int end = scan.nextInt();
			topology();
			System.out.println(dp[end]);
		}
	}
	static void topology() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++)
			if(degree[i] == 0) {
				queue.offer(i);
				dp[i] = time[i];
			}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : list[now]) {
				dp[next] = Math.max(dp[now] + time[next], dp[next]);
				degree[next]--;
				if(degree[next] == 0)
					queue.offer(next);
			}
		}
	}
}