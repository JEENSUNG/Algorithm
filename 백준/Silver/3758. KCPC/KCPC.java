import java.util.*;
class KCPC {
    int id;
    int score;
    int test;
    int time;
    KCPC(int id, int score, int test, int time){
        this.id = id;
        this.score = score;
        this.test = test;
        this.time = time;
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int o = scan.nextInt();
        while (o--> 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int t = scan.nextInt() - 1;
            int m = scan.nextInt();
            List<KCPC>[] list = new List[n];
            int[][] arr = new int[n][k];
            for(int i = 0; i < n; i++)
                list[i] = new ArrayList<>();
            ArrayList<KCPC> aList = new ArrayList<>();
            for(int i = 0; i < m; i++){
                int id = scan.nextInt() - 1;
                int j = scan.nextInt() - 1;
                int s = scan.nextInt();
                if(list[id].size() == 0){
                    list[id].add(new KCPC(id, s, 1, i));
                    arr[id][j] = s;
                }
                else{
                    if(arr[id][j] ==0){
                        list[id].get(0).score += s;
                        arr[id][j] = s;
                    }
                    else if(arr[id][j] < s) {
                        list[id].get(0).score = list[id].get(0).score - arr[id][j] + s;
                        arr[id][j] = s;
                    }
                    list[id].get(0).test += 1;
                    list[id].get(0).time = i;
                }
            }
            for(int i = 0; i < n; i++)
                aList.add(list[i].get(0));
            Collections.sort(aList, new Comparator<KCPC>() {
                @Override
                public int compare(KCPC o1, KCPC o2) {
                    if(o1.score == o2.score){
                        if(o1.test == o2.test){
                            return o1.time - o2.time;
                        }
                        return o1.test - o2.test;
                    }return o2.score - o1.score;
                }
            });
            for(int i = 0; i < aList.size(); i++){
                if(aList.get(i).id == t){
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
