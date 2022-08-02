import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        for(int i = n; i <= m; i++) {
            int count = 0;
            int x = (int)Math.sqrt(i);
            for(int j = 1; j <= x; j++) {
                if(i % j== 0) {
                    count++;
                    continue;
                }
            }
            if(count == 1 && i != 1)
                System.out.println(i);
        }
    }
}