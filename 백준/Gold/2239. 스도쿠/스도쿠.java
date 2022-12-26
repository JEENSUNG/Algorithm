import java.util.*;
public class Main {
	static int arr[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		arr = new int[9][9];
		int zero = 0;
		for(int i = 0; i < 9; i++) {
			String str = scan.next();
			for(int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
				if(arr[i][j] == 0)
					zero++;
			}
		}
		if(zero == 0) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		dfs(0, 0);
	}
	static void dfs(int x, int y) {
		if(x == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(y < 9 && arr[x][y] != 0) {
			dfs(x, y + 1);
		}else if(y == 9) {
			dfs(x + 1, 0);
		}else if(y < 9 && arr[x][y] == 0) {
			for(int i = 1; i <= 9; i++) {
				arr[x][y] = i;
				if(check(x, y) && check2(x, y)) {
					dfs(x, y + 1);				
				}
				arr[x][y] = 0;
			}
		}
	}
	//9개 큐브 중복 확인
	static boolean check(int x, int y) {
		boolean[] visit = new boolean[10];
		int nx = x - (x % 3);
		int ny = y - (y % 3);
		for(int i = nx; i < nx + 3; i++) {
			for(int j = ny; j < ny + 3; j++) {
				if(!visit[arr[i][j]] && arr[i][j] > 0)
					visit[arr[i][j]] = true;
				else if(visit[arr[i][j]])return false;
			}
		}
		return true;
	}
	//가로 and 세로 확인
	static boolean check2(int x, int y) {
		//가로
		boolean[] visit = new boolean[10];
		for(int i = 0; i < 9; i++) {
			if(!visit[arr[x][i]] && arr[x][i] > 0)
				visit[arr[x][i]] = true;
			else if(visit[arr[x][i]]) return false;
		}
		//세로
		visit = new boolean[10];
		for(int i = 0; i < 9; i++) {
			if(!visit[arr[i][y]] && arr[i][y] > 0)
				visit[arr[i][y]] = true;
			else if(visit[arr[i][y]])return false;
		}
		return true;
	}
}
