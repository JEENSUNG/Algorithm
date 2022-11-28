import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for(int i = 6; i <= 100; i++) 
			dp[i] = dp[i - 1] + dp[i - 5];
		while(t--> 0) {
			int n = scan.nextInt();
			System.out.println(dp[n]);
		}
	}
}