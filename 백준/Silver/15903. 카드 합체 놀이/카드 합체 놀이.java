import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		PriorityQueue<Long> queue = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
			queue.offer(scan.nextLong());
		while(m-- > 0) {
			long x = queue.poll();
			long y = queue.poll();
			queue.offer(x + y);
			queue.offer(x + y);
		}
		long answer = 0;
		while(!queue.isEmpty())
			answer += queue.poll();
		System.out.println(answer);
	}
}
