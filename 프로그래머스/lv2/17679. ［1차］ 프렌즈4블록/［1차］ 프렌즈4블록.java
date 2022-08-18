import java.util.ArrayList;

class Solution{
    static int m, n;
    static char[][] arr;
    static boolean[][] visit;
    static int answer;
    int solution(int m, int n, String[] board) {
        answer = 0;
        arr = new char[m][n];
        visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            String str = board[i];
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        while(true){
            visit = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i + 1 >= m || j + 1 >= n){
                        continue;
                    }
                    if(arr[i][j] >= 'A'&& arr[i][j] <= 'Z' && arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i+1][j+1]){
                        visit[i][j] = true;
                        visit[i + 1][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j + 1] = true;
                        check(i + 1, j);
                        check(i, j + 1);
                        check(i + 1, j + 1);
                    }
                }
            }
            ArrayList<Character>[] list = new ArrayList[n];
            for(int i = 0; i < n; i++)
                list[i] = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    if(!visit[j][i]){
                        list[i].add(arr[j][i]);
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(visit[i][j])
                        count++;
                }
            }
            //C C B D E
            //A A A D E
            //A A A B F
            //C C B B F
            if(count == 0)
                break;
            arr = new char[m][n];
            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    if(list[i].size() > 0) {
                        arr[j][i] = list[i].get(0);
                        list[i].remove(0);
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] >= 'A' && arr[i][j] <= 'Z')
                    answer++;
            }
        }
        return n * m - answer;
    }
    static void check(int x, int y){
        if(x + 1 < m && y + 1 < n){
            if(arr[x][y] == arr[x + 1][y] && arr[x][y] == arr[x][y + 1] &&
            arr[x][y] == arr[x + 1][y + 1]){
                visit[x][y] = true;
                visit[x + 1][y] = true;
                visit[x][y + 1] = true;
                visit[x + 1][y + 1] = true;
            }
        }
    }
}