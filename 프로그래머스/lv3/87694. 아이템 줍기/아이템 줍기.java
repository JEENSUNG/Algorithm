import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Item{
    int x;
    int y;
    int x2;
    int y2;
    int d;
    Item(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d =d;
    }
    Item(int x, int y, int x2, int y2){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
}
class Solution {
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    static Queue<Item> queue;
    static ArrayList<Item> list;
    static int answer;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        arr = new int[102][102];
        visit = new boolean[102][102];
        queue = new LinkedList<>();
        list = new ArrayList<>();
        for(int[] rec : rectangle){
            int startX = rec[0] * 2;
            int startY = rec[1] * 2;
            int endX = rec[2] * 2;
            int endY = rec[3] * 2;
            list.add(new Item(startX, startY, endX, endY));
            for(int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    arr[i][j] -= 1;
                }
            }
        }
        queue.offer(new Item(characterX * 2, characterY * 2, 1));
        visit[characterX * 2][characterY * 2] = true;
        bfs(itemX * 2, itemY * 2);
        return answer;
    }
    static void bfs(int a, int b){
        while(!queue.isEmpty()){
            Item now = queue.poll();
            if(now.x == a && now.y == b)
                answer = Math.min(answer, (now.d - 1) / 2);
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] < 0 && !check(nx, ny)){
                    System.out.println(nx +"+" + ny);
                    queue.offer(new Item(nx, ny, now.d + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }
    static boolean check(int x, int y){
        for(Item item : list){
            if(item.x < x && x < item.x2 && item.y < y && y < item.y2)
                return true;
        }
        return false;
    }
}