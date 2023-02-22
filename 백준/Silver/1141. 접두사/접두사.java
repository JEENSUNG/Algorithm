import java.util.*;
public class Main {
	static int n;
	static String[] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new String[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.next();
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length() - o1.length();
			}
		});
		HashSet<String> set = new HashSet<String>();
		for(String now : arr) {
			if(set.size() == 0) {
				set.add(now);
			}
			boolean isOk = true;
			for(String next : set) {
				if(next.indexOf(now) == 0) {
					isOk = false;
					break;
				}
			}
			if(isOk)
				set.add(now);
		}
		System.out.println(set.size());
	}
}
