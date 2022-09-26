import java.util.*;
class Po{
    int x;
    int y;
    int sum;
    Po(int x, int y, int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
public class Main{
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] arr;
    static int[][] dp;
    static Queue<Po> queue;
    static int answer;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while(true){
            int n = scan.nextInt();
            if(n == 0)
                System.exit(0);
            arr = new int[n][n];
            dp = new int[n][n];
            answer = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    arr[i][j] = scan.nextInt();
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    dp[i][j] = 10000000;
            dp[0][0] = arr[0][0];
            queue = new LinkedList<>();
            queue.offer(new Po(0, 0, arr[0][0]));
            dfs();
            System.out.println("Problem " + count + ": " + answer);
            count++;
        }
    }
    static void dfs(){
        while (!queue.isEmpty()){
            Po now = queue.poll();
            if(now.x == arr.length - 1 && now.y == arr.length - 1) {
                answer = Math.min(answer, dp[arr.length-1][arr.length-1]);
            }
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
                    continue;
                if(dp[now.x][now.y] + arr[nx][ny] < dp[nx][ny]){
                    dp[nx][ny] = dp[now.x][now.y] + arr[nx][ny];
                    queue.offer(new Po(nx, ny, dp[nx][ny]));
                }
            }
        }
    }
}