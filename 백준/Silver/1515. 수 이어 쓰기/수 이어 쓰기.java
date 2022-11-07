import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int x = 0;
        for(int i = 1; i <= 30000; i++){
            String s = String.valueOf(i);
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == str.charAt(x))
                    x++;
                if(x == str.length()){
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }
}
