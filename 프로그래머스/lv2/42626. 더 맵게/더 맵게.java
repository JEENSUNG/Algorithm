import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville)
            queue.offer(s);
        while(queue.peek() <= K){
            if(queue.size() == 1)
                return -1;
            int a = queue.poll();
            int b = queue.poll();
            int newValue = a + (b * 2);
            queue.offer(newValue);
            answer++;
        }
        return answer;
    }
}