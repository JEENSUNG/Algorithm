import java.util.*;
class Moon{
    int x;
    int y;
    int d;
    int sum;
    Moon(int x, int y, int d, int sum){
        this.x = x;
        this.y = y;
        this.d = d;
        this.sum = sum;
    }
}
class Main{
    static int[][] arr;
    static int n, m;
    static Queue<Moon> queue;
    static int[][] dir = {{1,0},{1,-1},{1,1}};
    static int answer;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                arr[i][j] = scan.nextInt();
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            queue = new LinkedList<>();
            queue.offer(new Moon(0, i, -1, arr[0][i]));
            bfs();
        }
        System.out.println(answer);
    }
    static void bfs(){
        while (!queue.isEmpty()){
            Moon now = queue.poll();
            if(now.x == n - 1)
                answer = Math.min(answer, now.sum);
            for(int i = 0; i < 3; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(now.d == i)
                    continue;
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                queue.offer(new Moon(nx, ny, i, now.sum + arr[nx][ny]));
            }
        }
    }
}