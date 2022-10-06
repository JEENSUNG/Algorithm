import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] arr = new String[10];
        arr[0] = "";
        arr[1] = "";
        arr[2] = "1";
        arr[3] = "7";
        arr[4] = "4";
        arr[5] = "5";
        arr[6] = "9";
        arr[7] = "8";
        arr[8] = "";
        arr[9] = "";
        String[] ans = new String[10];
        ans[0] = "";
        ans[1] = "";
        ans[2] = "1";
        ans[3] = "7";
        ans[4] = "4";
        ans[5] = "2";
        ans[6] = "6";
        ans[7] = "8";
        ans[8] = "10";
        ans[9] = "0";
        while(n--> 0){
            int x = scan.nextInt();
            String M = "";
            String m = "";
            int temp = x;
            while(temp > 3){
                M += "1";
                temp = temp - 2;
            }
            M = arr[temp] + M;
            System.out.println(GetMinNumber(x) + " " + M);
        }
    }
    private static long GetMinNumber(int x) {
        long[] min = new long[101];
        for(int i = 0; i <= 100; i++)
            min[i] = Long.MAX_VALUE;
        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6; // 다른 숫자 뒤에 올 때는 0
        min[7] = 8;
        min[8] = 10;
        String[] add = { "1", "7", "4", "2", "0", "8" };

        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String curr = String.valueOf(min[i - j]) + add[j - 2];
                min[i] = Math.min(min[i], Long.parseLong(curr));
            }
        }
        return min[x];
    }
}
