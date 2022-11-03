import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int score = scan.nextInt();
        int p = scan.nextInt();
        if(n == 0){
            System.out.println(1);
            System.exit(0);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> num = new HashMap();
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if(hashMap.containsKey(x)) {
                hashMap.put(x, hashMap.get(x));
                num.put(x, num.get(x) + 1);
            }
            else {
                hashMap.put(x, i + 1);
                num.put(x, 1);
            }
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());
        list.sort((o1, o2) -> o2 - o1);
        for(int i = 0; i < list.size(); i++) {
            if (score >= list.get(i))
                break;
            count += num.get(list.get(i));
        }
        if(hashMap.containsKey(score))
            num.put(score, num.get(score) + 1);
        else{
            hashMap.put(score, count + 1);
            num.put(score, 1);
        }
        if(hashMap.get(score) <= p && num.get(score) + count <= p)
            System.out.println(hashMap.get(score));
        else System.out.println(-1);
    }
}
