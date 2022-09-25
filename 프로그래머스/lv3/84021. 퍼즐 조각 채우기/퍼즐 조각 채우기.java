import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Power implements Comparable<Power>{
    int x;
    int y;
    Power(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Power o){
        if(o.x == this.x)
            return this.y - o.y;
        return this.x - o.x;
    }
}
class Solution {
    static ArrayList<ArrayList<Power>> alist;
    static ArrayList<ArrayList<Power>> list;
    static int[][] arr;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static Queue<Power> queue;
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        queue = new LinkedList<>();
        visit = new boolean[table.length][table[0].length];
        list = new ArrayList<>();
        alist = new ArrayList<>();
        arr = game_board;
        map = table;
        int count = 2;
        int dir = 0;
        int pir = 0;
        for(int i = 0; i <= 2500; i++)
            list.add(new ArrayList<>());
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                if(table[i][j] == 1 && !visit[i][j]) {
                    bfs(count ,i, j);
                    dir++;
                    count++;
                }
            }
        }
        for(int i = 2; i < count; i++)
            Collections.sort(list.get(i));
        //여기까지는 list생성
        count = 2;
        for(int i = 0; i <= 2500; i++)
            alist.add(new ArrayList<>());

        visit = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[0].length; j++)
                if(game_board[i][j] == 0 && !visit[i][j]){
                    bfs2(count, i, j);
                    count++;
                    pir++;
                }
        for(int i = 2; i < count; i++)
            Collections.sort(alist.get(i));
//        alist 생성
        boolean[] boardVisit = new boolean[alist.size()];
        for(int i = 2; i < 2 + dir; i++){
            ArrayList<Power> li = list.get(i);
            for(int j = 2; j < 2 + pir; j++){
                ArrayList<Power> ali = alist.get(j);
                if(li.size() == ali.size()) {
                    if (rotate(li, ali) && !boardVisit[j]) {
                        answer += ali.size();
                        System.out.println(ali.size());
                        boardVisit[j] = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }
    static void bfs(int t, int x, int y){
        queue = new LinkedList<>();
        queue.offer(new Power(x, y));
        visit[x][y] = true;
        list.get(t).add(new Power(0, 0));
        while(!queue.isEmpty()){
            Power now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(map[nx][ny] == 0)
                    continue;
                visit[nx][ny] = true;
                queue.offer(new Power(nx, ny));
                list.get(t).add(new Power(nx - x, ny - y));
            }
        }
    }
    static void bfs2(int t, int x, int y){
        queue = new LinkedList<>();
        visit[x][y] = true;
        queue.offer(new Power(x, y));
        alist.get(t).add(new Power(0, 0));
        while(!queue.isEmpty()){
            Power now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 1)
                    continue;
                queue.offer(new Power(nx, ny));
                visit[nx][ny] = true;
                alist.get(t).add(new Power(nx - x, ny - y));
            }
        }
    }
    static boolean rotate(ArrayList<Power> li, ArrayList<Power> ali){
        for(int i = 0; i < 4; i++){
            int x = ali.get(0).x;
            int y = ali.get(0).y;
            for(int j = 0; j < ali.size(); j++){
                ali.get(j).x -= x;
                ali.get(j).y -= y;
            }
            boolean isOk = true;
            for(int j = 0; j < li.size(); j++){
                Power a = li.get(j);
                Power b = ali.get(j);
                if(a.x != b.x || a.y != b.y){
                    isOk = false;
                    break;
                }
            }
            if(isOk)
                return true;
            else{
                for(int j = 0; j < ali.size(); j++){
                    int temp = ali.get(j).x;
                    ali.get(j).x = ali.get(j).y;
                    ali.get(j).y = -temp;
                }
                Collections.sort(ali);
            }
        }
        return false;
    }
}