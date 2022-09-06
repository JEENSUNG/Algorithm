class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxA = 0;
        int maxB = 0;
        for (int[] problem : problems) {
            maxA = Math.max(problem[0], maxA);
            maxB = Math.max(problem[1], maxB);
        }
        if(maxA <= alp && maxB <= cop)
            return 0;
        if(alp >= maxA)
            alp = maxA;
        if(cop >= maxB)
            cop = maxB;

        int[][] dp = new int[maxA + 2][maxB + 2];

        for(int i = alp; i <= maxA; i++)
            for(int j = cop; j <= maxB; j++)
                dp[i][j] = Integer.MAX_VALUE;
        dp[alp][cop] = 0;

        for(int i = alp; i <= maxA; i++){
            for(int j = cop; j <= maxB; j++){
                dp[i + 1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                for(int[] p : problems){
                    if(i >= p[0] && j >= p[1]){
                        if(i + p[2] > maxA && j + p[3] > maxB)
                            dp[maxA][maxB] = Math.min(dp[maxA][maxB], dp[i][j] + p[4]);
                        else if(i + p[2] > maxA)
                            dp[maxA][j + p[3]] = Math.min(dp[maxA][j + p[3]],dp[i][j] + p[4]);
                        else if(j + p[3] > maxB)
                            dp[i + p[2]][maxB] = Math.min(dp[i+p[2]][maxB], dp[i][j]+p[4]);
                        else if(i + p[2] <= maxA && j + p[3] <= maxB)
                            dp[i + p[2]][j + p[3]] = Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                    }
                }
            }
        }
        return dp[maxA][maxB];
    }
}