import java.util.*;
class Chess{
    int x;
    int y;
    int dir;
    int num;
    Chess(int x, int y, int dir, int num){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.num = num;
    }
}
class Main{
    static int n, k;
    static List<Chess>[][] arr;
    static ArrayList<Chess> list;
    static int[][] map;
    static int answer;
    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) {
        answer = 0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        list = new ArrayList<>();
        arr = new List[n][n];
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = new ArrayList<>();
                map[i][j] = scan.nextInt();
            }
        }
        for(int i = 0; i < k; i++){
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            int d = scan.nextInt() - 1;
            arr[x][y].add(new Chess(x, y, d, i + 1));
            list.add(new Chess(x, y, d, i + 1));
        }
        game();
    }
    static void game(){
        answer++;
        if(answer > 1000){
            System.out.println(-1);
            System.exit(0);
        }
        for(int i = 0; i < list.size(); i++){
            Chess now = list.get(i);
            int nx = now.x + dir[now.dir][0];
            int ny = now.y + dir[now.dir][1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                nx -= dir[now.dir][0];
                ny -= dir[now.dir][1];
                if(now.dir == 0)
                    now.dir = 1;
                else if(now.dir == 1)
                    now.dir = 0;
                else if(now.dir == 2)
                    now.dir = 3;
                else
                    now.dir = 2;
                nx += dir[now.dir][0];
                ny += dir[now.dir][1];
                if(map[nx][ny] == 2)
                    continue;
            }else if(map[nx][ny] == 2){
                nx -= dir[now.dir][0];
                ny -= dir[now.dir][1];
                if(now.dir == 0)
                    now.dir = 1;
                else if(now.dir == 1)
                    now.dir = 0;
                else if(now.dir == 2)
                    now.dir = 3;
                else
                    now.dir = 2;
                nx += dir[now.dir][0];
                ny += dir[now.dir][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 2)
                    continue;
            }
            List<Chess> temp = new ArrayList<>();
            int size = arr[now.x][now.y].size();
            for(int j = 0; j < size; j++){
                temp.add(arr[now.x][now.y].get(0));
                int t = arr[now.x][now.y].get(0).num;
                arr[now.x][now.y].remove(0);
                if(t == now.num)
                    break;
            }
            if(map[nx][ny] == 0){
                List<Chess> rr = new ArrayList<>(arr[nx][ny]);
                arr[nx][ny] = new ArrayList<>(temp);
                arr[nx][ny].addAll(rr);
                for(int j = 0; j < temp.size(); j++){
                    for(int t = 0; t < list.size(); t++){
                        if(list.get(t).num == temp.get(j).num){
                            list.get(t).x = nx;
                            list.get(t).y = ny;
                            break;
                        }
                    }
                }
            }else if(map[nx][ny] == 1){
                List<Chess> rr = new ArrayList<>(arr[nx][ny]);
                List<Chess> reverse = new ArrayList<>();
                for(int j = temp.size() - 1; j >= 0; j--)
                    reverse.add(temp.get(j));
                arr[nx][ny] = new ArrayList<>(reverse);
                arr[nx][ny].addAll(rr);
                for(int j = 0; j < temp.size(); j++){
                    for(int t = 0; t < list.size(); t++){
                        if(list.get(t).num == temp.get(j).num){
                            list.get(t).x = nx;
                            list.get(t).y = ny;
                            break;
                        }
                    }
                }
            }
            if(arr[nx][ny].size() >= 4){
                System.out.println(answer);
                System.exit(0);
            }
        }
        game();
    }
}