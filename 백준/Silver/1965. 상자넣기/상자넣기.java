import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        	arr[i] = scan.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;
        int count = 1;
        for(int i = 1; i < n; i++) {
        	dp[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(arr[j] < arr[i]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        			count = Math.max(count, dp[i]);
        		}
        	}
        }
        System.out.print(count);
    }
}
