import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int max = Integer.MAX_VALUE;
        int nx = 0;
        int ny = 0;
        for(int i = 0; i < n; i++){
            int leftIndex = i + 1;
            int rightIndex = n - 1;
            while(leftIndex <= rightIndex){
                int mid = (leftIndex + rightIndex) / 2;
                int sum = arr[i] + arr[mid];
                if(max > Math.abs(sum)){
                   nx = arr[i];
                   ny = arr[mid];
                   max = Math.abs(sum);
                }
                if(sum < 0)
                    leftIndex = mid + 1;
                else
                    rightIndex = mid - 1;
            }
        }
        System.out.println(nx + " " + ny);
    }
}