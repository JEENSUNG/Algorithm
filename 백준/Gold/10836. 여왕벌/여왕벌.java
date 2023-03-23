import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int m, n;
	static int[][] arr;
	static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][m];
		for(int i = 0; i < m; i++)
			Arrays.fill(arr[i], 1);
		int[][] map = new int[m][m];
		while(n--> 0) {
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			for(int i = 0; i < zero; i++) 
				list.add(0);
			for(int i = 0; i < one; i++)
				list.add(1);
			for(int i = 0; i < two; i++)
				list.add(2);
			for(int i = m - 1,j = 0; i >= 0; i--, j++) {
				map[i][0] += list.get(j);
				arr[i][0] += list.get(j);
			}
			for(int i = 1, j = m; i < m; i++, j++) {
				map[0][i] += list.get(j);
				arr[0][i] += list.get(j);
			}
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < m; j++) {
				int max = 0;
				for(int k = 0; k < 3; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					max = Math.max(max, map[nx][ny]);
				}
				arr[i][j] += max;
				map[i][j] = max;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			for(int j =  0; j < m; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
