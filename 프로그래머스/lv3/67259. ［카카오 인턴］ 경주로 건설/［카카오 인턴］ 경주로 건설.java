import java.util.LinkedList;
import java.util.Queue;

class Power{
    int x;
    int y;
    int cost;
    int d;
    Power(int x, int y, int cost, int d){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.d = d;
    }
}
class Solution {
    static int[][] arr;
    static Queue<Power> queue;
    static int[][] dir = {{-1,0}, {1, 0}, {0, 1}, {0,-1}};
    static boolean[][] visit;
    static int answer;
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        arr = board;
        queue = new LinkedList<>();
        if(arr[1][0] != 1) {
            queue.offer(new Power(1, 0, 100, 1));
            visit = new boolean[board.length][board.length];
            visit[0][0] = true;
            visit[1][0] = true;
            arr[1][0] = 100;
            bfs();
        }
        if(arr[0][1] != 1) {
            arr = board;
            queue = new LinkedList<>();
            queue.offer(new Power(0, 1, 100, 2));
            visit = new boolean[board.length][board.length];
            visit[0][1] = true;
            visit[0][0] = true;
            arr[0][1] = 100;
            bfs();
        }
        return answer;
    }
    static void bfs(){
        while(!queue.isEmpty()){
            Power now = queue.poll();
            if(now.x == arr.length - 1 && now.y == arr.length - 1)
                answer = Math.min(answer, now.cost);
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
                    continue;
                if(arr[nx][ny] == 1)
                    continue;
                int t;
                if(now.d == i)
                    t = now.cost + 100;
                else
                    t = now.cost + 600;
                if(!visit[nx][ny] || arr[nx][ny] >= t) {
                    queue.offer(new Power(nx, ny, t, i));
                    arr[nx][ny] = t;
                    visit[nx][ny] = true;
                }
            }
        }
    }
}