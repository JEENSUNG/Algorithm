import java.util.*;
public class Main {
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> aList = new ArrayList<Integer>();
	static int[] arr;
	static int n, m;
	static long sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
        	arr[i] = scan.nextInt();
        dfs(0, 0, n / 2);
        dfs2(0, n / 2, n);
        Collections.sort(list);
        Collections.sort(aList);
        int left = 0;
        int right = aList.size() - 1;
        while(left < list.size() && right >= 0) {
        	int a = list.get(left);
        	int b = aList.get(right);
        	if(a + b == m) {
        		long x = 0;
        		while(left < list.size() && list.get(left) == a) {
        			left++;
        			x++;
        		}
        		long y = 0;
        		while(right >= 0 && aList.get(right) == b) {
        			right--;
        			y++;
        		}
        		sum += x * y;
        	}
        	if(a + b > m)
        		right--;
        	else if(a + b < m)
        		left++;
        }
        sum = m == 0 ? sum - 1 : sum;
        System.out.println(sum);
    }
    static void dfs(int p, int start, int end) {
    	if(start == end) {
    		list.add(p);
    		return;
    	}
    	dfs(p + arr[start], start + 1, end);
    	dfs(p, start + 1, end);
    }
    
    static void dfs2(int p, int start, int end) {
    	if(start == end) {
    		aList.add(p);
    		return;
    	}
    	dfs2(p + arr[start], start + 1, end);
    	dfs2(p, start + 1, end);
    }
}
