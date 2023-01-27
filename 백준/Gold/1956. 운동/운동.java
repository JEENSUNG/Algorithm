import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int e = scan.nextInt();
		int[][] dp = new int[v + 1][v + 1];
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++) {
				if(i == j) continue;
				dp[i][j] = 10000000;
			}
		}
		for(int i = 0; i < e; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int cost = scan.nextInt();
			dp[x][y] = cost;
		}
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++) {
				for(int k = 1; k <= v; k++) {
					if(i == j) continue;
					dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
				}
			}
		}
		int answer = 10000000;
		for(int i = 1; i <= v; i++)
			for(int j = 1; j <= v; j++) {
				if(i == j) continue;
				if(dp[i][j] != 10000000 && dp[j][i] != 10000000)
					answer = Math.min(answer, dp[i][j] + dp[j][i]);
			}
		if(answer != 10000000)
			System.out.println(answer);
		else
			System.out.println(-1);
	}
}
