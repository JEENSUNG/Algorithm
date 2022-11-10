import java.util.*;
class No{
	int x;
	int dir;
	No(int x, int dir){
		this.x = x;
		this.dir = dir;
	}
}
class Main{
	static int v;
	static int answer = 0;
	static List<No>[] list;
	static int[] ans;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		v = scan.nextInt();
		list = new List[v + 1];
		ans = new int[v + 1];
		visit = new boolean[v + 1];
		for(int i = 1; i <= v; i++)
			list[i] = new ArrayList<No>();
		int t = v;
		while(t--> 0) {
			int x = scan.nextInt();
			while(true) {
				int a = scan.nextInt();
				if(a == -1) break;
				int b = scan.nextInt();
				list[x].add(new No(a, b));
			}
		}
		dfs(1);
        int b = 0;
        for(int i = 1; i <= v; i++){
            if(answer < ans[i]){
                answer = ans[i];
                b = i;
            }
        }
        answer = 0;
         visit = new boolean[v + 1];
        ans = new int[v + 1];
        dfs(b);
		for(int i = 1; i <= v; i++)
			answer = Math.max(answer, ans[i]);
		System.out.print(answer);
	}
	static void dfs(int x) {
		if(!visit[x]) {
			visit[x] = true;
			for(No next : list[x]) {
				if(!visit[next.x] && ans[next.x] < ans[x] + next.dir) {
					ans[next.x] = ans[x] + next.dir;
					dfs(next.x);
				}
			}
		}
	}
}