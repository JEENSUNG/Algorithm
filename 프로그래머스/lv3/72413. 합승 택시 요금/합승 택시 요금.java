import java.util.*;
class Edge implements Comparable<Edge>{
    int index;
    int cost;
    Edge(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
class Solution{
    static ArrayList<ArrayList<Edge>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares){
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for(int[] i : fares){
            graph.get(i[0]).add(new Edge(i[1], i[2]));
            graph.get(i[1]).add(new Edge(i[0], i[2]));
        }
        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];
        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(start, Integer.MAX_VALUE);

        dijkstra(a, startA);
        dijkstra(b, startB);
        dijkstra(s, start);
        for(int i = 1; i <= n; i++)
            answer = Math.min(answer, startB[i] + start[i] + startA[i]);
        return answer;
    }
    static void dijkstra(int start, int[] costs){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, 0));
        costs[start] = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int nowIndex = now.index;
            int nowCost = now.cost;
            if(nowCost > costs[nowIndex])
                continue;
            ArrayList<Edge> edges = graph.get(nowIndex);
            for(Edge edge : edges){
                int cost = costs[nowIndex] + edge.cost;
                if(cost < costs[edge.index]) {
                    costs[edge.index] = cost;
                    queue.offer(new Edge(edge.index, cost));
                }
            }
        }
    }
}