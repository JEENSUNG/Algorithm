import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        while (true){
            String str = scan.next();
            if(str.equals("end"))
                break;
            queue.offer(str);
        }
        while (!queue.isEmpty()){
            String str = queue.poll();
            boolean one = false, two = true, three = true;
            char temp = str.charAt(0);
            if(str.length() == 1 && (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')) {
                System.out.println("<" + str + "> is acceptable.");
                continue;
            }else if(str.length() == 1){
                System.out.println("<" + str + "> is not acceptable.");
                continue;
            }
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                    one = true;
                    break;
                }
            }
            for(int i = 1; i < str.length(); i++){
                temp = str.charAt(i);
                if(i > 1 && (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')){
                    if(str.charAt(i - 1) == 'a' || str.charAt(i - 1) == 'e' || str.charAt(i - 1) == 'i' || str.charAt(i - 1) == 'o' || str.charAt(i - 1) == 'u') {
                        if(str.charAt(i - 2) == str.charAt(i) && str.charAt(i) == str.charAt(i - 1)){
                            two = false;
                            break;
                        }

                        if(str.charAt(i - 2) == 'a' || str.charAt(i - 2) == 'e' || str.charAt(i - 2) == 'i' || str.charAt(i - 2) == 'o' || str.charAt(i - 2) == 'u') {
                            two = false;
                            break;
                        }

                    }
                }
                else if(i > 1) {
                    if (str.charAt(i - 1) != 'a' && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'i' && str.charAt(i - 1) != 'o' && str.charAt(i - 1) != 'u') {
                        if (str.charAt(i - 2) != 'a' && str.charAt(i - 2) != 'e' && str.charAt(i - 2) != 'i' && str.charAt(i - 2) != 'o' && str.charAt(i - 2) != 'u') {
                            two = false;
                            break;
                        }
                    }
                }
                if(str.charAt(i - 1) == str.charAt(i)){
                    if(str.charAt(i) != 'e' && str.charAt(i) != 'o'){
                        three = false;
                        break;
                    }
                }
            }
            if(!one || !three || !two)
                System.out.println("<" + str + "> is not acceptable.");
            else
                System.out.println("<" + str + "> is acceptable.");
        }
    }
}