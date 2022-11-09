import java.util.*;
class Jewely{
	int m;
	int v;
	Jewely(int m, int v){
		this.m = m;
		this.v = v;
	}
}
public class Main { 
	static int n, k;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		PriorityQueue<Jewely> queue = new PriorityQueue<>(new Comparator<Jewely>() {

			@Override
			public int compare(Jewely o1, Jewely o2) {
				if(o1.m == o2.m)
					return o2.v - o1.v;
				return o1.m - o2.m;
			}
		});
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			queue.offer(new Jewely(scan.nextInt(), scan.nextInt()));
		for(int i = 0; i < k; i++)
			list.add(scan.nextInt());
		Collections.sort(list);
		long cost = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for(int i = 0; i < k; i++) {
			while(!queue.isEmpty()) {
				Jewely now = queue.peek();
				if(list.get(i) < now.m) break;
				q.offer(queue.poll().v);
			}
			if(!q.isEmpty())
				cost += q.poll();
		}
		System.out.print(cost);
	}
}
