import java.awt.*;
import java.util.*;
class Main{
    static int n, q;
    static int size;
    static int[][] arr;
    static boolean[][] visit;
    static ArrayList<Integer> list = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int answer = 0;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        q = scan.nextInt();
        size = (int)Math.pow(2, n);
        arr = new int[size][size];
        visit = new boolean[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                arr[i][j] = scan.nextInt();
        for(int i = 0; i < q; i++)
            list.add(scan.nextInt());
        int index = 0;
        while (index < q) {
            int now = (int) Math.pow(2, list.get(index));
            for (int i = 0; i < size; i += now)
                for (int j = 0; j < size; j += now)
                    rotate(i, j, i + now, j + now);
            int[][] map = new int[size][size];
            for(int i = 0; i < size; i++)
                System.arraycopy(arr[i], 0, map[i], 0, size);
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    int count = 0;
                    if(map[i][j] == 0)
                        continue;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if(nx < 0 || ny < 0 || nx >= size || ny >= size || map[nx][ny] == 0)
                            count++;
                    }
                    if(count >= 2)
                        arr[i][j]--;
                    if(arr[i][j] < 0)
                        arr[i][j] = 0;
                }
            }
            index++;
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visit[i][j] && arr[i][j] > 0){
                    sum += arr[i][j];
                    queue.offer(new Point(i, j));
                    visit[i][j] = true;
                    bfs();
                }
            }
        }
        System.out.println(sum);
        System.out.println(answer);
    }
    static void rotate(int x, int y, int X, int Y){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = x; i < X; i++)
            for(int j = y; j < Y; j++)
                queue.offer(arr[i][j]);
        for(int i = Y - 1; i >= y; i--)
            for(int j = x; j < X; j++)
                arr[j][i] = queue.poll();
    }
    static void bfs(){
        int t = 1;
        while (!queue.isEmpty()){
            Point now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= size || ny >= size)
                    continue;
                if(arr[nx][ny] == 0)
                    continue;
                if(visit[nx][ny])
                    continue;
                queue.offer(new Point(nx, ny));
                visit[nx][ny] = true;
                t++;
                sum += arr[nx][ny];
            }
        }
        answer = Math.max(t, answer);
    }
}