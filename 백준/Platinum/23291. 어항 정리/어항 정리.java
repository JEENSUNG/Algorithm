import java.util.*;
class Main{
	static int n, k;
	static int answer = 0;
	static int[][] ans;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		ans = new int[n][n];
		for(int i = 0; i < n; i++) 
			ans[n - 1][i] = scan.nextInt();
		while(true) {
			int[] arr = ans[n - 1].clone();
			Arrays.sort(arr);
			if(arr[n - 1] - arr[0] <= k) {
				System.out.println(answer);
				break;
			}
			int max = Integer.MAX_VALUE;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				if(ans[n - 1][i] < max) {
					max = ans[n - 1][i];
					list = new ArrayList<Integer>();
					list.add(i);
				}
				else if(ans[n - 1][i] == max)
					list.add(i);
			}
			for(Integer i : list)
				ans[n - 1][i]++;
			wave();
			sort();
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i = 0; i < n; i++) {
				if(ans[n - 1][i] > 0) {
					for(int j = n - 1; j >= 0; j--) {
						if(ans[j][i] > 0) 
						queue.offer(ans[j][i]);
					}
				}
			}
			ans = new int[n][n];
			for(int i = 0; i < n; i++)
				ans[n - 1][i] = queue.poll();
			for(int i = 0; i < n / 2; i++) {
				queue.offer(ans[n - 1][i]);
				ans[n - 1][i] = 0;
			}
			for(int i = n - 1; i >= n / 2; i--)
				ans[n - 2][i] = queue.poll();
			for(int i = n - 2; i < n; i++) {
				for(int j = n / 2; j < (n / 2) + (n / 4); j++) {
					if(ans[i][j] > 0) {
						queue.offer(ans[i][j]);
						ans[i][j] = 0;
					}
				}
			}
			for(int i = n - 3; i >= n - 4; i--) 
				for(int j = n - 1; j >= (n / 2) + (n / 4); j--) 
					ans[i][j] = queue.poll();
			sort();
			for(int i = n - 1; i >= 0; i--)
				for(int j = 0; j < n; j++)
					if(ans[j][i] > 0) 
						queue.offer(ans[j][i]);
			ans = new int[n][n];
			for(int i = n - 1; i >= 0; i--)
				ans[n - 1][i] = queue.poll();
			answer++;
		}
	}
	static void wave() {
		int count = 0;
		ans[n - 2][1] = ans[n - 1][0];
		ans[n - 1][0] = 0;
		while(true) {
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean first = false;
			boolean isOk = true;
			int temp = 0;
			int t = 0;
			for(int i = n - 1; i >= 0; i--) 
				if(ans[n - 2][i] > 0) {
					t++;
					for(int j = 0; j < n; j++) 
						if(ans[j][i] > 0) {
							if(!first) {
								first = true;
								count = n - j;
							}
						}
					if(isOk) {
						temp = i;
						isOk = false;
					}
				}
			if(n - temp - 1 < count)
				break;
			for(int i = n - 1; i >= 0; i--) 
				if(ans[n - 2][i] > 0) 
					for(int j = 0; j < n; j++) 
						if(ans[j][i] > 0) {
							queue.offer(ans[j][i]);
							ans[j][i] = 0;
						}
			//temp는 첫 2개 이상 인덱스, count는 2개 이상인 어항의 사이즈
			while(!queue.isEmpty()) 
				for(int i = n - 2; i >= n - t - 1; i--)
					for(int j = temp + count; j >= temp + 1; j--)
						ans[i][j] = queue.poll();
		}
		
	}
	static void sort() {
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				if(ans[i][j] == 0) continue;
				for(int z = 0; z < 4; z++) {
					int nx = i + dir[z][0];
					int ny = j + dir[z][1];
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					int t = (ans[i][j] - ans[nx][ny]) / 5;
					if(ans[nx][ny] > 0) {
						if(t > 0) {
							map[i][j] -= t;
							map[nx][ny] += t;
						}
					
					}
				}
			}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				ans[i][j] += map[i][j];
	}
}