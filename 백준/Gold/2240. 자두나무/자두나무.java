import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int w = scan.nextInt();
		int[][] dp = new int[t + 1][w + 1];
		int[] arr = new int[t + 1];
		for(int i = 1; i <= t; i++) arr[i] = scan.nextInt();
		if(arr[1] == 1) dp[1][0] = 1;
		else dp[1][1] = 1;
		
		for(int i = 2; i <= t; i++) {
			for(int j = 0; j <= w; j++) {
				if(j == 0)
					if(arr[i] == 1) dp[i][0] = dp[i - 1][0] + 1;
					else dp[i][0] = dp[i - 1][0];
				else {
					if(j % 2 == 0)
						if(arr[i] == 1)
							dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
						else
							dp[i][j] = dp[i - 1][j];
					else
						if(arr[i] == 2)
							dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
						else
							dp[i][j] = dp[i - 1][j];
				}
			}
		}
		int ans = 0;
		for(int i = 0; i <= w; i++)
			if(ans < dp[t][i])
				ans = dp[t][i];
		System.out.println(ans);
	}
}