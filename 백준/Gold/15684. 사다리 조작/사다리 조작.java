import java.util.*;
class Main{
    static int n, m, k;
    static boolean[][] visit;
    static int answer;
    public static void main(String[] args) {
        answer = 0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        visit = new boolean[k + 1][n + 1];
        for(int i = 0; i < m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            visit[a][b] = true;
        }
        boolean isOk = true;
        for(int i = 1; i <= n; i++){
            if(!check(i)){
                isOk = false;
                break;
            }
        }
        if(isOk){
            System.out.println(0);
            System.exit(0);
        }
        for(int i = 1; i <= 3; i++){
            dfs(1, 0, i);
        }
        System.out.println(-1);
    }
    static void dfs(int x, int start, int end){
        if(start > end)
            return;
        if(start == end){
            boolean isOk = true;
            for(int i = 1; i <= n; i++){
                if(!check(i)){
                    isOk = false;
                    break;
                }
            }
            if(isOk) {
                answer = end;
                System.out.println(answer);
                System.exit(0);
            }
            return;
        }
        for(int i = x; i <= k; i++){
            for(int j = 1; j <= n - 1; j++){
                if(!visit[i][j]) {
                    if ((j - 1 == 0 || !visit[i][j - 1]) && (j + 1 == n) || !visit[i][j + 1]) {
                        visit[i][j] = true;
                        dfs(i, start + 1, end);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }
    static boolean check(int start){
        int temp = start;
        for(int j = 1; j <= k; j++){
            if(temp - 1 != 0 && visit[j][temp - 1])
                temp--;
            else if(temp != n && visit[j][temp])
                temp++;
        }
        if(temp != start)
            return false;
        return true;
    }
}