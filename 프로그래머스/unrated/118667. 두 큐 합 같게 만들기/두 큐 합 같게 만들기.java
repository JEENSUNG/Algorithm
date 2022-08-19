import java.util.*;
class Solution{
    public int solution(int[] queue1, int[] queue2){
        long sumA = 0;
        long sumB = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++){
            queue.offer(queue1[i]);
            sumA += queue1[i];
        }
        for(int i = 0; i < queue2.length; i++){
            qu.offer(queue2[i]);
            sumB += queue2[i];
        }
        if(sumA + sumB % 2 == 1)
            return -1;
        long sum = (sumA + sumB) / 2;
        int answer = 0;
        while(queue.size() > 0 && qu.size() > 0){
            if(sumA < sum){
                int temp = qu.poll();
                sumA += temp;
                queue.offer(temp);
                answer++;
            }else if(sumA > sum){
                int temp = queue.poll();
                sumA -= temp;
                answer++;
            }else
                return answer;
        }
        return -1;
    }
}