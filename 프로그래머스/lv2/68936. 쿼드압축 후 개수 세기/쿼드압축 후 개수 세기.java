class Solution {
    static int[][] ans;
    static boolean[][] visit;
    static int zero, one;
    public int[] solution(int[][] arr) {
        ans = arr;
        zero = 0;
        one = 0;
        visit = new boolean[arr.length][arr.length];
        int[] answer = new int[2];
        boolean flag = false;
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (ints[j] != arr[0][0]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        if(!flag){
            if(arr[0][0] == 0){
                answer[0] = 1;
            }else
                answer[1] = 1;
            return answer;
        }
        int size = arr.length / 2;
        dfs(0, 0, size);
        dfs(0, size, size);
        dfs(size, 0, size);
        dfs(size, size, size);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(visit[i][j])
                    continue;
                if(arr[i][j] == 0)
                    zero++;
                else
                    one++;
            }
        }
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
    static void dfs(int x, int y, int size){
        boolean flag = false;
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(ans[i][j] != ans[x][y]){
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        if(flag){
            dfs(x, y, size / 2);
            dfs(x, y + size / 2, size / 2);
            dfs(x + size / 2, y, size / 2);
            dfs(x + size / 2, y + size / 2, size / 2);
        }
        else{
            if(ans[x][y] == 0)
                zero++;
            else
                one++;
            for(int i = x; i < x + size; i++)
                for(int j = y; j < y + size; j++)
                    visit[i][j] = true;
        }
    }
}