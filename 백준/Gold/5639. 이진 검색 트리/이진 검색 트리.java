import java.util.*;
public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int x = scan.nextInt();
			list.add(x);
		}
		postOrder(0, list.size() - 1);
	}
	static void postOrder(int x, int end) {
		if(x > end) return;
		int mid = x + 1;
		while(mid <= end && list.get(mid) < list.get(x))
			mid++;
		postOrder(x + 1, mid - 1);
		postOrder(mid, end);
		System.out.println(list.get(x));
	}
}
