import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int l = scan.nextInt();
        int k = scan.nextInt();
        int[][] arr = new int[k][2];
        for(int i = 0; i < k; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        int answer = 0;
        for(int i = 0; i < k; i++){
            int x = arr[i][0]; //최초 기준의 트램플린 x좌표
            for(int j = 0; j < k; j++) {
                int y = arr[j][1]; //최초 기준의 트램플린 y좌표
                int temp = 0;
                for (int t = 0; t < k; t++) {
                    int x2 = arr[t][0];
                    int y2 = arr[t][1];
                    if (x2 >= x && x2 <= x + l && y2 >= y && y2 <= y + l)
                        temp++;
                }
                answer = Math.max(answer, temp);
            }
        }
        System.out.println(k - answer);
    }
}
