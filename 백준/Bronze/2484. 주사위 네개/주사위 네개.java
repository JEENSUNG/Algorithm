import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int max = 0;
		for(int i = 0; i < n; i++) {			
			int[] arr = new int[4];
			for(int j = 0; j < 4; j++)
				arr[j] = scan.nextInt();
			Arrays.sort(arr);
			if(arr[0] == arr[3]) {
				max = Math.max(max, 50000 + (arr[0] * 5000));
			}
			else if(arr[0] == arr[1] && arr[2] == arr[3]) {
				max = Math.max(max, 2000 + (arr[0] * 500) + (arr[2] * 500));
			}else if(arr[0] == arr[2]) {
				max = Math.max(max, 10000 + (arr[0] * 1000));
			}else if(arr[1] == arr[3]) {
				max = Math.max(max, 10000 + (arr[1] * 1000)); 
			}else if(arr[0] == arr[1]) {
				max = Math.max(max, 1000 + (arr[0] * 100));
			}else if(arr[2] == arr[3]) {
				max = Math.max(max, 1000 + (arr[2] * 100));
			}
			else if(arr[1] == arr[2])
				max = Math.max(max, 1000 + (arr[1] * 100));
			else
				max = Math.max(max, (arr[3] * 100));
		}
		System.out.println(max);
	}
}
