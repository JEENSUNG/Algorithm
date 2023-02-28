class Solution {
    static int[][] dir = {{1, 0}, {0, -1}, {0, 1} , {-1, 0}};
    static Character[] pos = {'d', 'l', 'r', 'u'};
    static String answer = "impossible";
    static boolean stop = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k){
        if(x == r && y == c)
            return "";
        if(!canArrival(x, y, r, c, k)) return answer;
        dfs(n, m, x, y, r, c, k - 1, "");
        return answer;
    }
    static boolean canArrival(int x, int y, int r, int c, int k){
        int d = Math.abs(x - r) + Math.abs(y - c);
        if(d > k || (k - d) % 2 == 1) return false;
        return true;
    }
    static void dfs(int n, int m, int x, int y, int r, int c, int k, String str){
        if(stop || k < 0) return;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx <= 0 || ny <= 0 || nx > n || ny > m || !canArrival(nx, ny, r, c, k)) continue;
            if(k > 0)
                dfs(n, m, nx, ny, r, c, k - 1, str + pos[i]);
            if(nx == r && ny == c && k == 0){
                answer = str + pos[i];
                stop = true;
                return;
            }
        }
    }
}