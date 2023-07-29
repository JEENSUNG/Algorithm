import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n, m, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][h + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i - 1][0] = 1;
            int x = st.countTokens();
            for(int j = 0; j < x; j++){
                int t = Integer.parseInt(st.nextToken());
                for(int k = t; k <= h; k++)
                    arr[i][k] = (arr[i][k] + arr[i - 1][k - t]) % 10007;
            }
            for(int j = 1; j <= h; j++)
                arr[i][j] = (arr[i][j] + arr[i - 1][j]) % 10007;
        }
        System.out.println(arr[n][h]);
    }
}
