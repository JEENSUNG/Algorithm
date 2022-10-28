import java.util.*;
class FireBall{
    int x;
    int y;
    int m;
    int s;
    int d;
    FireBall(int x, int y, int m, int s, int d){
        this.x = x;
        this.y = y;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
class Main{
    static int n, m, k;
    static List<FireBall>[][] arr;
    static List<FireBall> list;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        arr = new List[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = new ArrayList<>();
        list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            int t = scan.nextInt();
            int s = scan.nextInt();
            int d = scan.nextByte();
            list.add(new FireBall(x, y, t, s, d));
        }
        int index = 0;
        while (index < k){
            for (FireBall now : list) {
                int nx = (now.x + n + dir[now.d][0] * (now.s % n)) % n;
                int ny = (now.y + n + dir[now.d][1] * (now.s % n)) % n;
                arr[nx][ny].add(now);
                now.x = nx;
                now.y = ny;
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j].size() == 1)
                        arr[i][j].clear();
                    if(arr[i][j].size() >= 2){
                        int mSum = 0;
                        int mSpeed = 0;
                        int is = arr[i][j].get(0).d % 2;
                        boolean isOk = true;
                        for(FireBall now : arr[i][j]) {
                            mSum += now.m;
                            mSpeed += now.s;
                            if (now.d % 2 != is)
                                isOk = false;
                            list.remove(now);
                        }
                        int newSize = arr[i][j].size();
                        int newSum = mSum / 5;
                        int newSpeed = mSpeed / newSize;
                        arr[i][j].clear();
                        if(newSum == 0){
                            continue;
                        }
                        //isOk = false면 1, 3, 5, 7, true면 0, 2, 4, 6
                        if(!isOk){
                            list.add(new FireBall(i, j, newSum, newSpeed, 1));
                            list.add(new FireBall(i, j, newSum, newSpeed, 3));
                            list.add(new FireBall(i, j, newSum, newSpeed, 5));
                            list.add(new FireBall(i, j, newSum, newSpeed, 7));
                        }else{
                            list.add(new FireBall(i, j, newSum, newSpeed, 0));
                            list.add(new FireBall(i, j, newSum, newSpeed, 2));
                            list.add(new FireBall(i, j, newSum, newSpeed, 4));
                            list.add(new FireBall(i, j, newSum, newSpeed, 6));
                        }

                    }
                }
            }
            index++;
        }
        int sum = 0;
        for(FireBall fire : list)
            sum += fire.m;
        System.out.println(sum);
    }
}