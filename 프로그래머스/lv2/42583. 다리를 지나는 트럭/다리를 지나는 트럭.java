import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int nowSum = 0;
        int index = 0;
        while(index < truck_weights.length){
            if(list.size() > 0 && list.get(0) == bridge_length){
                int temp = queue.poll();
                nowSum -= temp;
                list.remove(0);
            }
            if(queue.isEmpty()){
                queue.offer(truck_weights[index]);
                nowSum += truck_weights[index];
                index++;
                answer++;
                list.add(1);
            }
            else if(queue.size() < bridge_length && nowSum + truck_weights[index] <= weight){
                queue.offer(truck_weights[index]);
                nowSum += truck_weights[index];
                index++;
                answer++;
                for(int i = 0; i < list.size(); i++) {
                    int temp = list.get(i);
                    temp++;
                    list.set(i, temp);
                }
                list.add(1);
            }
            else if(queue.size() == bridge_length || nowSum + truck_weights[index] > weight){
                answer++;
                for(int i = 0; i < list.size(); i++){
                    int temp = list.get(i);
                    temp++;
                    list.set(i, temp);
                }
            }

        }
        answer += bridge_length;
        return answer;
    }
}