import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int x = scan.nextInt();
            long[] arr = new long[x];
            long max = 0;
            for (int i = 0; i < x; i++)
                arr[i] = scan.nextInt();
            long sum = 0;
            for(int i = x - 1; i >= 0; i--){
                if(arr[i] > max)
                    max = arr[i];
                else{
                    sum += max - arr[i];
                }
            }
            System.out.println(sum);
        }
    }
}
