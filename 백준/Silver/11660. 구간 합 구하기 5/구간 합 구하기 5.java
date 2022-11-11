import java.util.*;
class Main{
	static int n, m;
	static int[][] arr;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][n];
		int[][] sero = new int[n][n];

		for(int i = 0; i < n; i++) {
			int a = 0;
			for(int j = 0; j < n; j++) {
				arr[i][j] = scan.nextInt();
				a += arr[i][j];
				if(i == 0) {
					sero[i][j] = arr[i][j]; 
					arr[i][j] = a;
				}
				else {
					sero[i][j] = arr[i][j] + sero[i-1][j];
					if(j == 0)
						arr[i][j] = arr[i - 1][j] + arr[i][j];
					else {
						arr[i][j] = arr[i - 1][j - 1] + a + sero[i-1][j]; 
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(m--> 0) {
			int x1 = scan.nextInt() - 1;
			int y1 = scan.nextInt() - 1;
			int x2 = scan.nextInt() - 1;
			int y2 = scan.nextInt() - 1;
			int sum = arr[x2][y2];
			if(y1 - 1 >= 0)
				sum -= arr[x2][y1 - 1];
			if(x1 - 1 >= 0)
				sum -= arr[x1 - 1][y2];
			if(x1 -1 >= 0 && y1 - 1 >= 0)
				sum += arr[x1 - 1][y1 - 1];
			sb.append(sum + "\n");
		}
		System.out.print(sb);
	}
}