import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] ans = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        while(rightIndex < n && leftIndex <= rightIndex){
            if(ans[arr[rightIndex]] < k){
                ans[arr[rightIndex]]++;
                rightIndex++;
            }else if(ans[arr[rightIndex]] == k){
                ans[arr[leftIndex]]--;
                leftIndex++;
            }
            count = Math.max(count, rightIndex - leftIndex);
        }
        System.out.println(count);
    }
}