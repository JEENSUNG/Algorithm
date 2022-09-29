import java.util.*;
class Main{
    static String answer;
    static String exam;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scan.next();
            int k = scan.nextInt();
            if (k == 1){
                System.out.println("1 1");
                continue;
            }
            int[] arr = new int[26];
            for(int j = 0; j < str.length(); j++)
                arr[str.charAt(j) - 'a']++;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < str.length(); j++){
                if(arr[str.charAt(j) - 'a'] < k)
                    continue;
                int count = 1;
                for(int z = j + 1; z < str.length(); z++){
                    if(str.charAt(j) == str.charAt(z))
                        count++;
                    if(count == k){
                        min = Math.min(min, z - j + 1);
                        max = Math.max(max, z - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1)
                System.out.println("-1");
            else
                System.out.println(min + " " + max);
        }
    }
}