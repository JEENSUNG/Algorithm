import java.util.*;

class Solution {
    public int solution(int n){
        int answer = 0;
        int i = 3;
        int a = 1;
        int b = 2;
        while(i < n){
            answer = (a + b) % 1000000007;
            a = b;
            b = answer;
            i++;
        }
        answer = (a + b) % 1000000007;
        return answer;
    }
}