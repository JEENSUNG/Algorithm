import java.util.*;
class Main{
	static int n, m;
	static List<Integer>[] arr;
	static int[] degree;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new List[n + 1];
		for(int i = 0; i <= n; i++)
			arr[i] = new ArrayList<Integer>();
		degree = new int[n + 1];
		for(int i = 0; i < m; i++) {
			int t = scan.nextInt();
			int x = scan.nextInt();
			for(int j = 1; j < t; j++) {
				int y = scan.nextInt();
				arr[x].add(y);
				degree[y]++;
				x = y;
			}
		}
		topology();
		if(list.size() == n)
			for(Integer i : list)
				System.out.print(i + " ");
		else
			System.out.println(0);
	}
	static void topology() {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i < degree.length; i++)
			if(degree[i] == 0)
				queue.offer(i);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			list.add(now);
			for(Integer i : arr[now]) {
				degree[i]--;
				if(degree[i] == 0)
					queue.offer(i);
			}
		}
	}
}