import java.util.*;
class Solution {
    public int solution(String my_string) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Character> ch = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) == '+' || my_string.charAt(i) == '-'){
                list.add(Long.parseLong(my_string.substring(index, i - 1)));
                ch.add(my_string.charAt(i));
                index = i + 2;
            }
        }
        list.add(Long.parseLong(my_string.substring(index)));
        answer = list.get(0);
        for(int i = 0; i < ch.size(); i++) {
        	if(ch.get(i) == '+') 
        		answer += list.get(i + 1);
        	else
        		answer -= list.get(i + 1);
        }
        return (int)answer;
    }
}