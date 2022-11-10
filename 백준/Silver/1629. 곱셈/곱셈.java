import java.util.*;
class Main{
	static int answer = 1;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		System.out.println(dfs(a, b, c));
	}
	static long dfs(int a, int b, int c) {
		if(b == 0) return 1;
		long t = dfs(a, b / 2, c);
		if(b % 2 == 0)
			return t * t % c;
		else
			return (t * t % c) * a % c;
	}
}