import java.util.*;
public class Main {
	static int n;
	static int answer = 0;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = scan.nextInt(); arr[i][1] = scan.nextInt();}
		dfs(0, 0);
		System.out.println(answer);
	}
	static void dfs(int count, int cnt) {
		if(count == n) {
			answer = Math.max(answer, cnt);
			return;
		}
		if(arr[count][0] <= 0 || cnt == n - 1) {
			dfs(count + 1, cnt);
			return;
		}
		int temp = cnt;
		for(int i = 0; i < n; i++) {
			if(i == count)
				continue;
			if(arr[i][0] <= 0) continue;
			arr[count][0] -= arr[i][1];
			arr[i][0] -= arr[count][1];
			
			if(arr[count][0] <= 0)
				cnt++;
			if(arr[i][0] <= 0)
				cnt++;
			dfs(count + 1, cnt);
			arr[count][0] += arr[i][1];
			arr[i][0] += arr[count][1];
			cnt = temp;
		}
	}
}
