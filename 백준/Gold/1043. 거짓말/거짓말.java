import java.util.*;
class Main{
    static int n, m;
    static HashSet<Integer> hashSet;
    static boolean isOk;
    static List<Integer>[] list;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int x = scan.nextInt();
        if(x == 0){
            System.out.println(m);
            System.exit(0);
        }
        hashSet = new HashSet<>();
        for(int i = 0; i < x; i++)
            hashSet.add(scan.nextInt());
        list = new List[m];
        for(int i = 0; i < m; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int temp = scan.nextInt();
            for(int j = 0; j < temp; j++)
                list[i].add(scan.nextInt());
        }
        while (true){
            isOk = true;
            for(int i = 0; i < m; i++){
                dfs(0, i);
                if(!isOk)
                    break;
            }
            if(isOk)
                break;
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            boolean ok = true;
            for(int j = 0; j < list[i].size(); j++){
                if(hashSet.contains(list[i].get(j))){
                    ok = false;
                    break;
                }
            }
            if(ok) count++;
        }
        System.out.println(count);
    }
    static void dfs(int start, int x){
        ArrayList<Integer> ll = new ArrayList<>();
        int originSize = hashSet.size();
        boolean run = false;
        for(int i = 0; i < list[x].size(); i++){
            if(hashSet.contains(list[x].get(i)))
                run = true;
            ll.add(list[x].get(i));
        }
        HashSet<Integer> temp = new HashSet<>(hashSet);
        temp.addAll(ll);
        int s = temp.size();
        if(run){
            if(s != originSize) {
                isOk = false;
                hashSet.addAll(ll);
            }
        }
    }
}