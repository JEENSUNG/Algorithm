import java.util.*;
class Edge implements Comparable<Edge>{
    int a;
    int b;
    public Edge(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Edge o){
        return this.b - o.b;
    }
}
class Solution {
    static ArrayList<Edge>[] list;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        list = new ArrayList[n + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int z = fare[2];
            list[x].add(new Edge(y, z));
            list[y].add(new Edge(x, z));
        }
        int[] start = new int[n + 1];
        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);

        dijkstra(s, start);
        dijkstra(a, startA);
        dijkstra(b, startB);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < start.length; i++)
            answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        return answer;
    }

    public static void dijkstra(int s, int[] arr) {
        arr[s] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(s, 0));
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            for (Edge i : list[now.a])
                if (arr[i.a] > now.b + i.b) {
                    arr[i.a] = now.b + i.b;
                    queue.offer(new Edge(i.a, arr[i.a]));
                }
        }
    }
}