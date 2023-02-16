import java.util.*;
public class Main {
	static int n;
	static int[] parents;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			n = scan.nextInt();
			parents = new int[n + 1];
			arr = new int[n + 1];
			for(int i = 1; i <= n; i++)
				parents[i] = i;			
			while(true) {
				char str = scan.next().charAt(0);
				if(str == 'E') {
					int v = scan.nextInt();
					find(v);
					System.out.println(arr[v]);
				}else if(str == 'I'){
					int v = scan.nextInt();
					int w = scan.nextInt();
					union(v, w);
				}else
					break;
			}
		}
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		int pa = find(parents[x]);
		arr[x] += arr[parents[x]];
		parents[x] = pa;
		return pa;
	}
	static void union(int a, int b) {
		arr[a] = Math.abs(a - b) % 1000;
		parents[a] = b;
	}
}
