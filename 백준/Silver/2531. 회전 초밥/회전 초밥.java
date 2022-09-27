import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int k = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        for(int i = 0; i < n; i++)
            list.add(arr[i]);
        for(int i = 0; i < k - 1; i++)
            list.add(arr[i]);
        int answer = 0;

        int left = 0;
        int right = k - 1;
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> alist = new ArrayList<>();

        for(int i = left; i <= right; i++) {
            hashSet.add(list.get(i));
            alist.add(list.get(i));
        }
        while(true){
            if(hashSet.contains(c))
                answer = Math.max(answer, hashSet.size());
            else
                answer = Math.max(answer, hashSet.size() + 1);
            left++;
            right++;
            alist.add(list.get(right));
            alist.remove(list.get(left - 1));
            hashSet = new HashSet<>(alist);
            if(right == list.size() - 1)
                break;
        }
        System.out.println(answer);
    }
}