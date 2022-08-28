import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                list.add(Integer.parseInt(temp));
                temp = "";
            }
            else
                temp += s.charAt(i);
        }
        list.add(Integer.parseInt(temp));
        Collections.sort(list);
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}