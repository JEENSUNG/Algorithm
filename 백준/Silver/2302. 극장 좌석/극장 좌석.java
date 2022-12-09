import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		int start = 0;
		int sum = 1;
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			sum = sum * dp[x - start - 1];
			start = x;
		}
		sum *= dp[n - start];
		System.out.println(sum);
	}
}