import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for(int work : works) {
            queue.offer(work);
            answer += work;
        }
        if(answer < n)
            return 0;
        for(int i = 0; i < n; i++){
            int now = queue.poll();
            if(now > 0)
                now--;
            queue.offer(now);
        }
        answer = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();
            answer += (long) now * now;
        }
        return answer;
    }
}