import java.util.*;
class Solution {
    static int[][] arr;
    static int temp;
    static int answer;
    static ArrayList<Integer> list;
    static boolean[] visit;
    static Queue<Integer> queue;
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        arr = new int[n][n];
        visit = new boolean[n];
        for (int[] ints : wires) {
            int x = ints[0] - 1;
            int y = ints[1] - 1;
            arr[x][y] = arr[y][x] = 1;
        }
        for(int[] wire : wires){
            list = new ArrayList<>();
            visit = new boolean[n];
            queue = new LinkedList<>();
            int x = wire[0] - 1;
            int y = wire[1] - 1;
            arr[x][y] = arr[y][x] = 0;
            temp = 2;
            for(int i = 0; i < n; i++){
                if(!visit[i] && arr[0][i] == 1) {
                    visit[0] = true;
                    visit[i] = true;
                    queue.offer(i);
                    dfs(n);
                    queue = new LinkedList<>();
                    queue.offer(0);
                    dfs(n);
                    list.add(temp);
                    list.add(n - temp);
                }
            }
            if(list.size() == 0) {
                answer = Math.min(answer, n - 2);
                arr[x][y] = arr[y][x] = 1;
                continue;
            }
            arr[x][y] = arr[y][x] = 1;
            answer = Math.min(Math.abs(list.get(0) - list.get(1)), answer);
        }
        return answer;
    }
    static void dfs(int n){
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < n; i++){
                if(visit[i])
                    continue;
                if(arr[now][i] == 1){
                    queue.offer(i);
                    visit[i] = true;
                    temp++;
                }
            }
        }
    }
}