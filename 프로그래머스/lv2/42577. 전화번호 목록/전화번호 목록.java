import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> hash = new HashMap<>();
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        for(int i = 0; i < phone_book.length; i++){
            if(!hash.containsKey(phone_book[i])){
                hash.put(phone_book[i], i);
            }
        }
        for(String now : hash.keySet()) {
        	for(int i = 0; i < now.length(); i++) {
        		if(hash.containsKey(now.substring(0, i)))
        			return false;
        	}
        }
        return true;
    }
}