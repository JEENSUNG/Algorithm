import java.util.*;
class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Main{
	static int n, m, p, num;
	static int[][] arr;
	static int[] ans;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Queue<Node>[] queue;
	static int[] t;
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		p = scan.nextInt();
		arr = new int[n][m];
		ans = new int[p];
		t = new int[p + 1];
		queue = new LinkedList[10];
		for(int i = 0; i < p; i++) {
			ans[i] = scan.nextInt();
			queue[i + 1] = new LinkedList<>();
		}
		num = 0;
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == '.') 
					arr[i][j] = 0;
				else if(str.charAt(j) == '#')
					arr[i][j] = -1;
				else {
					arr[i][j] = str.charAt(j) - '0';
					queue[arr[i][j]].add(new Node(i, j));
					t[arr[i][j]]++;
				}
			}
		}
		while(true) {
			int size = num;
			for(int i = 0; i < p; i++)
				bfs(i + 1, ans[i]);
			if(size == num) 
				break;
		}
		for(int i = 1; i <= p; i++)
			System.out.print(t[i] + " ");
	}
	static void bfs(int c, int x) {
		int count = 1;
		while(!queue[c].isEmpty()) {
			int s = queue[c].size();
			for(int i = 0; i < s; i++) {
				Node now = queue[c].poll();
				for(int j = 0; j < 4; j++) {
					int nx = (now.x + dir[j][0]);
					int ny = (now.y + dir[j][1]);
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if(arr[nx][ny] > 0) continue;
					if(arr[nx][ny] == -1) continue;
					queue[c].offer(new Node(nx, ny));
					arr[nx][ny] = c;
					num++;
					t[c]++;
				}
			}
			count++;
			if(count > x) break;
		}
	}
}