import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		HashSet<String> hash = new HashSet<String>();
		HashSet<String> hash2 = new HashSet<String>();
		for(int i = 0; i < n; i++)
			hash.add(scan.next());
		for(int i = 0; i < m; i++)
			hash2.add(scan.next());
		
		PriorityQueue<String> queue = new PriorityQueue<String>();
		for(Iterator<String> iter = hash.iterator(); iter.hasNext();) {
			String now = iter.next();
			if(hash2.contains(now)) {
				queue.offer(now);
			}
		}
		System.out.println(queue.size());
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
