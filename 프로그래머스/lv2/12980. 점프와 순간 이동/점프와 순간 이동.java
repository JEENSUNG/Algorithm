public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(true){
            if(n == 1){
                ans++;
                break;
            }
            if(n % 2 == 1) {
                n = n - 1;
                ans++;
            }
            else{
                n = n / 2;
            }
        }
        return ans;
    }
}