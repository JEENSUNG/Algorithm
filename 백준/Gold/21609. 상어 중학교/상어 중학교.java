import java.util.*;
class Block{
    int x;
    int y;
    int sum;
    int rainbow;
    boolean[][] v;
    Block(int x, int y, int rainbow, int sum, boolean[][] v){
        this.x = x;
        this.y = y;
        this.rainbow = rainbow;
        this.sum = sum;
        this.v = v;
    }
}
public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static Queue<Block> queue;
    static int answer = 0;
    static List<Block> list;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = scan.nextInt();
        while (true){
            list = new ArrayList<>();
            visit = new boolean[n][n];
            boolean[][] visit2;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++) {
                    if (arr[i][j] > 0 && !visit[i][j]) {
                        queue = new LinkedList<>();
                        visit[i][j] = true;
                        queue.offer(new Block(i, j, 0, 1, visit));
                        bfs (i,j, arr[i][j]);
                    }
                }
            Collections.sort(list, new Comparator<Block>() {
                @Override
                public int compare(Block o1, Block o2) {
                    if(o1.sum == o2.sum){
                        if(o1.rainbow == o2.rainbow){
                            if(o1.x == o2.x){
                                return o2.y - o1.y;
                            }
                            return o2.x - o1.x;
                        }
                        return o2.rainbow - o1.rainbow;
                    }
                    return o2.sum - o1.sum;
                }
            });
            if(list.size() == 0 || list.get(0).sum == list.get(0).rainbow || list.get(0).sum < 2)
                break;
            visit2 = list.get(0).v.clone();
            answer += (int)Math.pow(list.get(0).sum, 2);
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(visit2[i][j])
                        arr[i][j] = -2;
            gravity();
            Queue<Integer> qq = new LinkedList<>();
            for(int i = n - 1; i >= 0; i--)
                for(int j = 0; j < n; j++)
                    qq.offer(arr[j][i]);
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    arr[i][j] = qq.poll();
            gravity();
        }
        System.out.println(answer);
    }
    static void bfs(int x, int y, int color){
        boolean[][] tempVisit = new boolean[n][n];
        int temp = 1;
        int tempRainbow = 0;
        tempVisit[x][y] = true;
        while (!queue.isEmpty()){
            Block now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if(tempVisit[nx][ny] || visit[nx][ny])
                    continue;
                if(arr[nx][ny] < 0)
                    continue;
                if(arr[nx][ny] == color) {
                    visit[nx][ny] = true;
                    tempVisit[nx][ny] = true;
                    queue.offer(new Block(nx, ny, now.rainbow, now.sum + 1, visit));
                    temp++;
                }
                else if(arr[nx][ny] == 0) {
                    tempVisit[nx][ny] = true;
                    queue.offer(new Block(nx, ny, now.rainbow + 1, now.sum + 1, visit));
                    temp++;
                    tempRainbow++;
                }
            }
        }
        list.add(new Block(x, y, tempRainbow, temp, tempVisit));
    }
    static void gravity(){
        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == -2){
                    int nx = i;
                    Queue<Integer> temp = new LinkedList<>();
                    for(int t = i; t >= 0; t--){
                        if(arr[t][j] == -1)
                            break;
                        if(arr[t][j] >= 0) {
                            temp.add(arr[t][j]);
                            nx = t;
                            break;
                        }
                    }
                    if(temp.size() > 0) {
                        arr[i][j] = temp.poll();
                        arr[nx][j] = -2;
                    }
                }
            }
        }
    }
}
