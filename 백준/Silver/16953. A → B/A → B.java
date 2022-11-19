import java.util.*;
public class Main {
	static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextInt();
        long b = scan.nextInt();
        dfs(0, a, b);
        if(answer == Integer.MAX_VALUE)
        	System.out.print(-1);
        else System.out.print(answer + 1);
    }
    static void dfs(int count, long a, long b) {
    	if(a > b) return;
    	if(a == b) {
    		answer = Math.min(answer, count);
    		return;
    	}
    	dfs(count + 1, a * 2, b);
    	dfs(count + 1, (a * 10) + 1, b);
    }
}
