import java.util.*;
class Cow{
    int x;
    int y;
    Cow(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        Cow node = (Cow) obj;

        return this.x == node.x && this.y == node.y;
    }
}
class Main{
    static int n, k, r;
    static int[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static List<Cow>[][] list;
    static boolean[][] ok;
    static ArrayList<Cow> ll = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        r = scan.nextInt();
        arr = new int[n][n];
        list = new List[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                list[i][j] = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            int c = scan.nextInt() - 1;
            int d = scan.nextInt() - 1;
            list[a][b].add(new Cow(c, d));
            list[c][d].add(new Cow(a, b));
        }
        int count = 0;
        for(int i = 0; i < k; i++){
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            ll.add(new Cow(a, b));
            arr[a][b] = 1;
        }
        for(int i = 0; i < k; i++){
            visit = new boolean[n][n];
            ok = new boolean[k][k];
            Cow cow = ll.get(i);
            Queue<Cow> queue = new LinkedList<>();
            queue.offer(new Cow(cow.x, cow.y));
            visit[cow.x][cow.y] = true;
            while (!queue.isEmpty()){
                Cow now = queue.poll();
                if(arr[now.x][now.y] == 1){
                    for(int j = i + 1; j < k; j++){
                        Cow next = ll.get(j);
                        if(next.x == now.x && next.y == now.y){
                            ok[i][j] = true;
                            break;
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    int nx = now.x + dir[j][0];
                    int ny = now.y + dir[j][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(visit[nx][ny]) continue;
                    if(list[now.x][now.y].contains(new Cow(nx, ny))) continue;
                    visit[nx][ny] = true;
                    queue.offer(new Cow(nx, ny));
                }
            }
            for(int j = i + 1; j < k; j++){
                if(!ok[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}