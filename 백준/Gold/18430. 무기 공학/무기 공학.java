import java.util.*;
public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int answer = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                arr[i][j] = scan.nextInt();
        dfs(0, 0);
        System.out.println(answer);
    }
    static void dfs(int index, int temp){
        if(index == n * m){
            answer = Math.max(temp, answer);
            return;
        }
        int x = index / m;
        int y = index % m;
        if(!visit[x][y]){
            if(x + 1 < n && y - 1 >= 0 && !visit[x + 1][y] && !visit[x][y - 1]){
                visit[x][y] = true;
                visit[x + 1][y] = true;
                visit[x][y - 1] = true;
                dfs(index + 1, temp + arr[x + 1][y] + arr[x][y - 1] + (arr[x][y] * 2));
                visit[x][y] = false;
                visit[x + 1][y] = false;
                visit[x][y - 1] = false;
            }
            if(x + 1 < n && y + 1 < m && !visit[x + 1][y] && !visit[x][y + 1]){
                visit[x][y] = true;
                visit[x + 1][y] = true;
                visit[x][y + 1] = true;
                dfs(index + 1, temp + arr[x + 1][y] + arr[x][y + 1] + (arr[x][y] * 2));
                visit[x][y] = false;
                visit[x + 1][y] = false;
                visit[x][y + 1] = false;
            }
            if(x - 1 >= 0 && y - 1 >= 0 && !visit[x - 1][y] && !visit[x][y - 1]){
                visit[x][y] = true;
                visit[x - 1][y] = true;
                visit[x][y - 1] = true;
                dfs(index + 1, temp + arr[x - 1][y] + arr[x][y - 1] + (arr[x][y] * 2));
                visit[x][y] = false;
                visit[x - 1][y] = false;
                visit[x][y - 1] = false;
            }
            if(x - 1 >= 0 && y + 1 < m && !visit[x - 1][y] && !visit[x][y + 1]){
                visit[x][y] = true;
                visit[x - 1][y] = true;
                visit[x][y + 1] = true;
                dfs(index + 1, temp + arr[x - 1][y] + arr[x][y + 1] + (arr[x][y] * 2));
                visit[x][y] = false;
                visit[x - 1][y] = false;
                visit[x][y + 1] = false;
            }
        }
        dfs(index + 1, temp);
    }
}
