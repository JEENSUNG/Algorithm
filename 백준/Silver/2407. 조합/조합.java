import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n, m;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		BigInteger answer = new BigInteger("1");
		if(n / 2 < m)
			m = n - m;
		int index = 0;
		while(index++ < m) {
			BigInteger temp = new BigInteger(String.valueOf(n));
			answer = answer.multiply(new BigInteger(String.valueOf(temp)));
			n--;
		}
		BigInteger t = new BigInteger("1");
		for(int i = 1; i <= m; i++) 
			t = t.multiply(new BigInteger(String.valueOf(i)));
		System.out.println(answer.divide(t));
	}
}
