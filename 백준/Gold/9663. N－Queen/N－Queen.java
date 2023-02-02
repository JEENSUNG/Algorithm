import java.awt.*;
import java.util.*;
public class Main {
    static int n;
    static int arr[];
    static int count = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        nqueen(0);
        System.out.println(count);
    }
    public static void nqueen(int cnt){
        if(cnt == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            arr[cnt] = i;
            if(possibility(cnt)){
                nqueen(cnt+1);
            }
        }
    }
    public static boolean possibility(int t){
        for(int i = 0; i < t; i++){
            if(arr[t] == arr[i]){
                return false;
            }
            else if(Math.abs(t - i) == Math.abs(arr[t] - arr[i])){
                return false;
            }
        }
        return true;
    }
}