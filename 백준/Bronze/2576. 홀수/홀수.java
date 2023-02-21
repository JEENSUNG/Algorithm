import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		boolean isOk = false;
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 0; i < 7; i++) {
			int x = scan.nextInt();
			if(x % 2 == 1) {
				isOk = true;
				count += x;
				min = Math.min(min, x);
			}
		}
		if(isOk) {
			System.out.println(count);
			System.out.println(min);
		}else
			System.out.println(-1);
	}
}
