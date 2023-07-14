import java.util.*;
class Toilet implements Comparable<Toilet>{
	int x;
	int y;
	int id;
	boolean me;
	Toilet(int x, int y, int id, boolean me){
		this.x = x;
		this.y = y;
		this.id = id;
		this.me = me;
	}
	@Override
	public int compareTo(Toilet o) {
		if(this.x == o.x) {
			if(this.y == o.y) {
				return this.id - o.id;
			}
			return o.y - this.y;
		}
		return o.x - this.x;
	}
}
public class Main {
	static int n, m, k;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		
		Queue<Toilet>[] queue = new Queue[m];
		for(int i = 0; i < m; i++)
			queue[i] = new LinkedList<>();
		
		int id = 0;
		int count = 0;
		if(n < m)
			for(int i = 0; i < n; i++) {
				if(i == k)
					queue[i].offer(new Toilet(scan.nextInt(), scan.nextInt(), i, true));
				else
					queue[i].offer(new Toilet(scan.nextInt(), scan.nextInt(), i, false));
			}
		else
			while(count++ < n) {
				if(count - 1 == k)
					queue[id++].offer(new Toilet(scan.nextInt(), scan.nextInt(), id - 1, true));
				else
					queue[id++].offer(new Toilet(scan.nextInt(), scan.nextInt(), id - 1, false));
				if(id == m)
					id = 0;
			}		
		int answer = 0;
		PriorityQueue<Toilet> temp = new PriorityQueue<>();
		for(int i = 0; i < Math.min(n, m); i++)  
			temp.offer(queue[i].poll());

		while(!temp.isEmpty()) {
			Toilet now = temp.poll();
			if(now.me)
				break;
			if(!queue[now.id].isEmpty())
				temp.offer(queue[now.id].poll());
			answer++;
		}
		
		System.out.println(answer);
	}

}
