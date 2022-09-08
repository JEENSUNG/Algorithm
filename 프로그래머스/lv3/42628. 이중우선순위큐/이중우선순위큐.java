import java.lang.reflect.Array;
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (String temp : operations){
            if(temp.charAt(0) == 'I'){
                max.offer(Integer.parseInt(temp.substring(2)));
                min.offer(Integer.parseInt(temp.substring(2)));
            }
            else{
                if(!max.isEmpty() && !min.isEmpty()){
                    ArrayList<Integer> list = new ArrayList<>();
                    if(temp.charAt(2) == '-'){
                        int k = min.poll();
                        while (!max.isEmpty()){
                            int now = max.poll();
                            if(k == now)
                                break;
                            list.add(now);
                        }
                        max.addAll(list);
                    }else{
                        int k = max.poll();
                        while (!min.isEmpty()){
                            int now = min.poll();
                            if(k == now)
                                break;
                            list.add(now);
                        }
                        min.addAll(list);
                    }
                }
            }
        }
        if(max.size() == 0)
            return new int[]{0, 0};
        return new int[]{max.poll(), min.poll()};
    }
}