import java.util.*;
public class Main{
	static int n, c;
	static int[] arr;
	static long answer = 0;
	static boolean[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		c = scan.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		dfs(0, n / 2, 0, left);
		dfs(n / 2 + 1, n - 1, 0, right);
		Collections.sort(left);
		Collections.sort(right);
		int max = right.size() - 1;
		for(int i = 0; i < left.size(); i++) {
			while(max >= 0 && left.get(i) + right.get(max) > c)
				max--;
			answer += max + 1;
		}
		System.out.println(answer);
	}
	static void dfs(int start, int end, int sum, ArrayList<Integer> list) {
		if(sum > c) return;
		if(start > end) {
			list.add(sum);
			return;
		}
		dfs(start + 1, end, sum, list);
		dfs(start + 1, end, sum + arr[start], list);
	}
}
