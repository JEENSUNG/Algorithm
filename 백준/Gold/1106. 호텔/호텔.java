import java.util.*;
public class Main {
	static int c, n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		c = scan.nextInt();
		int[] dp = new int[c + 101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		n = scan.nextInt();
		for(int i = 0; i <  n; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			for(int j = y; j < c + 101; j++) {
				int temp = dp[j - y];
				if (temp != Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], temp + x);
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int i = c; i < c + 101; i++)
			answer = Math.min(answer, dp[i]);
		System.out.println(answer);
	}

}
