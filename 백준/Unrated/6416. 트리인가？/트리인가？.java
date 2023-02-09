import java.awt.Point;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> list = new HashSet<Integer>();
		boolean isOk = true;
		int index = 1;
		int max = 0;
		while(true) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if(a < 0 && b < 0)
				break;
			if(a == 0 && b == 0) {
				if(set.isEmpty()) {
					sb.append("Case " + index++ + " is a tree.\n");
					continue;
				}
				int count = 0;
				for(int i : set) {
					if(!list.contains(i))
						count++;
				}
				if(count != 1)
					isOk = false;
				if(!isOk)
					sb.append("Case " + index++ + " is not a tree.\n");
				else
					sb.append("Case " + index++ + " is a tree.\n");
				list = new HashSet<Integer>();
				set = new HashSet<Integer>();
				max = 0;
				isOk = true;
				continue;
			}
			max = Math.max(a, Math.max(b, max));
			set.add(a);
			if(!list.add(b))
				isOk = false;
		}
		System.out.println(sb.toString());
	}
}
