import java.util.*;
class Solution{
    static boolean[][] visit;
    static boolean[] check;
    static Queue<Integer> queue = new LinkedList<>();
    public int solution(int n, int[][] edge){
        int answer = 0;

        visit = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];
        for(int i = 0; i < edge.length; i++){
            visit[edge[i][0]][edge[i][1]] = true;
            visit[edge[i][1]][edge[i][0]] = true;
        }
        queue.offer(1);
        check[1] = true;
        answer = bfs(n);
        return answer;
    }
    static int bfs(int n){
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int now = queue.poll();
                for(int j = 1; j <= n; j++){
                    if(visit[j][now] && !check[j]){
                        check[j] = true;
                        queue.offer(j);
                    }
                }
            }
            count = size;
        }
        return count;
    }
}
