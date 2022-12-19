import java.util.*;
class Point{
	int x;
	int y;
	int z;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
class Main{
	static int r, c, k;
	static int[][] arr;
	static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[][][][] stop;
	static List<Point> aList = new ArrayList<Point>();
	static List<Point> answer = new ArrayList<Point>();
	static int a = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		k = scan.nextInt();
		arr = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				int x = scan.nextInt();
				if(x == 5) 
					answer.add(new Point(i, j));
				else if(x > 0)
					aList.add(new Point(i, j, x));
			}
		}
		//1 : 오른쪽, 2 : 왼쪽, 3 : 위, 4 : 아래
		stop = new int[r][c][r][c];
		int w = scan.nextInt();
		for(int i = 0; i < w; i++) {
			int a = scan.nextInt() - 1;
			int b = scan.nextInt() - 1;
			int t = scan.nextInt();
			if(t == 0) {
				if(a > 0) {
					stop[a - 1][b][a][b] = 1;
					stop[a][b][a - 1][b] = 1;
				}
			}
			else {
				if(b < c - 1) {
					stop[a][b][a][b + 1] = 1;
					stop[a][b + 1][a][b] = 1;
				}
			}
		}
		//0이면 위에 장애물, 1이면 오른쪽이 장애물
		 scan.close();
		 while(true) {
			 boolean isOk = true;
			 for(Point now : answer) { 
				 if(arr[now.x][now.y] < k) {
					 isOk = false;
					 break;
				 }
	 		 }
			 if(a > 100) {
				 System.out.println(101);
				 break;
			 }
			 if(isOk) {
				 System.out.println(a);
				 break;
			 }
			 for(Point now : aList) {
				int[][] ans = new int[r][c];
				int size = 0;
				int num = 5;
				if(now.z == 1) {
					for(int i = now.y + 1; i <= now.y + 5; i++) {
						for(int j = now.x - size; j <= now.x + size; j++) {
							if(i < 0 || j < 0 || i >= c || j >= r) continue;
							if(size == 0)
								ans[j][i] = num;
							else {
								if(i >= 1 && j >= 1 && ans[j - 1][i - 1] > 0) {
									if(stop[j][i - 1][j][i] == 0 && stop[j - 1][i - 1][j][i - 1] == 0) {
										ans[j][i] = num;
									}
								}if(i >= 1 && ans[j][i - 1] > 0) {
									if(stop[j][i - 1][j][i] == 0) {
										ans[j][i] = num;
									}
								}if(i >= 1 &&j <= r - 2 && ans[j + 1][i - 1] > 0) {
									if(stop[j][i - 1][j][i] == 0 && stop[j][i - 1][j + 1][i - 1] == 0) {
										ans[j][i] = num;
									}
								}
							}
						}
						size++;
						num--;
					}
				}
				else if(now.z == 2) {
					for(int i = now.y - 1; i >= now.y - 5; i--) {
						for(int j = now.x - size; j <= now.x + size; j++) {
							if(i < 0 || j < 0 || i >= c || j >= r) continue;
							if(size == 0)
								ans[j][i] = num;
							else {
								if(j >= 1 && i <= c - 2 && ans[j - 1][i + 1] > 0) {
									if(stop[j][i][j][i + 1] == 0 && stop[j - 1][i + 1][j][i + 1] == 0) {
										ans[j][i] = num;
									}
								}if(i <= c - 2 && ans[j][i + 1] > 0) {
									if(stop[j][i][j][i + 1] == 0) {
										ans[j][i] = num;
									}
								}if(j <= r - 2 && i <= c - 2 && ans[j + 1][i + 1] > 0) {
									if(stop[j][i][j][i + 1] == 0 && stop[j][i + 1][j + 1][i + 1] == 0) {
										ans[j][i] = num;
									}
								}
							}
						}
						size++;
						num--;
					}
				}else if(now.z == 3) {
					for(int i = now.x - 1; i >= now.x - 5; i--) {
						for(int j = now.y - size; j <= now.y + size; j++) {
							if(i < 0 || j < 0 || i >= r || j >= c) continue;
							if(size == 0)
								ans[i][j] = num;
							else {
								if(i <= r - 2 && j >= 1 && ans[i + 1][j - 1] > 0) {
									if(stop[i + 1][j - 1][i + 1][j] == 0 && stop[i][j][i + 1][j] == 0) {
										ans[i][j] = num;
									}
								}if(i <= r - 2 && ans[i + 1][j] > 0) {
									if(stop[i][j][i + 1][j] == 0) {
										ans[i][j] = num;
									}
								}if(i <= r - 2 && j <= c - 2 && ans[i + 1][j + 1] > 0) {
									if(stop[i][j][i + 1][j] == 0 && stop[i + 1][j][i + 1][j + 1] == 0) {
										ans[i][j] = num;
									}
								}
							}
						}
						size++;
						num--;
					}
				}
				else if(now.z == 4) {
					for(int i = now.x + 1; i <= now.x + 5; i++) {
						for(int j = now.y - size; j <= now.y + size; j++) {
							if(i < 0 || j < 0 || i >= r || j >= c) continue;
							if(size == 0)
								ans[i][j] = num;
							else {
								if(i >= 1 && j >= 1 && ans[i - 1][j - 1] > 0) {
									if(stop[i - 1][j - 1][i - 1][j] == 0 && stop[i - 1][j][i][j] == 0) {
										ans[i][j] = num;
									}
								}if(i >= 1 && ans[i - 1][j] > 0) {
									if(stop[i - 1][j][i][j] == 0) {
										ans[i][j] = num;
									}
								}if(i >= 1 && j <= c - 2 && ans[i - 1][j + 1] > 0) {
									if(stop[i - 1][j][i - 1][j + 1] == 0 && stop[i - 1][j][i][j] == 0) {
										ans[i][j] = num;
									}
								}
							}
						}
						size++;
						num--;
					}
				}
				for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
						arr[i][j] += ans[i][j];
			 }
			 int[][] map = new int[r][c];
			 for(int i = 0; i < r; i++) {
				 for(int j = 0; j < c; j++) {
					 if(arr[i][j] > 0) {
						 for(int z = 0; z < 4; z++) {
							 int nx = i + dir[z][0];
							 int ny = j + dir[z][1];
							 if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
							 if(arr[i][j] > arr[nx][ny] && stop[i][j][nx][ny] == 0) {
								 int t = (arr[i][j] - arr[nx][ny]) / 4;
								 map[i][j] -= t;
								 map[nx][ny] += t;
							 }
						 }
					 }
				 }
			 }
			 for(int i = 0; i < r; i++)
				 for(int j = 0; j < c; j++) 
					 arr[i][j] += map[i][j];
			 for(int i = 0; i < r; i++)
				 for(int j = 0; j < c; j++) 
					 if(i == 0 || j ==  0 || i == r - 1 || j == c - 1)
						 if(arr[i][j] > 0)
							 arr[i][j]--;
//			 for(int i = 0; i < r; i++) {
//				 for(int j = 0; j < c; j++) {
//					 System.out.print(arr[i][j] + " ");
//				 }
//				 System.out.println();
//			 }
//			 System.out.println("=================");		 			 
			 a++;
		 }
	}
}