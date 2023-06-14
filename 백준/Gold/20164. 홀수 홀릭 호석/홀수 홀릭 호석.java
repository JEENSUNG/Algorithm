import java.util.*;
public class Main {
	static int n;
	static int min, max;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		min = Integer.MAX_VALUE;
		max = 0;
		dfs(n, find(n));
		System.out.println(min + " " + max);
	}
	static void dfs(int x, int count) {
		if (x <= 9) {
			min = Math.min(min, count);
			max = Math.max(max, count);
			return;
		}
		if(x <= 99) {
			int temp = (x / 10) + (x % 10);
			dfs(temp, find(temp) + count);
		}
		String str = Integer.toString(x);
		for(int i = 0; i < str.length() - 2; i++) {
			for(int j = i + 1; j < str.length() - 1; j++) {
				String a = str.substring(0, i + 1);
				String b = str.substring(i + 1, j + 1);
				String c = str.substring(j + 1);
				
				int p = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);
				dfs(p, find(p) + count);
			}
		}
	}
	static int find(int x) {
		int t = 0;
		while(x > 0) {
			int temp = x % 10;
			if(temp % 2 == 1) t++;
			x /= 10;
		}
		return t;
	}
}
