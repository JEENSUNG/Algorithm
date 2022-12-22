import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		HashSet<Integer> hash1 = new HashSet<Integer>();
		HashSet<Integer> hash2 = new HashSet<Integer>();
		for(int i = 0; i < n; i++)
			hash1.add(scan.nextInt());
		for(int i = 0; i < m; i++)
			hash2.add(scan.nextInt());
		int count = 0;
		int count2 = 0;
		for(Iterator<Integer> iter = hash1.iterator(); iter.hasNext();) {
			int now = iter.next();
			if(hash2.contains(now))
				count++;
		}
		for(Iterator<Integer> iter = hash2.iterator(); iter.hasNext();) {
			int now = iter.next();
			if(hash1.contains(now))
				count2++;
		}
		System.out.println(n - count2 + m - count);
	}

}
