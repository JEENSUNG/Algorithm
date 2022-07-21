import java.util.*;
class Solution{
    static ArrayList<Integer>[] visit;
    static int[] check;
    static int answer = 0;
    public static int solution(int[] info, int[][] edges){
        check = info;
        visit = new ArrayList[check.length];
        for(int i = 0; i < check.length; i++)
            visit[i] = new ArrayList<>();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            visit[a].add(b);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);
        return answer;
    }
    static void dfs(int count, int sum, int d, List<Integer> list){
        if(check[count] == 0)
            sum++;
        else
            d++;
        if(d >= sum)
            return;
        answer = Math.max(answer, sum);
        List<Integer> nextList = new ArrayList<>(list);
        nextList.remove(Integer.valueOf(count));
        if(visit[count].size() > 0){
            nextList.addAll(visit[count]);
        }
        for(int i = 0; i < nextList.size(); i++){
            dfs(nextList.get(i), sum, d, nextList);
        }
    }
}