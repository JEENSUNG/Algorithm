import java.util.LinkedList;
import java.util.Queue;
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static int[][] arr;
    static int count;
    static int size;
    static Queue<Point> queue = new LinkedList<>();
    public int[] solution(int m, int n, int[][] picture) {
        count = 0;
        size = 0;
        arr = picture;
        visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j] && arr[i][j] > 0) {
                    bfs(i, j, m, n);
                    size++;
                }
            }
        }//1 1 1 0
        // 1 2 2 0
        // 1 0 0 1
        // 0 0 0 1
        // 0 0 0 3
        // 0 0 0 3
        int[] answer = new int[2];
        answer[0] = size;
        answer[1] = count;
        return answer;
    }
    static void bfs(int x, int y, int m, int n){
        int t = 1;
        queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == arr[x][y]){
                    visit[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                    t++;
                }
            }
        }
        count = Math.max(count, t);
    }
}