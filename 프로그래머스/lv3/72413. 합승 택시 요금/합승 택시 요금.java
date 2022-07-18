import java.util.*;
class Solution{
    public int solution(int n, int s, int a, int b, int[][] fares){
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(arr[i], 20000001);
            arr[i][i] = 0;
        }
        for(int i = 0; i < fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            arr[start][end] = arr[end][start] = cost;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        int answer = arr[s][a] + arr[s][b];
        for(int i = 1; i <= n; i++)
            answer = Math.min(answer, arr[s][i] + arr[i][a] + arr[i][b]);
        return answer;
    }
}