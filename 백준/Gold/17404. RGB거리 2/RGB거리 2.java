import java.util.*;
class Dickstra{
	int x;
	int y;
	int cost;
	Dickstra(int x, int y,int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class Main {
	static int n;
	static PriorityQueue<Dickstra> queue;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[][] arr = new int[n][3];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < 3; j++)
				arr[i][j] = scan.nextInt();
		int[][] dp = new int[n][3];
		int max = Integer.MAX_VALUE;
		for(int a = 0; a < 3; a++) {
			visit = new boolean[n];
			dp = new int[n][3];
			dp[0][a] = arr[0][a];
			for(int i = 1; i < n; i++)
				for(int j = 0; j < 3; j++)
					dp[i][j] = 10000000;
			queue = new PriorityQueue<Dickstra>((o1, o2) -> (o1.cost - o2.cost));
			queue.offer(new Dickstra(0, a, arr[0][a]));
			while(!queue.isEmpty()) {
				Dickstra now = queue.poll();
				if(now.x == n - 1) {
					max = Math.min(max, now.cost);
					continue;
				}
				for(int i = 0; i < 3; i++) {
					if(now.y == i) continue;
					if(now.x + 1 == n - 1 && a == i) continue;
					if(dp[now.x + 1][i] > now.cost + arr[now.x + 1][i]) {
						dp[now.x + 1][i] = now.cost + arr[now.x + 1][i];
						queue.offer(new Dickstra(now.x + 1, i, now.cost + arr[now.x + 1][i]));
					}
				}
			}
		}
		System.out.println(max);
	}
}
