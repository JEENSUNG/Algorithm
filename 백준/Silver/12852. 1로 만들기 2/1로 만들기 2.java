import java.util.*;
class Main{
	static int[] dp;
	static int n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		dp = new int[n + 1];
		Arrays.fill(dp, 1000000);
		dp[n] = 0;
		for(int i = n; i >= 1; i--) {
			int x = dp[i] + 1;
			if(i % 3 == 0)
				dp[i / 3] = Math.min(dp[i / 3], x);
			if(i % 2 == 0)
				dp[i / 2] = Math.min(dp[i / 2], x);
			dp[i - 1] = Math.min(dp[i - 1], x);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[1] + "\n");
		Stack<Integer> stack = new Stack<Integer>();
		int x = dp[1];
		for(int i = 1; i <= n; i++) {
			if(x == dp[i]) {
				stack.push(i);
				if(i * 3 <= n && dp[i * 3] == x - 1)
					i = i * 3 - 1;
				else if(i * 2 <= n && dp[i * 2] == x - 1)
					i = i * 2 - 1;
			}
			x--;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.print(sb);
	}
}