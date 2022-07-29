import java.util.ArrayList;
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i <= s.length() / 2; i++){
            String str = "";
            int index = i;
            String temp = s.substring(0, i);
            int count = 1;
            ArrayList<String> ss = new ArrayList<>();
            ss.add(temp);
            ArrayList<Integer> list = new ArrayList<>();
            while(index + i <= s.length()) {
                String temp2 = s.substring(index, index + i);
                if(!temp.equals(temp2)){
                    ss.add(temp2);
                    list.add(count);
                    count = 1;
                    temp = temp2;
                }else{
                    count++;
                }
                index += i;
            }
            list.add(count);
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) == 1)
                    str += ss.get(j);
                else
                    str += list.get(j) + ss.get(j);
            }
            str += s.substring(index);
            answer = Math.min(answer, str.length());
        }
        return answer;
    }
}