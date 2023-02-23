class Solution {
    public int solution(int n, int[] money) {
        int[] answer = new int[100001];
        answer[0] = 1;
        for(int now : money){
            for(int j = now; j <= n; j++)
                answer[j] += answer[j - now];
        }
        return answer[n];
    }
}