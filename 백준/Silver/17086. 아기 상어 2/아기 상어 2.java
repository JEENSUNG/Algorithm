import java.util.*;
class Point{
    int x;
    int y;
    int cost;
    Point(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] map;
    static boolean[][] v;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    static int answer = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][m];
        map = new int[n][m];
        visit = new boolean[n][m];
        v = new boolean[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
                map[i][j] = Integer.MAX_VALUE;
            }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0)
                    answer = Math.max(answer, bfs(i, j));
            }
        }
        System.out.println(answer);
    }
    static int bfs(int x, int y){
        visit = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));
        visit[x][y] = true;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i = 0; i < 8; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(v[nx][ny]) continue;
                if(arr[nx][ny]==1)
                    return now.cost + 1;
                queue.offer(new Point(nx, ny, now.cost + 1));
                visit[nx][ny] = true;
            }
        }
        return 0;
    }
}
