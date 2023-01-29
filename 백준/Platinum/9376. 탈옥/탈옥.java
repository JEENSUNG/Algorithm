import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
 
public class Main {
    static int T;
    static int N, M;
    static char[][] map;
    static int[][] digit;
    static int[][] sumDigit;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            map = new char[N + 2][M + 2];
            sumDigit = new int[N + 2][M + 2];
 
            for (int i = 0; i < N + 2; i++) {
                Arrays.fill(map[i], '.');
            }
 
            for (int i = 1; i <= N; i++) {
                char c[] = br.readLine().toCharArray();
                for (int j = 1; j <= M; j++) {
                    map[i][j] = c[j - 1];
                }
            }
 
            BFS(0, 0);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j < M; j++) {
                    if (map[i][j] == '$')
                        BFS(i, j);
                }
            }
 
            int Answer = sumDigit[0][0];
 
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(map[i][j]=='#') {
                        Answer = Math.min(Answer, sumDigit[i][j]-2);
                    }
                        
                    
                }
            }
            System.out.println(Answer);
 
        }
    }
 
    static class Pair {
        int y;
        int x;
        int w;
 
        public Pair(int y, int x, int w) {
            super();
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }
 
    static int dy[] = { 1, -1, 0, 0 };
    static int dx[] = { 0, 0, 1, -1 };
 
    static void BFS(int y, int x) {
        digit = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(digit[i], Integer.MAX_VALUE);
        }
 
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x, 0));
        digit[y][x] = 0;
 
        while (!q.isEmpty()) {
 
            Pair tmp = q.poll();
 
            for (int d = 0; d < 4; d++) {
                int ny = tmp.y + dy[d];
                int nx = tmp.x + dx[d];
 
                if (ny < 0 || nx < 0 || ny >= N + 2 || nx >= M + 2)
                    continue;
                if (map[ny][nx] == '*')
                    continue;
                int next = (map[ny][nx] == '#') ? 1 : 0;
                next += tmp.w;
 
                if (digit[ny][nx] > next) {
                    digit[ny][nx] = next;
                    q.add(new Pair(ny, nx, next));
                }
            }
        }
 
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                if(map[i][j]=='*')continue;
                sumDigit[i][j] += digit[i][j];
            }
        }
 
    }
}