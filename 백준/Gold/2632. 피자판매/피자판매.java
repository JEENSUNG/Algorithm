import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[] a = new int[m * 2];
        int[] b = new int[n * 2];
        int p = 0;
        int q = 0;
        for(int i = 0; i < m; i++) {
        	a[i] = scan.nextInt();
        	p += a[i];
        }
        for(int i = m; i < 2 * m; i++)
        	a[i] = a[i - m];
        for(int i = 0; i < n; i++) {
        	b[i] = scan.nextInt();
        	q += b[i];
        }
        for(int i = n; i < 2 * n; i++)
        	b[i] = b[i - n];
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i < m; i++) {
        	int sum = 0;
        	for(int j = i; j < i + m - 1; j++) {
        		sum += a[j];
        		if(sum > x) break;
        		list1.add(sum);
        	}
        }
        for(int i = 0; i < n; i++) {
        	int sum = 0;
        	for(int j = i; j < i + n - 1; j++) {
        		sum += b[j];
        		if(sum > x) break;
        		list2.add(sum);
        	}
        }
        list1.add(p);
        list2.add(q);
        list1.add(0);
        list2.add(0);
        Collections.sort(list1);
        Collections.sort(list2);
        int count = 0;
        int min = 0;
        int max = list2.size() - 1;
        while(min < list1.size() && 0 <= max) {
        	int mid = list1.get(min) + list2.get(max);
        	int left = list1.get(min);
        	int right = list2.get(max);
        	if(mid == x) {
        		int w = 0;
        		int e = 0;
        		while(min < list1.size() && list1.get(min) == left) {
        			w++;
        			min++;
        		}
        		while(max >= 0 && list2.get(max) == right) {
        			e++;
        			max--;
        		}
        		count += w * e;
        	}else if(mid < x) {
        		min++;
        	}else
        		max--;
        }
        System.out.print(count);
    }
}
