import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n,m;
    static int[][] arr;
    static class Point{
        int x,y,dis, crash;
        public Point(int x, int y, int dis, int crash){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.crash = crash;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][][] visit;
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[2][n][m];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        bfs();
        System.out.println(-1);
    }
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,1,0));
        while(!queue.isEmpty()){
            Point now = queue.poll();
            if(now.x == n-1 && now.y == m-1){
                System.out.println(now.dis);
                System.exit(0);
            }
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                int next_dis = now.dis + 1;
                if(arr[nx][ny] == '0'){
                    if(!visit[now.crash][nx][ny]) {
                    	visit[now.crash][nx][ny] = true;
                    	queue.offer(new Point(nx, ny, next_dis, now.crash));
                    }
                }
                else if(arr[nx][ny] == '1'){
                    if(now.crash == 0){
                        queue.offer(new Point(nx,ny,next_dis,1));
                        visit[1][nx][ny] = true;
                    }
                }
            }
        }
    }
}