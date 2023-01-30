import java.util.*;
class Main{
	static int[] parents;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int g = scan.nextInt();
		int p = scan.nextInt();
		parents = new int[g + 1];
		for(int i = 0; i <= g; i++)
			parents[i] = i;
		int count = 0;
		while(p-- > 0) {
			int x = scan.nextInt();
			int temp = find(x);
			if(temp != 0) {
				count++;
				union(temp - 1, temp);
			}else break;
		}
		System.out.println(count);
	}
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa < pb)
			parents[pb] = pa;
		else parents[pa] = pb;
	}
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
}