import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Internet{
    int x;
    int cost;
    Internet(int x, int cost){
        this.x = x;
        this.cost = cost;
    }
}
class Main{
    static int n, p, k;
    static List<Internet>[] list;
    static Queue<Internet> queue;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Internet(b, c));
            list[b].add(new Internet(a, c));
        }
        int min = 0;
        int max = 1000000000;
        int answer = -1;
        while (min <= max){
            int mid = (min + max) / 2;
            if(dfs(mid)){
                answer = mid;
                max = mid - 1;
            }else min = mid + 1;
        }
        System.out.println(answer);
    }
    static boolean dfs(int x){
        arr = new int[n + 1];
        for(int i = 2; i <= n;i++)
            arr[i] = 1000000000;
        queue = new LinkedList<>();
        queue.offer(new Internet(1, 0));
        while (!queue.isEmpty()){
            Internet now = queue.poll();
            for(Internet next : list[now.x]){
                int d = next.cost <= x ? 0 : 1;
                if(arr[next.x] > now.cost + d){
                    arr[next.x] = now.cost + d;
                    queue.offer(new Internet(next.x, arr[next.x]));
                }
            }
        }
        return arr[n] <= k;
    }
}