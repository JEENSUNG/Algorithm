import java.util.*;

class Point {
    int x;
    int cost;
    Point(int x, int cost){
        this.x = x;
        this.cost = cost;
    }
}
class Solution {
    static int[] dp;
    static HashSet<Integer> hashSet;
    static HashSet<Integer> hashSet2;
    static ArrayList<ArrayList<Point>> list;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        dp = new int[n + 1];
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }
        hashSet = new HashSet<>();
        hashSet2 = new HashSet<>();
        for (int gate : gates) hashSet.add(gate);
        for(int summit : summits) hashSet2.add(summit);

        for(int[] path : paths){
            list.get(path[0]).add(new Point(path[1], path[2]));
            list.get(path[1]).add(new Point(path[0], path[2]));
        }

        int[] answer = new int[]{0, Integer.MAX_VALUE};
        for(Integer start : hashSet)
            dfs(start);
        for(Integer temp : hashSet2){
            if(answer[1] >= dp[temp]){
                if(answer[1] == dp[temp]){
                    if(answer[0] > temp){
                        answer[0] = temp;
                        answer[1] = dp[temp];
                    }
                }else{
                    answer[0] = temp;
                    answer[1] = dp[temp];
                }
            }
        }
        return answer;
    }
    static void dfs(int start){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, 0));

        while (!queue.isEmpty()){
            Point now = queue.poll();
            if(hashSet2.contains(now.x))
                continue;

            for(Point power : list.get(now.x)){
                if(!hashSet.contains(power.x)){
                    int next = Math.max(now.cost, power.cost);
                    if(next < dp[power.x]){
                        queue.offer(new Point(power.x, next));
                        dp[power.x] = next;
                    }
                }
            }
        }
    }
}