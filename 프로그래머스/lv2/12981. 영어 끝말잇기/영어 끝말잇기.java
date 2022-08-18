import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int i = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(words[0], 1);
        String str = words[0];
        while(i < words.length){
            if(str.charAt(str.length() - 1) != words[i].charAt(0)){
                int temp = i % n + 1;
                int c = i / n + 1;
                answer[0] = temp;
                answer[1] = c;
                break;
            }
            else if(!hashMap.containsKey(words[i])){
                hashMap.put(words[i], 1);
            }else{
                int temp = i % n + 1;
                int c = i / n + 1;
                answer[0] = temp;
                answer[1] = c;
                break;
            }
            str = words[i];
            i++;
        }
        return answer;
    }
}