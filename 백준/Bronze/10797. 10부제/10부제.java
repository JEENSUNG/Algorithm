import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		for(int i = 0; i < 5; i++) {
			String x = scan.next();
			if(x.charAt(x.length() - 1) - '0' == n)
				count++;
		}
		System.out.print(count);
	}
}
