import java.util.*;
class Main{
	static int[][] arr = new int[10][10];
	static int[] dir= {0, 5, 5, 5, 5, 5};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int one = 0;
		for(int i = 0; i < 10; i++) 
			for(int j = 0; j < 10; j++) { 
				arr[i][j] = scan.nextInt();
				if(arr[i][j] == 1) one++;
			}
		scan.close();
		dfs(0, 0, 0);
		if(answer ==Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(answer);
	}
	static void dfs(int x, int y, int cnt) {
		if(x >= 9 && y > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		if(answer <= cnt) return;
		if(y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}
		if(arr[x][y] == 1) {
			for(int i = 5; i >= 1; i--) {
				if(dir[i] > 0 && check(x, y, i)) {
					change(x, y, i, 0);
					dir[i]--;
					dfs(x, y + 1, cnt + 1);
					change(x, y, i, 1);
					dir[i]++;
				}
			}
		}else
			dfs(x, y + 1, cnt);
	}
	static void change(int x, int y, int size, int k) {
		for(int i = x; i < x + size; i++)
			for(int j = y; j < y + size; j++)
				arr[i][j] = k;
	}
	static boolean check(int x, int y, int size) {
		for(int i =x ; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(i <0 || i >= 10 || j < 0 || j >= 10)
					return false;
				if(arr[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}