import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int l1 = Integer.MAX_VALUE;
        int l2 = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            if(a[i] < l1){
                answer++;
                l1 = a[i];
            }
            if(a[a.length - 1 - i] < l2){
                answer++;
                l2 = a[a.length - 1 - i];
            }
            if(l1 == l2)
                break;
        }
        if(l1 == l2)
            return answer - 1;
        else
            return answer;
    }
}