import java.util.*;
public class Main {
	static int n, m;
	static int[] parents;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		parents = new int[n];
		for(int i = 0; i < n; i++)
			parents[i] = i;
		int count = 0;
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if(find(x) == find(y)) {
				count = i + 1;
				break;
			}else {
				union(x, y);
			}
		}
		System.out.println(count);
	}
	static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) 
			parents[y] = x;
	}
}
