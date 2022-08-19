import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            return 5 * cities.length;
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            boolean isOk = false;
            String str = cities[i].toLowerCase();
            ArrayList<String> list = new ArrayList<>(queue);
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).equals(str)){
                    answer += 1;
                    list.remove(j);
                    list.add(str);
                    queue = new LinkedList<>(list);
                    isOk = true;
                    break;
                }
            }
            if(isOk)
                continue;
            answer += 5;
            if(queue.size() == cacheSize)
                queue.poll();
            queue.offer(str);
        }
        return answer;
    }
}