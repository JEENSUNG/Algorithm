import java.util.LinkedList;
import java.util.Queue;
class Point{
    int x1;
    int y1;
    int x2;
    int y2;
    int time;
    Point(int x1, int y1, int x2, int y2, int time){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.time = time;
    }
}
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] dir2 = {{0, 0}, {0, 0}, {0, 1}, {0, -1}};
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int[][] move = {{1,-1},{-1,-1},{-1,1},{1,1}};
    static int[][] move2 = {{1,1},{-1,1},{1,1},{1,-1}};
    static int[][] move3 = {{1,-1},{-1,-1},{-1,1},{-1,-1}};
    static Queue<Point> queue = new LinkedList<>();
    static boolean[][][][] visit;
    public int solution(int[][] board) {
        arr = board;
        visit = new boolean[arr.length][arr.length][arr.length][arr.length];
        visit[0][0][0][1] = true;
        queue.offer(new Point(0, 0, 0, 1, 0));
        bfs();
        return answer;
    }
    static void bfs(){
        while(!queue.isEmpty()){
            Point now = queue.poll();
            if((now.x1 == arr.length - 1 && now.y1 == arr.length - 1)
            || (now.x2 == arr.length - 1 && now.y2 == arr.length - 1))
                answer = Math.min(answer, now.time);
            for(int i = 0; i < 8; i++){
                if(i >= 4){
                    dfs(i, now);
                    continue;
                }
                int nx1 = now.x1 + dir[i][0];
                int ny1 = now.y1 + dir[i][1];
                int nx2 = now.x2 + dir[i][0];
                int ny2 = now.y2 + dir[i][1];
                if(nx1 < 0 || ny1 < 0 || nx1 >= arr.length || ny1 >= arr.length)
                    continue;
                if(nx2 < 0 || ny2 < 0 || nx2 >= arr.length || ny2 >= arr.length)
                    continue;
                if(visit[nx1][ny1][nx2][ny2])
                    continue;
                if(arr[nx1][ny1] == 1 || arr[nx2][ny2] == 1)
                    continue;
                queue.offer(new Point(nx1, ny1, nx2, ny2, now.time + 1));
                visit[nx1][ny1][nx2][ny2] =  true;
            }
        }
    }
    static void dfs(int t, Point now){
        if(now.x1 == now.x2 && t == 4) {
            if(now.y1 > now.y2){
                int temp = now.y2;
                now.y2 = now.y1;
                now.y1 = temp;
            }
            //x2, y2 이동(가로모양일 때 오른쪽에 있는)
            for (int i = 0; i < 2; i++) {
                int nx = now.x2 + move[i][0];
                int ny = now.y2 + move[i][1];
                int mx = now.x2 + dir[i][0];
                int my = now.y2 + dir[i][1];
                if(mx < 0 || my < 0 || mx >= arr.length || my >= arr.length)
                    continue;
                if(arr[mx][my] == 1)
                    continue;
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
                    continue;
                if (visit[now.x1][now.y1][nx][ny])
                    continue;
                if (arr[nx][ny] == 1)
                    continue;
                queue.offer(new Point(now.x1, now.y1, nx, ny, now.time + 1));
                visit[now.x1][now.y1][nx][ny] = true;
            }
        }else if(now.x1 == now.x2 && t == 5){//가로모양일 때 왼쪽에 있는 x1, y1 이동
            if(now.y1 > now.y2){
                int temp = now.y2;
                now.y2 = now.y1;
                now.y1 = temp;
            }
            for (int i = 0; i < 2; i++) {
                int nx = now.x1 + move2[i][0];
                int ny = now.y1 + move2[i][1];
                int mx = now.x1 + dir[i][0];
                int my = now.y1 + dir[i][1];
                if(mx < 0 || my < 0 || mx >= arr.length || my >= arr.length)
                    continue;
                if(arr[mx][my] == 1)
                    continue;
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
                    continue;
                if (visit[nx][ny][now.x2][now.y2])
                    continue;
                if (arr[nx][ny] == 1)
                    continue;
                queue.offer(new Point(nx, ny, now.x2, now.y2, now.time + 1));
                visit[nx][ny][now.x2][now.y2] =  true;
            }
        }else if(now.y1 == now.y2 && t == 6){ //세로 모양일 때 위에 있는 x1, y1 이동
            if(now.x1 > now.x2){
                int temp = now.x2;
                now.x2 = now.x1;
                now.x1 = temp;
            }
            for (int i = 2; i < 4; i++) {
                int nx = now.x1 + move2[i][0];
                int ny = now.y1 + move2[i][1];
                int mx = now.x1 + dir2[i][0];
                int my = now.y1 + dir2[i][1];
                if(mx < 0 || my < 0 || mx >= arr.length || my >= arr.length)
                    continue;
                if(arr[mx][my] == 1)
                    continue;
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
                    continue;
                if (visit[nx][ny][now.x2][now.y2])
                    continue;
                if (arr[nx][ny] == 1)
                    continue;
                queue.offer(new Point(nx, ny, now.x2, now.y2, now.time + 1));
                visit[nx][ny][now.x2][now.y2] =  true;
            }
        }else if(now.y1 == now.y2 && t == 7){ //세로 모양일 때 아래에 있는 x2, y2 이동
            if(now.x1 > now.x2){
                int temp = now.x2;
                now.x2 = now.x1;
                now.x1 = temp;
            }
            for (int i = 2; i < 4; i++) {
                int nx = now.x2 + move3[i][0];
                int ny = now.y2 + move3[i][1];
                int mx = now.x2 + dir2[i][0];
                int my = now.y2 + dir2[i][1];
                if(mx < 0 || my < 0 || mx >= arr.length || my >= arr.length)
                    continue;
                if(arr[mx][my] == 1)
                    continue;
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
                    continue;
                if (visit[now.x1][now.y1][nx][ny])
                    continue;
                if (arr[nx][ny] == 1)
                    continue;
                queue.offer(new Point(now.x1, now.y1, nx, ny, now.time + 1));
                visit[now.x1][now.y1][nx][ny] =  true;
            }
        }
    }
}