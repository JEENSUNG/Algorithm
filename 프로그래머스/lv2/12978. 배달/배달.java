class Solution{
    public int solution(int N, int[][] road, int K){
        int[][] arr = new int[N][N];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i == j){
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = 500001;
            }
        }
        for(int i = 0; i < road.length; i++){
            if(arr[road[i][0] - 1][road[i][1] - 1] < road[i][2])
                continue;
            arr[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            arr[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i == j)
                        continue;
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int count = 0;
        for(int i = 0; i < arr[0].length; i++){
            if(arr[0][i] <= K)
                count++;
        }
        return count;
    }
}