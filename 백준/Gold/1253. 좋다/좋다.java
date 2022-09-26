import javax.swing.plaf.synth.SynthUI;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        int answer = 0;
        HashSet<Integer> hashSet = new HashSet<>(hashMap.keySet());
        ArrayList<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        int index = 0;
        while(index < n){
            int num = arr[index];
            int startIndex = 0;
            int endIndex = n - 1;
            while(true){
                if(index == startIndex){
                    startIndex++;
                    continue;
                }if(index == endIndex){
                    endIndex--;
                    continue;
                }
                if(startIndex >= endIndex)
                    break;
                int start = arr[startIndex];
                int end = arr[endIndex];
                if(start + end == num){
                    if(hashMap.get(num) > 1)
                        answer += hashMap.get(num);
                    else
                        answer++;
                    break;
                }else if(start + end > num){
                    endIndex--;
                }else if(start + end < num){
                    startIndex++;
                }
            }
            if(hashMap.get(num) > 1)
                index += hashMap.get(num);
            else
                index++;
        }
        System.out.println(answer);
    }
}
