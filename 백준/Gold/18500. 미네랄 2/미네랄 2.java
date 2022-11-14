import java.util.*;
class G{
    int x;
    int y;
    int cost;
    G(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
class Main{
    static int r, c, n;
    static int[][] arr;
    static boolean[][] vv;
    static Queue<G> q;
    static ArrayList<Integer> list;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        r = scan.nextInt();
        c = scan.nextInt();
        arr = new int[r][c];
        list = new ArrayList<>();
        for(int i = 0; i < r; i++){
            String str = scan.next();
            for(int j = 0; j < c; j++) {
                if(str.charAt(j) == '.')
                    arr[i][j] = 0;
                else
                    arr[i][j] = 1;
            }
        }
        n = scan.nextInt();
        for(int i = 0; i < n; i++)
            list.add(scan.nextInt());
        for(int i = 0; i < n; i++){
            visit = new boolean[r][c];
            vv = new boolean[r][c];
            if(i % 2 == 0) {
                int now = r - list.get(i);
                int ny = 0;
                for (int j = 0; j < c; j++) {
                    if(arr[now][j] == 1){
                        ny = j;
                        break;
                    }
                }
                arr[now][ny] = 0;
                for(int j = 0; j < c; j++)
                    if(arr[r - 1][j] == 1 && !visit[r - 1][j])
                        bfs2(r - 1, j);
                boolean ok = false;
                for(int j = 0; j < r; j++){
                    for(int k = 0; k < c; k++){
                        if(arr[j][k] == 1 && !visit[j][k]) {
                            bfs(j, k);
                            ok = true;
                            break;
                        }
                    }
                    if(ok) break;
                }
            }else{
                int now = r - list.get(i);
                int ny = 0;
                for (int j = c - 1; j >= 0; j--) {
                    if(arr[now][j] == 1){
                        ny = j;
                        break;
                    }
                }
                arr[now][ny] = 0;
                for(int j = 0; j < c; j++)
                    if(arr[r - 1][j] == 1 && !visit[r - 1][j])
                        bfs2(r - 1, j);
                boolean ok = false;
                for(int j = 0; j < r; j++){
                    for(int k = 0; k < c; k++){
                        if(arr[j][k] == 1 && !visit[j][k]) {
                            bfs(j, k);
                            ok = true;
                            break;
                        }
                    }if(ok) break;
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arr[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("x");
                if(j == c - 1)
                    System.out.println();
            }
        }
    }
    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.offer(new G(x, y, 0));
        vv[x][y] = true;
        Queue<G> temp = new LinkedList<>();
        temp.offer(new G(x, y, 0));
        visit[x][y] = true;
        while (!q.isEmpty()){
            G now = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 1){
                    q.offer(new G(nx, ny, now.cost + 1));
                    temp.offer(new G(nx, ny, now.cost + 1));
                    visit[nx][ny] = true;
                    vv[nx][ny] = true;
                }
            }
        }
        boolean is = true;
        int d = 0;
        for(int i = 1; i <= r; i++){
            for(G tem : temp){
                if(tem.x + i >= r || (arr[tem.x + i][tem.y] == 1 && !vv[tem.x + i][tem.y])){
                    d = i - 1;
                    is = false;
                    break;
                }
            }
            if(!is) break;
        }
        for(G tem : temp)
            arr[tem.x][tem.y] = 0;
        for(G tem : temp)
            arr[tem.x + d][tem.y] = 1;
    }
    static void bfs2(int x, int y){
        Queue<G> tt = new LinkedList<>();
        tt.offer(new G(x, y, 0));
        visit[x][y] = true;
        while (!tt.isEmpty()){
            G now = tt.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 1){
                    tt.offer(new G(nx, ny, now.cost + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}