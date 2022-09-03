//2 3 2  5 4 3  = 22 22 11
//4 2 4  2 4 1      36 28 18
//3 1 4  3 1 1      29 20 14
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                int count = 0;
                for(int x = 0; x < arr1[0].length; x++){
                    count += (arr1[i][x] * arr2[x][j]);
                }
                answer[i][j] = count;
            }
        }
        return answer;
    }
}