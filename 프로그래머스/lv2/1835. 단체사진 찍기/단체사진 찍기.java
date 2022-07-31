import java.util.HashMap;

class Solution {
    static int answer;
    static boolean[] visit;
    static char[] arr;
    static String[] ans;
    static HashMap<Character, Integer> hashMap;
    public int solution(int n, String[] data) {
        hashMap = new HashMap<>();
        answer = 0;
        visit = new boolean[8];
        ans = data;
        arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        for(int i = 0; i < 8; i++){
            hashMap.put(arr[i], i);
        }
        dfs(0, "");
        return answer;
    }
    static void dfs(int count, String str){
        if(count == 8){
            for (String an : ans) {
                int x1 = hashMap.get(str.charAt(hashMap.get(an.charAt(0))));
                int x2 = hashMap.get(str.charAt(hashMap.get(an.charAt(2))));
                char op = an.charAt(3);
                int res = an.charAt(4) - '0' + 1;
                if (op == '=') {
                    if (Math.abs(x1 - x2) != res)
                         return;
                } else if (op == '>') {
                    if (Math.abs(x1 - x2) <= res)
                        return;
                } else {
                    if (Math.abs(x1 - x2) >= res)
                        return;
                }
            }
            answer++;
            return;
        }
        for(int i = 0; i < 8; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(count + 1, str + arr[i]);
                visit[i] = false;
            }
        }
    }
}