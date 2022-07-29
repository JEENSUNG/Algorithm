import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public String[] solution(String[] record) {
        int index = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (String s : record) {
            String[] str = s.split(" ");
            if (str[0].equals("Enter")) {
                if (hashMap.containsKey(str[1])) {
                    String isKey = str[1];
                    String isValue = hashMap.get(isKey);
                    hashMap.remove(isKey, isValue);
                    hashMap.put(isKey, str[2]);
                    list.add(str[0] + " " + str[1]);
                } else {
                    hashMap.put(str[1], str[2]);
                    list.add(str[0] + " " + str[1]);
                }
                index++;
            } else if (str[0].equals("Change")) {
                String isKey = str[1];
                String isValue = hashMap.get(isKey);
                hashMap.remove(isKey, isValue);
                hashMap.put(isKey, str[2]);
            } else {
                index++;
                list.add(str[0] + " " + str[1]);
            }
        }
        String[] answer = new String[index];
        for(int i = 0; i < index; i++){
            String t = list.get(i);
            String[] gg = t.split(" ");
            String a = gg[0];
            String b = hashMap.get(gg[1]);
            if(a.equals("Enter")){
                answer[i] = b + "님이 들어왔습니다.";
            }else{
                answer[i] = b + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}