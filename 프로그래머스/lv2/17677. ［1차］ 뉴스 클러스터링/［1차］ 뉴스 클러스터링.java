import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String str1, String str2) {
        String match = "^[a-zA-Z]*$";
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        for(int i = 0; i < str1.length() - 1; i++){
            String temp = str1.substring(i, i + 2);
            if(temp.matches(match)) {
                arr1.add(temp);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++){
            String temp = str2.substring(i, i + 2);
            if(temp.matches(match))
                arr2.add(temp);
        }
        String[] a = new String[arr1.size()];
        String[] b = new String[arr2.size()];
        for(int i = 0; i < arr1.size(); i++) {
            String temp = arr1.get(i).toLowerCase();
            a[i] = temp;
        }
        for(int i = 0; i < arr2.size(); i++) {
            String temp = arr2.get(i).toLowerCase();
            b[i] = temp;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int x = 0;
        boolean[] visit = new boolean[Math.min(a.length, b.length)];
        if(a.length < b.length) {
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (!visit[j] && a[j].equals(b[i])) {
                        visit[j] = true;
                        x++;
                        break;
                    }
                }
            }
        }else{
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (!visit[j] && a[i].equals(b[j])) {
                        visit[j] = true;
                        x++;
                        break;
                    }
                }
            }
        }
      int y = a.length + b.length - x;
        if(x==0 && y == 0)
            return 65536;
        if(x > y) {
            double temp = (double)y / (double)x;
            return (int) (65536 * temp);
        }
        double temp = (double) x / (double) y;
        return (int)(65536 * temp);
    }
}