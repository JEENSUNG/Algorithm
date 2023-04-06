import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = 1000 * scan.nextInt() + 100 * scan.nextInt() + 10 * scan.nextInt() + scan.nextInt();
		int min = n;
		for(int i = 0; i < 3; i++) {
			min = min / 10 + 1000 * (min % 10);
			n = Math.min(min, n);
		}
		int answer = 1;
		for(int i = 1111; i < n; i++) {
			if(s(i)) answer++;
		}
		System.out.println(answer);
	}
	static boolean s(int x) {
		int temp = x;
		for(int i = 0; i < 3; i++) {
			if(temp % 10 == 0) return false;
			temp = temp / 10 + 1000 * (temp % 10);
			if(temp < x)
				return false;
		}
		return true;
	}
}
