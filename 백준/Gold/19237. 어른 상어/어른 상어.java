import java.util.*;
class Shark{
    int x;
    int y;
    int dir;
    int num;
    Shark(int x, int y, int dir, int num){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.num = num;
    }
}
class Gas{
    int x;
    int y;
    int size;
    int num;
    Gas(int x, int y, int size, int num){
        this.x = x;
        this.y = y;
        this.size = size;
        this.num = num;
    }
}
class Main{
    static int n, m, k;
    static List<Shark>[][] sharkList;
    static List<Shark> list;
    static List<Gas>[][] gasList;
    static List<Integer>[][] dirList;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        dirList = new List[m][4];
        sharkList = new List[n][n];
        list = new ArrayList<>();
        gasList = new List[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int x = scan.nextInt() - 1;
                sharkList[i][j] = new ArrayList<>();
                gasList[i][j] = new ArrayList<>();
                if(x >= 0) {
                    sharkList[i][j].add(new Shark(i, j, -1, x));
                    list.add(new Shark(i, j, -1, x));
                }
            }
        }
        Collections.sort(list, new Comparator<Shark>() {
            @Override
            public int compare(Shark o1, Shark o2) {
                return o1.num - o2.num;
            }
        });
        for(int i = 0; i < m; i++){
            int t = scan.nextInt() - 1;
            list.get(i).dir = t;
            sharkList[list.get(i).x][list.get(i).y].get(0).dir = t;
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < 4; j++)
                dirList[i][j] = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < 4 * m; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < 4; j++)
                temp.add(scan.nextInt() - 1);
            dirList[i / 4][count].addAll(temp);
            count++;
            if(count == 4)
                count = 0;
        }
        int answer = 0;
        while (answer++ < 1000){
            int size = list.size();
            for(int i = 0; i < size; i++) {
                Shark now = list.get(i);
                if (gasList[now.x][now.y].size() == 1)
                    gasList[now.x][now.y].get(0).size = k;
                else if (gasList[now.x][now.y].size() == 0)
                    gasList[now.x][now.y].add(new Gas(now.x, now.y, k, now.num));
            }
            for(int i = 0; i < size; i++){
                Shark now = list.get(i);
                int nx = 0;
                int ny = 0;
                int d = 0;
                boolean isOk = false;
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = 0; j < 4; j++){
                    d = dirList[now.num][now.dir].get(j);
                    nx = now.x + dir[d][0];
                    ny = now.y + dir[d][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;
                    if(gasList[nx][ny].size() == 0){
                        isOk = true;
                        break;
                    }
                    if(gasList[nx][ny].get(0).num == now.num){
                        temp.add(nx);
                        temp.add(ny);
                        temp.add(d);
                    }
                }
                if(isOk){
                    sharkList[now.x][now.y].remove(0);
                    sharkList[nx][ny].add(new Shark(nx, ny, d, now.num));
                    now.x = nx;
                    now.y = ny;
                    now.dir = d;
                }else{
                    sharkList[now.x][now.y].remove(0);
                    sharkList[temp.get(0)][temp.get(1)].add(new Shark(temp.get(0),temp.get(1),temp.get(2),now.num));
                    now.x = temp.get(0);
                    now.y = temp.get(1);
                    now.dir = temp.get(2);
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(gasList[i][j].size() == 1){
                        gasList[i][j].get(0).size--;
                        if(gasList[i][j].get(0).size == 0)
                            gasList[i][j].remove(0);
                    }
                }
            }
            HashSet<Integer> hashSet = new HashSet<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(sharkList[i][j].size() > 1){
                        Collections.sort(sharkList[i][j], new Comparator<Shark>() {
                            @Override
                            public int compare(Shark o1, Shark o2) {
                                return o1.num - o2.num;
                            }
                        });
                        for(int z = 1; z < sharkList[i][j].size(); z++)
                            hashSet.add(sharkList[i][j].get(z).num);
                        sharkList[i][j] = new ArrayList<>(sharkList[i][j].subList(0, 1));
                    }
                }
            }
            ArrayList<Shark> z = new ArrayList<>();
            for(int i = 0; i < list.size(); i++)
                if(!hashSet.contains(list.get(i).num))
                    z.add(list.get(i));
            list = new ArrayList<>(z);
            if(list.size() == 1){
                System.out.println(answer);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}