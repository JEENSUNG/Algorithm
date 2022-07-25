class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        if(answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }
    static void dfs(int N, int number, int count, int sum){
        if(count > 8)
            return;
        if(number == sum){
            answer = Math.min(answer, count);
            return;
        }
        int temp = 0;
        for(int i = 0; i < 8; i++){
            if(i + count < 8) {
                temp = temp * 10 + N;
                dfs(N, number, count + i + 1, sum + temp);
                dfs(N, number, count + i + 1, sum - temp);
                dfs(N, number, count + i + 1, sum / temp);
                dfs(N, number, count + i + 1, sum * temp);
            }
        }
    }
}