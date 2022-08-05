import java.util.*;
class Node{
    int x;
    int y;
    int dir;
    Node(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int temp;
    static char[][] arr;
    static boolean[][] visit;
    static Queue<Node> queue;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++){
            arr = new char[5][5];
            visit = new boolean[5][5];
            queue = new LinkedList<>();
            ArrayList<Node> list = new ArrayList<>();
            temp = 3;
            for(int j = 0; j < 5; j++){
                String temp = places[i][j];
                for(int k = 0; k < 5; k++){
                    arr[j][k] = temp.charAt(k);
                    if(arr[j][k] == 'P') {
                        list.add(new Node(j, k));
                    }
                }
            }
            if(list.size() == 0) {
                answer[i] = 1;
                continue;
            }
            for(int t = 0; t < list.size(); t++) {
                visit = new boolean[5][5];
                queue = new LinkedList<>();
                Node pp = list.get(t);
                int px = pp.x;
                int py = pp.y;
                queue.offer(new Node(px, py, 0));
                visit[px][py] = true;
                bfs(px, py);
                if(temp <= 2){
                    answer[i] = 0;
                    break;
                }
            }
            if(temp > 2)
                answer[i] = 1;
        }

        return answer;
    }
    static void bfs(int x, int y){
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(arr[now.x][now.y] == 'P' && (x != now.x || y != now.y)){
                temp = Math.min(temp, now.dir);
                break;
            }
            for(int i = 0; i < 4; i++){
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 'X')
                    continue;
                queue.offer(new Node(nx, ny, now.dir + 1));
                visit[nx][ny] = true;
            }
        }
    }
}