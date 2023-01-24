import java.util.*;
public class Main {
	static int n;
	static int[] arr;
	static boolean[] visit;
	static List<Integer>[] list;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[i] = scan.nextInt();
		list = new List[n + 1];
		visit = new boolean[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			int size = scan.nextInt();
			for(int j = 0; j < size; j++) {
				int k = scan.nextInt();
				list[i].add(k);
				list[k].add(i);
			}
		}
		if(n == 2) {
			System.out.println(Math.abs(arr[2] - arr[1]));
			System.exit(0);
		}
		List<Integer> aList = new ArrayList<>();
		for(int i = 1; i <= n; i++)
			dfs(0, 1, i, aList);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	static void dfs(int count, int m, int end, List<Integer> aList) {
		if(count == end) {
			bfs(aList);
			return;
		}
		for(int i = m; i <= n; i++) {
			if(!visit[i] && list[i].size() > 0) {
				visit[i] = true;
				aList.add(i);
				dfs(count + 1, i, end, aList);
				aList.remove(aList.indexOf(i));
				visit[i] = false;
			}
		}
	}
	static void bfs(List<Integer> aList) {
		HashSet<Integer> hash = new HashSet<Integer>(aList);
		int t = 0;
		for(int i = 0; i < n; i++) {
			if(!hash.contains(i + 1)) {
				t = i + 1;
				break;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		queue.offer(aList.get(0));
		boolean[] v = new boolean[n + 1];
		v[aList.get(0)] = true;
		temp.add(aList.get(0));
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : list[now]) {
				if(hash.contains(next) && !v[next]) {
					v[next] = true;
					queue.add(next);
					temp.add(next);
				}
			}
		}
		queue = new LinkedList<Integer>();
		List<Integer> tt = new ArrayList<Integer>();
		queue.offer(t);
		v[t] = true;
		tt.add(t);
		if(hash.size() == n)
			return;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : list[now]) {
				if(!hash.contains(next) && !v[next]) {
					v[next] = true;
					queue.offer(next);
					tt.add(next);
				}
			}
		}
		for(int i = 1; i <=n; i++)
			if(!v[i])
				return;
		int sum = 0;
		int count = 0;
		for(int i = 0; i < temp.size(); i++)
			sum += arr[temp.get(i)];
		for(int i = 0; i < tt.size(); i++)
			count += arr[tt.get(i)];
		answer = Math.min(answer, Math.abs(sum - count));
	}
}
