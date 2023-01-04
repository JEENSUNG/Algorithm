import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        	arr[i] = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][n];
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
        	dp[i][i] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++)
        	if(arr[i] == arr[i + 1])
        		dp[i][i + 1] = 1;
        for(int i = 1; i < n; i++)
        	for(int j = 0; j < n - i; j++)
        		if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1)
        			dp[j][j + i] = 1;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken()) - 1;
        	int y = Integer.parseInt(st.nextToken()) - 1;
        	if(dp[x][y] == 1)
        		sb.append("1\n");
        	else sb.append("0\n");
        }
        System.out.println(sb);
    }
}
