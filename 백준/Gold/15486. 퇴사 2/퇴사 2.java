import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];
		int[] cost = new int[n + 1];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			cost[i] = scan.nextInt();
		}
		int max = 0;
		for(int i = 0; i <= n; i++) {
			max = Math.max(max,  dp[i]);
			if(i + arr[i] <= n) {
				dp[i + arr[i]] = Math.max(dp[i + arr[i]], max + cost[i]);
			}
		}
		System.out.println(max);
	}
}