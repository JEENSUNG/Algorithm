import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int min = Integer.MAX_VALUE;
        int a = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a')
                a++;
        }
        for(int i = 0; i < str.length(); i++){
            int b = 0;
            for(int j = i; j < i + a; j++){
                int index = j % str.length();
                if(str.charAt(index) == 'b')
                    b++;
            }
            min = Math.min(min, b);
        }
        System.out.println(min);
    }
}