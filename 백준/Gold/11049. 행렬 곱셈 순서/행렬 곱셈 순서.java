import java.util.*;
class Main {
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	int[][] arr = new int[n][2];
    	int[][] dp = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		arr[i][0] = scan.nextInt();
    		arr[i][1] = scan.nextInt();
    	}
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(i == j)
    				dp[i][j] = 0;
    			else
    				dp[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	for(int i = 1; i < n; i++) {
    		for(int j = 0; i + j < n; j++) {
    			for(int a = j; a < j + i; a++) {
    				int cost = dp[j][a] + dp[a + 1][i + j]+ arr[j][0] * arr[a][1] * arr[i + j][1];
    				dp[j][i + j] = Math.min(dp[j][i + j], cost);
    			}
    		}
    	}
    	System.out.println(dp[0][n - 1]);
    }
}