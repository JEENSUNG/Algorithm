import java.util.*;
class Teacher{
	int x;
	int y;
	Teacher(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Main{
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static ArrayList<Teacher> list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n][n];
		visit = new boolean[n][n];
		list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++) {
				String x = scan.next();
				if(x.equals("X"))
					arr[i][j] = 0;
				else if(x.equals("S"))
					arr[i][j] = 1;
				else
					arr[i][j] = 2;
			}
		}
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < n; j++) 
				if(arr[i][j] == 2) 
					list.add(new Teacher(i, j));
		dfs(0, 3, 0, 0);
		System.out.print("NO");
	}
	static void dfs(int count, int end, int r, int c) {
		if(count == end) {
			boolean isOk = true;
			for(Teacher now : list) {
				for(int i = 0; i < 4; i++) {
					for(int j = 1; j < n; j++) {
						int nx = now.x + (dir[i][0] * j);
						int ny = now.y + (dir[i][1] * j);
						if(nx < 0 || ny < 0 || nx >= n || ny >= n) break;
						if(arr[nx][ny] == -1) break;
						if(arr[nx][ny] == 1) {
							isOk = false;
							break;
						}
					}
					if(!isOk) break;
				}
				if(!isOk) break;
			}
			if(!isOk) return;
			System.out.println("YES");
			System.exit(0);
			return;
		}
		for(int i = r; i < n; i++) {
			for(int j = c; j < n; j++) {
				if(!visit[i][j] && arr[i][j] == 0) {
					visit[i][j] = true;
					arr[i][j] = -1;
					dfs(count + 1, end, i, j + 1);
					arr[i][j] = 0;
					visit[i][j] = false;
				}
			}
           c = 0;
		}
	}
}
