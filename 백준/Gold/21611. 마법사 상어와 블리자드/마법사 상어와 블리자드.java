import java.util.*;
class Shark{
    int x;
    int y;
    int num;
    Shark(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
    Shark(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Main{
    static int answer = 0;
    static int n, m, sharkX, sharkY;
    static int[][] arr;
    static Queue<Shark> queue = new LinkedList<>();
    static List<Shark> list = new ArrayList<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][n];
        sharkX = n / 2;
        sharkY = n / 2;
        for(int i = 0; i <n; i++)
            for(int j = 0; j < n;j++)
                arr[i][j] = scan.nextInt();
        for(int i = 0; i < m; i++)
            list.add(new Shark(scan.nextInt() - 1, scan.nextInt()));
        for(int i = 0; i < list.size(); i++){
            Shark now = list.get(i);
            int nx = sharkX;
            int ny = sharkY;
            for(int j = 1; j <= now.y; j++){
                nx += dir[now.x][0];
                ny += dir[now.x][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                    break;
                arr[nx][ny] = 0;
            }
            move();
            while (true){
                if(canBoom()){
                    boom();
                    move();
                }else  break;
            }
            Queue<Integer> test = new LinkedList<>();
            int count = 0;
            int color = queue.peek().num;
            while (!queue.isEmpty()){
                Shark p = queue.poll();
                if(p.num == color) count++;
                else {
                    test.add(count);
                    test.add(color);
                    color = p.num;
                    count = 1;
                }
            }
            if(count >= 1){
                test.add(count);
                test.add(color);
            }
            redirection(test);
        }
        System.out.println(answer);
    }
    static void move(){
        Queue<Integer> temp = new LinkedList<>();
        int nx = sharkX;
        int ny = sharkY - 1;
        int s = 0;
        int count = 1;
        if(arr[nx][ny] != 0)
            temp.offer(arr[nx][ny]);
        while (true){
            if(s == 0){
                for(int i = nx + 1; i <= Math.min(nx + count, n - 1); i++){
                    if(arr[i][ny] != 0)
                        temp.offer(arr[i][ny]);
                }
                nx += count;
                count++;
                s++;
            }else if(s == 1){
                for(int i = ny + 1; i <= Math.min(n - 1, ny + count); i++) {
                    if (arr[nx][i] != 0)
                        temp.offer(arr[nx][i]);
                }
                ny += count;
                s++;
            }else if(s == 2){
                for(int i = nx - 1; i >= Math.max(0, nx - count); i--) {
                    if (arr[i][ny] != 0)
                        temp.offer(arr[i][ny]);
                }
                nx -= count;
                s++;
            }else{
                for(int i = ny - 1; i >= Math.max(ny - count - 1, 0); i--) {
                    if (arr[nx][i] != 0)
                        temp.offer(arr[nx][i]);
                }
                count++;
                ny -= count;
                if(ny < 0)
                    break;
                s = 0;
            }
        }
        nx = sharkX;
        ny = sharkY - 1;
        count = 1;
        s = 0;
        boolean is = false;
        arr = new int[n][n];
        queue = new LinkedList<>();
        if(temp.isEmpty()) {
            System.out.println(answer);
            System.exit(0);
        }
        arr[nx][ny] = temp.poll();
        queue.offer(new Shark(nx, ny, arr[nx][ny]));
        while (!temp.isEmpty()){
            if(s == 0){
                for(int i = nx + 1; i <= Math.min(nx + count, n - 1); i++){
                    if(temp.isEmpty()){ is = true; break;}
                    arr[i][ny] = temp.poll();
                    queue.offer(new Shark(i, ny, arr[i][ny]));
                }
                nx += count;
                count++;
                s++;
            }else if(s == 1){
                for(int i = ny + 1; i <= Math.min(n - 1, ny + count); i++) {
                    if(temp.isEmpty()) { is = true; break;}
                    arr[nx][i] = temp.poll();
                    queue.offer(new Shark(nx, i, arr[nx][i]));
                }
                ny += count;
                s++;
            }else if(s == 2){
                for(int i = nx - 1; i >= Math.max(0, nx - count); i--) {
                    if(temp.isEmpty()) { is = true; break;}
                    arr[i][ny] = temp.poll();
                    queue.offer(new Shark(i, ny, arr[i][ny]));
                }
                nx -= count;
                s++;
            }else{
                for(int i = ny - 1; i >= Math.max(ny - count - 1, 0); i--) {
                    if(temp.isEmpty()) { is = true; break;}
                    arr[nx][i] = temp.poll();
                    queue.offer(new Shark(nx, i, arr[nx][i]));
                }
                count++;
                ny -= count;
                if(ny < 0)
                    break;
                s = 0;
            }
            if(is)
                break;
        }
    }
    static boolean canBoom(){
        Queue<Shark> temp = new LinkedList<>(queue);
        int count = 0;
        int num = temp.peek().num;
        while (!temp.isEmpty()){
            Shark t = temp.poll();
            if(count >= 4)
                return true;
            if(num == t.num)
                count++;
            else{
                count = 1;
                num = t.num;
            }
        }
        return count >= 4;
    }
    static void boom(){
        Queue<Shark> temp = new LinkedList<>(queue);
        Queue<Shark> tt = new LinkedList<>();
        int count = 0;
        int num = temp.peek().num;
        while (!temp.isEmpty()){
            Shark t = temp.poll();
            if(num == t.num) {
                count++;
                tt.add(t);
            }
            else if(count < 4){
                count = 1;
                num = t.num;
                tt.clear();
                tt.add(t);
            }else{
                if(num == 1)
                    answer += count;
                else if(num == 2)
                    answer += count * 2;
                else if(num == 3)
                    answer += count * 3;
                num = t.num;
                count = 1;
                while (!tt.isEmpty()){
                    Shark b = tt.poll();
                    arr[b.x][b.y] = 0;
                }
                tt.add(t);
            }
        }
        if(count >= 4){
            if(num == 1)
                answer += count;
            else if(num == 2)
                answer += count * 2;
            else if(num == 3)
                answer += count * 3;
            while (!tt.isEmpty()){
                Shark b = tt.poll();
                arr[b.x][b.y] = 0;
            }
        }
    }
    static void redirection(Queue<Integer> test){
        int nx = sharkX;
        int ny = sharkY - 1;
        int count = 1;
        int s = 0;
        boolean is = false;
        arr = new int[n][n];
        arr[nx][ny] = test.poll();
        while (!test.isEmpty()){
            if(s == 0){
                for(int i = nx + 1; i <= Math.min(nx + count, n - 1); i++){
                    if(test.isEmpty()){ is = true; break;}
                    arr[i][ny] = test.poll();
                }
                nx += count;
                count++;
                s++;
            }else if(s == 1){
                for(int i = ny + 1; i <= Math.min(n - 1, ny + count); i++) {
                    if(test.isEmpty()) { is = true; break;}
                    arr[nx][i] = test.poll();
                }
                ny += count;
                s++;
            }else if(s == 2){
                for(int i = nx - 1; i >= Math.max(0, nx - count); i--) {
                    if(test.isEmpty()) { is = true; break;}
                    arr[i][ny] = test.poll();
                }
                nx -= count;
                s++;
            }else{
                for(int i = ny - 1; i >= Math.max(ny - count - 1, 0); i--) {
                    if(test.isEmpty()) { is = true; break;}
                    arr[nx][i] = test.poll();
                }
                count++;
                ny -= count;
                if(ny < 0)
                    break;
                s = 0;
            }
            if(is)
                break;
        }
    }
}