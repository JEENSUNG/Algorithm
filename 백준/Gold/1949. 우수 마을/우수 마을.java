import java.util.*;
class V{
	int x;
	int y;
	V(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;
	static List<Integer>[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n + 1];
		dp = new int[n + 1][2];
		list = new List[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		for(int i = 1; i <= n; i++)
			arr[i] = scan.nextInt();
		for(int i = 0; i < n - 1; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		dfs(1, 0);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	static void dfs(int x, int y) {
		for(int now : list[x]) {
			if(now == y) continue;
			dfs(now, x);
			dp[x][0] += Math.max(dp[now][0], dp[now][1]);
			dp[x][1] += dp[now][0];
		}
		dp[x][1] += arr[x];
	}
}
