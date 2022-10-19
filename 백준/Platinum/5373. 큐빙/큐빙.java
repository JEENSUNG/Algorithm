import java.util.*;
public class Main {
    static char[][] arr;
    static int l;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            l = scan.nextInt();
            arr = new char[9][12];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 12; j++) {
                    if (i <= 2 && j >= 3 && j <= 5)
                        arr[i][j] = 'w';//흰색
                    else if (i >= 3 && i <= 5 && j <= 2)
                        arr[i][j] = 'g';//초록색
                    else if (i >= 3 && i <= 5 && j <= 5)
                        arr[i][j] = 'r';//빨간색
                    else if (i >= 3 && i <= 5 && j <= 8)
                        arr[i][j] = 'b';//파란색
                    else if (i >= 3 && i <= 5)
                        arr[i][j] = 'o';//오렌지색
                    else if (i >= 6 && j >= 3 && j <= 5)
                        arr[i][j] = 'y';//노란색
                }
            }
            while (l--> 0){
                String str = scan.next();
                char a = str.charAt(0);
                char b = str.charAt(1);
                Queue<Character> queue = new LinkedList<>();
                if(a == 'L'){
                    if(b == '+'){
                        for(int i = 0; i < 9; i++)
                            queue.offer(arr[i][3]);
                        for(int i = 5; i >=3; i--)
                            queue.offer(arr[i][11]);
                        for(int i = 3; i < 9; i++)
                            arr[i][3] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[i][11] = queue.poll();
                        for(int i = 0; i < 3; i++)
                            arr[i][3] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 0; j < 3; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 2; i >= 0; i--)
                            for(int j = 3; j < 6; j++)
                                arr[j][i] = queue.poll();
                    }
                    else{
                        for(int i = 0; i < 9; i++)
                            queue.offer(arr[i][3]);
                        for(int i = 5; i >=3; i--)
                            queue.offer(arr[i][11]);
                        for(int i = 5; i >= 3; i--)
                            arr[i][11] = queue.poll();
                        for(int i = 0; i < 9; i++)
                            arr[i][3] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 0; j < 3; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 0; i < 3; i++)
                            for(int j = 5; j >= 3; j--)
                                arr[j][i] = queue.poll();
                    }
                }
                if(a == 'B'){
                    if(b == '+'){
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[0][i]);
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[i][8]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[8][i]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[i][0]);
                        for(int i = 5; i >= 3; i--)
                            arr[i][0] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            arr[0][i] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            arr[i][8] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[8][i] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 9; j < 12; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 11; i >= 9; i--)
                            for(int j = 3; j < 6; j++)
                                arr[j][i] = queue.poll();
                    }else{
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[0][i]);
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[i][8]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[8][i]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[i][0]);
                        for(int i = 3; i < 6; i++)
                            arr[i][8] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[8][i] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[i][0] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            arr[0][i] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 9; j < 12; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 9; i < 12; i++)
                            for(int j = 5; j >= 3; j--)
                                arr[j][i] = queue.poll();
                    }
                }
                if(a == 'F'){
                    if(b == '+'){
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[2][i]);
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[i][6]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[6][i]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[i][2]);
                        for(int i = 3; i < 6; i++)
                            arr[i][6] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[6][i] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[i][2] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            arr[2][i] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 5; i >= 3; i--)
                            for(int j = 3; j < 6; j++)
                                arr[j][i] = queue.poll();
                    }
                    else{
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[2][i]);
                        for(int i = 3; i < 6; i++)
                            queue.offer(arr[i][6]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[6][i]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[i][2]);
                        for(int i = 5; i >= 3; i--)
                            arr[i][2] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            arr[2][i] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            arr[i][6] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[6][i] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 3; i < 6; i++)
                            for(int j = 5; j >= 3; j--)
                                arr[j][i] = queue.poll();
                    }
                }
                if(a == 'R'){
                    if(b == '+'){
                        for(int i = 0; i < 9; i++)
                            queue.offer(arr[i][5]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[i][9]);
                        for(int i = 5; i >= 3; i--)
                            arr[i][9] = queue.poll();
                        for(int i = 0; i < 9; i++)
                            arr[i][5] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 6; j < 9; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 8; i >= 6; i--)
                            for(int j = 3; j < 6; j++)
                                arr[j][i] = queue.poll();
                    }
                    else{
                        for(int i = 0; i < 9; i++)
                            queue.offer(arr[i][5]);
                        for(int i = 5; i >= 3; i--)
                            queue.offer(arr[i][9]);
                        for(int i = 3; i < 9; i++)
                            arr[i][5] = queue.poll();
                        for(int i = 5; i >= 3; i--)
                            arr[i][9] = queue.poll();
                        for(int i = 0; i < 3; i++)
                            arr[i][5] = queue.poll();
                        for(int i = 3; i < 6; i++)
                            for(int j = 6; j < 9; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 6; i < 9; i++)
                            for(int j = 5; j >= 3; j--)
                                arr[j][i] = queue.poll();
                    }
                }
                if(a == 'U'){
                    if(b == '+'){
                        for(int i = 0; i < 12; i++)
                            queue.offer(arr[3][i]);
                        for(int i = 9; i < 12; i++)
                            arr[3][i] = queue.poll();
                        for(int i = 0; i < 9; i++)
                            arr[3][i] = queue.poll();
                        for(int i = 0; i < 3; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 5; i >= 3; i--)
                            for(int j = 0; j < 3; j++)
                                arr[j][i] = queue.poll();
                    }
                    else{
                        for(int i = 0; i < 12; i++)
                            queue.offer(arr[3][i]);
                        for(int i = 3; i < 12; i++)
                            arr[3][i] = queue.poll();
                        for(int i = 0; i < 3; i++)
                            arr[3][i] = queue.poll();
                        for(int i = 0; i < 3; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 0; i < 3; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 3; i < 6; i++)
                            for(int j = 2; j >= 0; j--)
                                arr[j][i] = queue.poll();
                    }
                }
                if(a == 'D'){
                    if(b == '+'){
                        for(int i = 0; i < 12; i++)
                            queue.offer(arr[5][i]);
                        for(int i = 3; i < 12; i++)
                            arr[5][i] = queue.poll();
                        for(int i = 0; i < 3; i++)
                            arr[5][i] = queue.poll();
                        for(int i = 6; i < 9; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 5; i >= 3; i--)
                            for(int j = 6; j < 9; j++)
                                arr[j][i] = queue.poll();
                    }
                    else{
                        for(int i = 0; i < 12; i++)
                            queue.offer(arr[5][i]);
                        for(int i = 9; i < 12; i++)
                            arr[5][i] = queue.poll();
                        for(int i = 0; i < 9; i++)
                            arr[5][i] = queue.poll();
                        for(int i = 6; i < 9; i++)
                            for(int j = 3; j < 6; j++)
                                queue.offer(arr[i][j]);
                        for(int i = 3; i < 6; i++)
                            for(int j = 8; j >= 6; j--)
                                arr[j][i] = queue.poll();
                    }
                }
            }
            for(int i = 0; i < 3; i++){
                String s = "";
                for(int j = 3; j < 6; j++){
                    s += arr[i][j];
                }
                System.out.println(s);
            }
        }
    }
}
