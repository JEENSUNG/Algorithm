import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(String s){
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '}')
                size++;
        }
        ArrayList<Integer>[] list = new ArrayList[size - 1];
        for (int i = 0; i < size - 1; i++)
            list[i] = new ArrayList<>();
        int[] arr = new int[size - 1];
        String str = "";
        int index = 0;
        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                str += s.charAt(i);
            }
            else if(s.charAt(i) == ',')
                str += " ";
            else if(s.charAt(i) == '}'){
                String[] temp = str.split(" ");
                int[] ans = new int[temp.length];
                for(int j = 0; j < ans.length; j++)
                    ans[j] = Integer.parseInt(temp[j]);
                str = "";
                for (int an : ans) {
                    list[index].add(an);
                }
                index++;
                i+=2;
            }
        }
        Arrays.sort(list, Comparator.comparingInt(ArrayList::size));
        boolean[] visit = new boolean[100001];
        for(int i = 0; i < list.length; i++){
            for(int j = 0; j < list[i].size(); j++){
                if(!visit[list[i].get(j)]) {
                    visit[list[i].get(j)] = true;
                    arr[i] = list[i].get(j);
                    break;
                }
            }
        }
        return arr;
    }
}