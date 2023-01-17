import java.util.*;
class Main{
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	int k = scan.nextInt();
    	//1 2 3 4
    	//2 4 6 8
    	//3 6 9 12
    	//4 8 12 16
    	int min = 1;
    	int max = k;
    	while(min < max) {
    		int mid = (min + max) / 2;
    		int count = 0;
    		for(int i = 1; i <= n; i++)
    			count += Math.min(mid / i, n);
    		if(count >= k)
    			max = mid;
    		else
    			min = mid + 1;
    	}
    	System.out.println(min);
    }
}