import java.util.*;
public class Main {
	static int n;
	static boolean[] visit;
	static int[][] dp;
	static List<Integer>[] list;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dp = new int[n][n];
        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		dp[i][j] = 100000000;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		int x = scan.nextInt();
        		if(x == 1) 
        			dp[i][j] = 1;
        	}
        }
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		for(int k = 0; k < n; k++) {
        			dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
        		}
        	}
        }
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(dp[i][j] == 100000000)
        			System.out.print(0 + " ");
        		else System.out.print(1 + " ");
        	}
        	System.out.println();
        }
    }
}
