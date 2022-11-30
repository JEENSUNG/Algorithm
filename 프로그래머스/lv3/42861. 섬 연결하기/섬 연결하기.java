import java.util.*;
class Node{
    int x;
    int y;
    int cost;
    Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
class Solution {
    static int answer = 0;
    static int[] arr;
    static PriorityQueue<Node> queue;
    public int solution(int n, int[][] costs) {
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = i;
        queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        for(int i = 0; i < costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int z = costs[i][2];
            queue.offer(new Node(x, y, z));
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(find(now.x) == find(now.y)) continue;
            union(now.x, now.y);
            answer += now.cost;
        }
        return answer;
    }
    static int find(int x){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }
    static void union(int a, int b){
        arr[find(a)] = find(b);
    }
}