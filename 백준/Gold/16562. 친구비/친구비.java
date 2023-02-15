import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
	static int n, m, k;
	static int[] parents;
	static int[] arr;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			parents[i] = i;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);			
		}
		for(int i = 1; i <= n; i++) {
			if(parents[i] == i)
				answer += arr[i];
		}
		if(answer <= k)
			System.out.println(answer);
		else
			System.out.println("Oh no");
	}
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			if(arr[pa] > arr[pb])
				parents[pa] = pb;
			else
				parents[pb] = pa;
		}
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
}