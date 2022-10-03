import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.length() >= m)
                hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(hashMap.get(o1) == hashMap.get(o2)){
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return hashMap.get(o2) - hashMap.get(o1);
            }
        });
        queue.addAll(hashMap.keySet());
        while (!queue.isEmpty()){
            bw.write(queue.poll() +"\n");
        }
        bw.flush();
        bw.close();
    }
}