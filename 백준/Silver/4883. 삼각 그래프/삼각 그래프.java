import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 1;
		while(true) {
			int n = scan.nextInt();
			if(n == 0) break;
			int[][] arr = new int[n][3];
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < 3; j++)
					arr[i][j] = scan.nextInt();
			int[][] dp = new int[n][3];
			dp[0][0] = arr[0][1];
			dp[0][1] = arr[0][1];
			dp[0][2] = arr[0][1] + arr[0][2];
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < 3; j++) {
					if(j == 0) 
						dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
					else if(j == 1)
						dp[i][j] = arr[i][j] + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])));
					else
						dp[i][j] = arr[i][j] + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
				}
			}
			System.out.println(count + ". " + dp[n - 1][1]);
			count++;
		}
	}
}