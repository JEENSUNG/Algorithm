import java.util.Scanner;

class Solution{
    static boolean[][] Pillar;
    static boolean[][] Bar;
    public int[][] solution(int n , int[][] build_frame){
        Pillar = new boolean[n + 1][n + 1];
        Bar = new boolean[n + 1][n + 1];
        int count = 0;
        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int cmd = build[3];

            if(type == 0){
                if(cmd == 1){
                    if(checkPillar(x, y)){
                        Pillar[x][y] = true;
                        count++;
                    }
                }else{
                    Pillar[x][y] = false;
                    if(!canDelete(x, y)){
                        Pillar[x][y] = true;
                    }else
                        count--;
                }
            } else {
                if(cmd == 1){
                    if(checkBar(x, y)){
                        Bar[x][y] = true;
                        count++;
                    }
                }else{
                    Bar[x][y] = false;
                    if(!canDelete(x,y)){
                        Bar[x][y] = true;
                    }else 
                        count--;
                }
            }
        }
        int[][] answer = new int[count][3];
        count = 0;
        for(int x = 0; x <= n; x++){
            for(int y = 0; y <= n; y++){
                if(Pillar[x][y]){
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 0;
                }
                if(Bar[x][y]){
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 1;
                }
            }
        }
        return answer;
    }
    static boolean checkPillar(int x, int y){
        if(y == 0 || Pillar[x][y - 1])
            return true;
        if(x > 0 && Bar[x - 1][y])
            return true;
        if(Bar[x][y])
            return true;
        return false;
    }
    static boolean checkBar(int x, int y){
        if(Pillar[x][y - 1])
            return true;
        if(x <= 100 && Pillar[x + 1][y - 1])
            return true;
        if(x > 0 && x <= 100 && Bar[x - 1][y] && Bar[x + 1][y])
            return true;
        return false;
    }
    static boolean canDelete(int x, int y){
        for(int i = Math.max(x - 1, 0); i <= x + 1; i++){
            for(int j = y; j <= y + 1; j++){
                if(Pillar[i][j] && !checkPillar(i,j))
                    return false;
                if(Bar[i][j] && !checkBar(i,j))
                    return false;
            }
        }
        return true;
    }
}