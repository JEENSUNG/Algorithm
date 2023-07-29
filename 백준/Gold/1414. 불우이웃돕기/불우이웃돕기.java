import java.util.*;
class Edge{
    int x;
    int y;
    int z;
    Edge(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int n;
    static int[] parents;
    static PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> (o1.z - o2.z));
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++){
            String str = scan.next();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '0') continue;
                int a;
                if(str.charAt(j) >= 'a' && str.charAt(j) <= 'z')
                    a = str.charAt(j) - 'a' + 1;
                else
                    a = str.charAt(j) - 'A' + 27;
                count += a;
                if(i != j && a != 0)
                    queue.offer(new Edge(i, j, a));
            }
        }
        parents = new int[n + 1];
        for(int i = 0; i <= n; i++)
            parents[i] = i;
        int length = 0;
        int temp = 0;
        while(!queue.isEmpty()){
            Edge now = queue.poll();
            int pa = find(now.x);
            int pb = find(now.y);
            if(pa != pb){
                union(now.x, now.y);
                length += now.z;
                temp++;
            }
        }
        if(temp == n - 1)
            System.out.println(count - length);
        else System.out.println(-1);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b)
            parents[b] = a;
    }
    static int find(int a){
        if(a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }
}
