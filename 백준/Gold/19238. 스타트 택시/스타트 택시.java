import java.util.*;
class Taxi{
    int x;
    int y;
    int endX;
    int endY;
    int oil;
    Taxi(int x, int y, int oil){
        this.x = x;
        this.y = y;
        this.oil = oil;
    }
    Taxi(int x, int y, int endX, int endY){
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
    }
}
class Main{
    static int m, n, oil;
    static int[][] arr, map;
    static boolean [][]visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int answer;
    static Queue<Taxi> queue;
    static List<Taxi> list;
    static int sum;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        oil = scan.nextInt();
        arr = new int[n][n];
        map = new int[n][n];
        visit = new boolean[n][n];
        queue = new LinkedList<>();
        list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = scan.nextInt();
        answer = oil;
        int startX = scan.nextInt() - 1;
        int startY = scan.nextInt() - 1;
        queue.offer(new Taxi(startX, startY, 0));
        visit[startX][startY] = true;
        for(int i = 0; i < m; i++)
            list.add(new Taxi(scan.nextInt() - 1, scan.nextInt() - 1, scan.nextInt() - 1, scan.nextInt() - 1));
        for(int i = 0; i < m; i++){
            boolean isOk = false;
            Taxi taxi = queue.peek();
            bfs();
            int max = Integer.MAX_VALUE;
            int index = 0;
            int nx = 0;
            int ny = 0;
            for(int j = 0; j < list.size(); j++){
                Taxi now = list.get(j);
                if(map[now.x][now.y] < max && map[now.x][now.y] > 0){
                    max = map[now.x][now.y];
                    nx = now.x;
                    ny = now.y;
                    index = j;
                }
                else if(map[now.x][now.y] == max){
                    if(nx == now.x){
                        if(ny > now.y){
                            ny = now.y;
                            index = j;
                        }
                    }else if(nx > now.x){
                        nx = now.x;
                        ny = now.y;
                        index = j;
                    }
                }else if(map[now.x][now.y] == 0)
                    if(taxi.x == now.x && taxi.y == now.y) {
                        isOk = true;
                        index = j;
                        break;
                    }
            }
            if(max != Integer.MAX_VALUE && !isOk)
                answer = answer - max;
            if(answer < 0 || (!isOk && map[list.get(index).x][list.get(index).y] == 0)){
                System.out.println(-1);
                System.exit(0);
            }
            map = new int[n][n];
            visit = new boolean[n][n];
            visit[list.get(index).x][list.get(index).y] = true;
            queue = new LinkedList<>();
            queue.offer(new Taxi(list.get(index).x,list.get(index).y, 0));
            sum = 0;
            bfs2(list.get(index).endX, list.get(index).endY);
            answer = answer - sum;
            if(answer < 0 || map[list.get(index).endX][list.get(index).endY] == 0){
                System.out.println(-1);
                System.exit(0);
            }
            map = new int[n][n];
            visit = new boolean[n][n];
            queue = new LinkedList<>();
            queue.offer(new Taxi(list.get(index).endX, list.get(index).endY, 0));
            visit[list.get(index).endX][list.get(index).endY] = true;
            list.remove(index);
            answer = answer + (sum * 2);
        }
        System.out.println(answer);
    }
    static void bfs(){
        while (!queue.isEmpty()){
            Taxi now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 1)
                    continue;
                visit[nx][ny] = true;
                map[nx][ny] = now.oil + 1;
                queue.offer(new Taxi(nx, ny, now.oil + 1));
            }
        }
    }
    static void bfs2(int x, int y){
        while (!queue.isEmpty()){
            Taxi now = queue.poll();
            if(now.x == x && now.y == y){
                sum = now.oil;
                break;
            }
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 1)
                    continue;
                visit[nx][ny] = true;
                map[nx][ny] = now.oil + 1;
                queue.offer(new Taxi(nx, ny, now.oil + 1));
            }
        }
    }
}