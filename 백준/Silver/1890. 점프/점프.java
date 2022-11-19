import java.util.*;
class Point{
	int x;
	int y;
	int num;
	Point(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		arr[i][j] = scan.nextInt();
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		dp[i][j] = -1;
        System.out.print(dfs(0, 0, dp, arr, n));
    }
    static long dfs(int x, int y, long[][] dp, int[][] arr, int n) {
    	if(x == n - 1 && y == n - 1)
    		return 1;
    	if(dp[x][y] != -1) return dp[x][y];
    	dp[x][y] = 0;
    	int[][] dir = {{1, 0}, {0, 1}};
    	for(int i = 0; i < 2; i++) {
    		int nx = x + dir[i][0] * arr[x][y];
    		int ny = y + dir[i][1] * arr[x][y];
    		if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
    		dp[x][y] += dfs(nx, ny, dp, arr, n);
    	}
    	return dp[x][y];
    }
}
