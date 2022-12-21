import java.util.*;
class Shark{
	int x;
	int y;
	int d;
	Shark(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
class Main{
	static int m, s, sx, sy;
	static int[][] arr = new int[4][4];
	static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int[][] dd = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static List<Shark>[][] list = new List[4][4];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		s = scan.nextInt();
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				list[i][j] = new ArrayList<Shark>();
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			int d = scan.nextInt() - 1;
			list[x][y].add(new Shark(x, y, d));
		}
		sx = scan.nextInt() - 1;
		sy = scan.nextInt() - 1;
		scan.close();
		while(s--> 0) {
			List<Shark>[][] temp = new List[4][4];
			List<Shark>[][] clone = new List[4][4];
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++) {
					temp[i][j] = new ArrayList<Shark>(); 
					clone[i][j] = new ArrayList<Shark>();
					clone[i][j].addAll(list[i][j]);
				}
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					for(Shark now : list[i][j]) {
						int nx = now.x + dir[now.d][0];
						int ny = now.y + dir[now.d][1];
						if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == 2 || arr[nx][ny] == 1 || (sx == nx && sy == ny)) {
							int index = 0;
							int d = now.d;
							while(index < 8) {
								int NX = now.x + dir[d][0];
								int NY = now.y + dir[d][1];
								if(NX < 0 || NY < 0 || NX >= 4 || NY >= 4 || arr[NX][NY] == 2 || arr[NX][NY] == 1 || (sx == NX && sy == NY)) {
									index++;
									if(index == 8) {
										temp[now.x][now.y].add(new Shark(now.x, now.y, now.d));
										break;
									}
									d--;
									if(d < 0)
										d += 8;
								}else {
									temp[NX][NY].add(new Shark(NX, NY, d));
									break;
								}
							}
						}else 
							temp[nx][ny].add(new Shark(nx, ny, now.d));
					}
				}
			}
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++) {
					list[i][j] = new ArrayList<Shark>();
					list[i][j].addAll(temp[i][j]);
				}
			String str = "";
			int max = Integer.MIN_VALUE;
			int nx1 = 0; int ny1 = 0; int nx2 = 0; int ny2 = 0; int nx3 = 0; int ny3 = 0;
			for(int i = 0; i < 4; i++) {
				nx1 = sx + dd[i][0];
				ny1 = sy + dd[i][1];
				if(nx1 < 0 || ny1 < 0 || nx1 >= 4 || ny1 >= 4) continue;
				for(int j = 0; j < 4; j++) {
					nx2 = nx1 + dd[j][0];
					ny2 = ny1 + dd[j][1];
					if(nx2 < 0 || ny2 < 0 || nx2 >= 4 || ny2 >= 4) continue;
					for(int z = 0; z < 4; z++) {
						nx3 = nx2 + dd[z][0];
						ny3 = ny2 + dd[z][1];
						if(nx3 < 0 || ny3 < 0 || nx3 >= 4 || ny3 >= 4) continue;
						int count = 0;
						if(nx1 == nx3 && ny1 == ny3) 
							count = list[nx1][ny1].size() + list[nx2][ny2].size();
						else
							count = list[nx1][ny1].size() + list[nx2][ny2].size() + list[nx3][ny3].size();
						if(max < count) {
							max = count;
							str = "" + nx1 + ny1 + nx2 + ny2 + nx3 + ny3;
						}
					}
				}
			}
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++) {
					if(arr[i][j] == 2)
						arr[i][j] = 1;
					else if(arr[i][j] == 1)
						arr[i][j] = 0;
				}
			if(list[str.charAt(0) - '0'][str.charAt(1) - '0'].size() > 0)
				arr[str.charAt(0) - '0'][str.charAt(1) - '0'] = 2;
			if(list[str.charAt(2) - '0'][str.charAt(3) - '0'].size() > 0)
				arr[str.charAt(2) - '0'][str.charAt(3) - '0'] = 2;
			if(list[str.charAt(4) - '0'][str.charAt(5) - '0'].size() > 0)
				arr[str.charAt(4) - '0'][str.charAt(5) - '0'] = 2;
			list[str.charAt(0) - '0'][str.charAt(1) - '0'] = new ArrayList<Shark>();
			list[str.charAt(2) - '0'][str.charAt(3) - '0'] = new ArrayList<Shark>();
			list[str.charAt(4) - '0'][str.charAt(5) - '0'] = new ArrayList<Shark>();
			sx = str.charAt(4) - '0';
			sy = str.charAt(5) - '0';
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++)
					list[i][j].addAll(clone[i][j]);
		}
		int count = 0;
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				count += list[i][j].size();
		System.out.println(count);
	}
}