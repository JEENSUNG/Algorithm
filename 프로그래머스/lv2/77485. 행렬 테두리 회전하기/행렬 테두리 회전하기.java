import java.util.ArrayList;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr =  new int[rows][columns];
        int c = 1;
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++) {
                arr[i][j] = c;
                c++;
            }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int temp = arr[x1][y1];
            int t = temp;
            for(int j = x1; j < x2; j ++) {
                arr[j][y1] = arr[j + 1][y1];
            }
            arr[x2][y1] = arr[x2][y1 + 1];
            for(int j = y1 + 1; j < y2; j++) {
                arr[x2][j] = arr[x2][j + 1];
            }
            arr[x2][y2] = arr[x2 - 1][y2];
            for(int j = x2 - 1; j > x1; j--) {
                arr[j][y2] = arr[j - 1][y2];
            }
            arr[x1][y2] = arr[x1][y2 - 1];
            for(int j = y2 - 1; j > y1 + 1; j--) {
                arr[x1][j] = arr[x1][j - 1];
            }
            arr[x1][y1 + 1] = temp;
            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){
                    if(j == x1 || j == x2 || k == y1 || k == y2)
                        t = Math.min(t, arr[j][k]);
                }
            }
            list.add(t);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}