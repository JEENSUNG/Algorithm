import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            hashSet.add(str);
        }
        for(int i = 0; i < m; i++){
            String str = br.readLine();
            String[] arr = str.split(",");
            for(int j = 0; j < Math.min(10, arr.length); j++){
                if(hashSet.contains(arr[j]))
                    hashSet.remove(arr[j]);
            }
            System.out.print(hashSet.size() + "\n");
        }
    }
}