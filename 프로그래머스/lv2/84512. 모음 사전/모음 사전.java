import java.util.HashMap;

class Solution {
    static char[] arr;
    static HashMap<String, Integer> hashMap;
    static int cnt = 1;
    public int solution(String word) {
        arr = new char[]{'A', 'E', 'I', 'O', 'U'};
        hashMap = new HashMap<>();
        dfs(0, 5, "");
        return hashMap.get(word);
    }
    static void dfs(int count, int end, String str){
        if(count == end)
            return;
        for(int i = 0; i < 5; i++){
            if(!hashMap.containsKey(str + arr[i]))
                hashMap.put(str + arr[i], cnt);
            cnt++;
            dfs(count + 1, end, str + arr[i]);

        }
    }
}