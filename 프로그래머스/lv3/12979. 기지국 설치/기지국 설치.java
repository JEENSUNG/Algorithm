class Solution {
    static int answer;
    public int solution(int n, int[] stations, int w) {
        answer = 0;
        int start;
        int end = 1;
        int index = 1;
        for(int i = 0; i < stations.length; i++){
            if(index > n)
                break;
            start = stations[i] - w - 1;
            end = stations[i] + w;
            if(end > n)
                end = n;
            if(start >= index)
                calc(index, start, w);
            index = end + 1;
        }
        if(end < n)
            calc(index, n, w);
        return answer;
    }
    static void calc(int a, int b, int w){
        int t = (b - a + 1) / (w * 2 + 1);
        double m = (b - a + 1) % (w * 2 + 1);
        if(m > 0)
            answer += t + 1;
        else
            answer += t;
    }
}