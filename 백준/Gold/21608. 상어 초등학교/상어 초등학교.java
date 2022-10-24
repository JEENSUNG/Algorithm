import java.util.*;
class School{
    int likeStudent;
    int blank;
    int x;
    int y;
    School(int likeStudent, int blank, int x, int y){
        this.likeStudent = likeStudent;
        this.blank = blank;
        this.x = x;
        this.y = y;
    }
}
class Main{
    static int n;
    static int[][] arr;
    static List<Integer>[] list;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n][n];
        int size = (int)Math.pow(n, 2);
        list = new List[size];
        for(int i = 0; i < size; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 5; j++)
                list[i].add(scan.nextInt());
        }
        for(int i = 0; i < size; i++){
            ArrayList<School> temp = new ArrayList<>();
            HashSet<Integer> hashSet = new HashSet<>(list[i]);
            for(int j = 1; j < 5; j++)
                hashSet.add(list[i].get(j));
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    int count = 0;
                    int blank = 0;
                    if(arr[j][k] == 0){
                        for(int t = 0; t < 4; t++){
                            int nx = j + dir[t][0];
                            int ny = k + dir[t][1];
                            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                                continue;
                            if(hashSet.contains(arr[nx][ny]))
                                count++;
                            if(arr[nx][ny] == 0)
                                blank++;
                        }
                        temp.add(new School(count, blank, j, k));
                    }
                }
            }
            Collections.sort(temp, new Comparator<School>() {
                @Override
                public int compare(School o1, School o2) {
                    if(o1.likeStudent == o2.likeStudent){
                        if(o1.blank == o2.blank){
                            if(o1.x == o2.x){
                                return o1.y - o2.y;
                            }
                            return o1.x - o2.x;
                        }
                        return o2.blank - o1.blank;
                    }
                    return o2.likeStudent - o1.likeStudent;
                }
            });
            School t = temp.get(0);
            arr[t.x][t.y] = list[i].get(0);
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for(int t = 0; t < size; t++){
                    if(list[t].get(0) == arr[i][j]){
                        for(int z = 1; z < 5; z++)
                            hashSet.add(list[t].get(z));
                        break;
                    }
                }
                int count = 0;
                for(int k = 0; k < 4; k++){
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;
                    if(hashSet.contains(arr[nx][ny]))
                        count++;
                }
                if(count == 1)
                    answer++;
                else if(count == 2)
                    answer += 10;
                else if(count == 3)
                    answer += 100;
                else if(count == 4)
                    answer += 1000;
            }
        }
        System.out.println(answer);
    }
}