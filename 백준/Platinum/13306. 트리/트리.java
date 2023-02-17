import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n, q;
	static int[] parents;
	static int[] arr;
	static int[][] ans;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		arr = new int[n + 1];
		ans = new int[n + q][2];
		for(int i = 2; i <= n; i++){
			st = new StringTokenizer(br.readLine());			
			int v = Integer.parseInt(st.nextToken());
			parents[i] = i;
			arr[i] = v; 
		}
		arr[1] = 1;
		for(int i = 1; i <= n - 1 + q; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(v == 1) {
				int k = Integer.parseInt(st.nextToken());
				ans[i][0] = w;
				ans[i][1] = k;
			}else {
				ans[i][0] = w;
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = n + q - 1; i >= 1; i--) {
			if(ans[i][1] > 0) {
				if(find(ans[i][0]) == find(ans[i][1]))
					stack.add(1);
				else
					stack.add(0);
			}else
				union(ans[i][0], arr[ans[i][0]]);
		}
		while(!stack.isEmpty()) {
			if(stack.pop() == 1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			parents[pb] = pa;
		}
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
}
