import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int n = scan.nextInt();
			int now = n % h;
			if(now == 0)
				now = h;
			int temp = (n - 1) / h + 1;
			int count = 1;
			count = now * 100;
			count += temp;
			System.out.println(count);
		}
	}
}
