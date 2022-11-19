import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        String str = scan.next();
        for(int i = 0; i < n; i++) {
        	if(str.charAt(i) == 'B')
        		arr[i] = 0;
        	else if(str.charAt(i) == 'O')
        		arr[i] = 1;
        	else
        		arr[i] = 2;
        }
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
        	dp[i] = 1000000;
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = i + 1; j < n; j++) {
        		if(arr[i] == 0) {
        			if(arr[j] == 1) 
        				dp[j] = Math.min(dp[i] + (int)Math.pow(j - i, 2), dp[j]);
        		}else if(arr[i] == 1) {
        			if(arr[j] == 2) 
        				dp[j] = Math.min(dp[i] + (int)Math.pow(j - i, 2), dp[j]);
        		}else {
        			if(arr[j] == 0) 
        				dp[j] = Math.min(dp[i] + (int)Math.pow(j - i, 2), dp[j]);
        		}
        	}
        }
        if(dp[n - 1] == 1000000)
        	System.out.print(-1);
        else System.out.print(dp[n - 1]);
    }
}
