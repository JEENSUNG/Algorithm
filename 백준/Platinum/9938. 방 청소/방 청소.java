import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
	static int n, l;
	static int[] parents;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		parents = new int[l + 1];
		visit = new boolean[l + 1];
		for(int i = 1; i <= l; i++)
			parents[i] = i;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!visit[a]) {
				visit[a] = true;
				union(a, b);
			}else if(!visit[b]) {
				visit[b] = true;
				union(b, a);
			}else if(!visit[find(a)]) {
				visit[find(a)] = true;
				union(a, b);
			}else if(!visit[find(b)]) {
				visit[find(b)] = true;
				union(b, a);
			}else
				System.out.println("SMECE");
		}
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parents[a] = b;
		System.out.println("LADICA");
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
}