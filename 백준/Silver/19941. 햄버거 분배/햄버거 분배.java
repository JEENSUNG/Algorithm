import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String str = scan.next();
        char[] arr = new char[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr[i] = str.charAt(i);
            if(str.charAt(i) == 'P')
                list.add(i);
        }
        if(list.size() == 0 || list.size() == n){
            System.out.println(0);
            System.exit(0);
        }
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i = 0; i < list.size(); i++){
            int now = list.get(i);
            for(int j = Math.max(0, now - k); j <= Math.min(n - 1, now + k); j++){
                if(arr[j] == 'H' && !visit[j]){
                    answer++;
                    visit[j] = true;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
