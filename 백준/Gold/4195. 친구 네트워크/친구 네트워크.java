import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
	static int[] parents;
	static int[] count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(t--> 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			parents = new int[200002];
			count = new int[200002];
			for(int i = 1; i <= n * 2; i++) {
				parents[i] = i;
				count[i] = 1;
			}
			int node = 0;
			HashMap<String, Integer> hash = new HashMap<String, Integer>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(!hash.containsKey(str1))
					hash.put(str1, ++node);
				if(!hash.containsKey(str2))
					hash.put(str2, ++node);
				int x1 = hash.get(str1);
				int x2 = hash.get(str2);
				sb.append(union(x1, x2) + "\n");
			}
		}
		System.out.println(sb);
	}
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parents[y] = x;
			count[x] += count[y];
			count[y] = 1;
		}
		return count[x];
	}
	static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
}
