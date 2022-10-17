import java.util.*;
class Fishing{
    int x;
    int y;
    int speed;
    int direction;
    int size;
    Fishing(int x, int y, int speed, int direction, int size){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}
class Main{
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = 0;
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        List<Fishing>[][] arr = new List[n + 1][m + 1];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                arr[i][j] = new ArrayList<>();
        ArrayList<Fishing> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int speed = scan.nextInt();
            int direction = scan.nextInt();
            int size = scan.nextInt();
            arr[a][b].add(new Fishing(a, b, speed, direction - 1, size));
            list.add(new Fishing(a, b, speed, direction - 1, size));
        }
        for(int i = 1; i <= m; i++){
            Fishing now = null;
            for(int j = 1; j <= n; j++){
                if(arr[j][i].size() == 1){
                    now = arr[j][i].get(0);
                    break;
                }
            }
            if(now != null){
                answer += now.size;
                arr[now.x][now.y].remove(0);
                int size = list.size();
                for(int j = 0; j < size; j++){
                    if(list.get(j).size == now.size){
                        list.remove(j);
                        break;
                    }
                }
            }
            int size = list.size();
            for(int j = 0; j < size; j++){
                Fishing temp = list.get(j);
                int nx = temp.x;
                int ny = temp.y;
                int speed = temp.speed;
                int direction = temp.direction;
                if(direction == 0 || direction == 1)
                    speed = speed % (2 * (n - 1));
                else
                    speed = speed % (2 * (m - 1));
                while (speed-- > 0){
                    nx += dir[direction][0];
                    ny += dir[direction][1];
                    if(nx <= 0 || ny <= 0 || nx >= n + 1 || ny >= m + 1){
                        nx -= dir[direction][0];
                        ny -= dir[direction][1];
                        if(direction == 0)
                            direction = 1;
                        else if(direction == 1)
                            direction = 0;
                        else if(direction == 2)
                            direction = 3;
                        else
                            direction = 2;
                        nx += dir[direction][0];
                        ny += dir[direction][1];
                    }
                }
                arr[temp.x][temp.y].remove(0);
                temp.x = nx;
                temp.y = ny;
                temp.direction = direction;
                arr[nx][ny].add(temp);
            }
            list = new ArrayList<>();
            for(int j = 1; j <= n; j++){
                for(int z = 1; z <= m; z++){
                    if(arr[j][z].size() > 1){
                        Collections.sort(arr[j][z], new Comparator<Fishing>() {
                            @Override
                            public int compare(Fishing o1, Fishing o2) {
                                return o2.size - o1.size;
                            }
                        });
                        Fishing b = arr[j][z].get(0);
                        arr[j][z] = new ArrayList<>();
                        arr[j][z].add(b);
                        list.add(arr[j][z].get(0));
                    }else if(arr[j][z].size() == 1)
                        list.add(arr[j][z].get(0));
                }
            }
        }
        System.out.println(answer);
    }
}