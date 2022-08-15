class Solution {
    static boolean[] visit;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visit = new boolean[dungeons.length];
        dfs(0, dungeons.length, dungeons, k, 0);
        return answer;
    }
    static void dfs(int count, int end, int[][] dungeons, int k, int sum){
        if(k < 0)
            return;
        if(count == end){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i]){
                visit[i] = true;
                if(k >= dungeons[i][0])
                    dfs(count + 1, end, dungeons, k - dungeons[i][1], sum + 1);
                dfs(count + 1, end, dungeons, k, sum);
                visit[i] = false;
            }
        }
    }
}