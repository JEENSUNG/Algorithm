import java.util.*;
class Node{
    int x;
    int y;
    int d;
    Node(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Solution {
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static Queue<Node> queue;
    static int answer;
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        arr = maps;
        visit = new boolean[arr.length][arr[0].length];
        bfs();
        if(answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }
    static void bfs(){
        queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        visit[0][0] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x == arr.length - 1 && now.y == arr[0].length - 1){
                answer = Math.min(answer, now.d);
            }
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 0)
                    continue;
                queue.offer(new Node(nx, ny, now.d + 1));
                visit[nx][ny] = true;
            }
        }
    }
}