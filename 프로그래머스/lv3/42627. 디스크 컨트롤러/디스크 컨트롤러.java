import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int index = 0;
        int end = 0;
        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= end) {
                queue.offer(jobs[index]);
                index++;
            }
            if(queue.isEmpty())
                end = jobs[index][0];
            else{
                int[] temp = queue.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int) Math.floor(answer/count);
    }
}