import java.util.Arrays;

class Solution {
    static int[] arr;
    static int[] temp;
    static int answer;
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        arr = weak;
        //1 3 4 5 13 15 16 17
        temp = new int[weak.length * 2];
        System.arraycopy(weak, 0, temp, 0, weak.length);
        for(int i = weak.length; i < temp.length; i++)
            temp[i] = weak[i - weak.length] + n;
        for(int i = 0; i < weak.length; i++) {
            makeArr(i);
            makeDist(new int[dist.length],0, dist.length, dist, new boolean[dist.length]);
        }
        if(answer >= dist.length + 1)
            return -1;
        return answer;
    }
    static void makeArr(int count){
        System.arraycopy(temp, count, arr, 0, arr.length);
    }
    static void makeDist(int[] ans, int count, int end, int[] dist, boolean[] visit){
        if(count == end){
            int max = 0;
            int t = 0;
            int next;
            while(max < dist.length && t < arr.length){
                next = t + 1;
                while(next < arr.length && arr[t] + ans[max] >= arr[next]){
                    next++;
                }
                t = next;
                max++;
            }
            if(t == arr.length)
                answer = Math.min(max, answer);
        }
        for(int i = 0; i < dist.length; i++){
            if(!visit[i]){
                visit[i] = true;
                ans[count] = dist[i];
                makeDist(ans,count + 1, end, dist, visit);
                ans[count] = 0;
                visit[i] = false;
            }
        }
    }
}