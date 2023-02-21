import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		String str = scan.next();
		int n = scan.nextInt();
		String arr[] = new String[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.next();
		int count = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < n; j++) {
				if(str.charAt(i) == 'S' && arr[j].charAt(i) == 'P')
					count += 2;
				else if(str.charAt(i) == 'P' && arr[j].charAt(i) == 'R')
					count += 2;
				else if(str.charAt(i) == 'R' && arr[j].charAt(i) == 'S')
					count += 2;
				else if(str.charAt(i) == arr[j].charAt(i))
					count += 1;
			}
		}
		System.out.println(count);
		char[] ans = new char[3];
		ans[0] = 'S';
		ans[1] = 'P';
		ans[2] = 'R';
		count = 0;
		for(int i = 0; i < r; i++) {
			int temp = 0;
			for(int j = 0; j < 3; j++) {
				int t = 0;
				for(int k = 0; k < n; k++) {
					if(ans[j] == 'S' && arr[k].charAt(i) == 'P')
						t += 2;
					else if(ans[j] == 'P' && arr[k].charAt(i) == 'R')
						t += 2;
					else if(ans[j] == 'R' && arr[k].charAt(i) == 'S')
						t += 2;
					else if(ans[j] == arr[k].charAt(i))
						t += 1;
				}
				temp = Math.max(t, temp);
			}
			count += temp;
		}
		System.out.println(count);
	}
}
