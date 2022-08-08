import java.util.*;
class Solution{
    static char[] ans = {'+','-','*'};
    static boolean[] visit;
    static ArrayList<Long> list;
    static ArrayList<Character> alist;
    static long sum;
    public long solution(String expression){
        sum = 0;
        visit = new boolean[3];
        list = new ArrayList<>();
        alist = new ArrayList<>();
        String str = "";
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                str += expression.charAt(i);
            else{
                list.add(Long.parseLong(str));
                str = "";
                alist.add(expression.charAt(i));
            }
        }
        list.add(Long.parseLong(str));
        dfs(0, new char[3]);
        return sum;
    }
    static void dfs(int count, char[] p){
        if (count == 3) {
            ArrayList<Long> x = new ArrayList<>(list);
            ArrayList<Character> y = new ArrayList<>(alist);
            for(int i = 0; i < p.length; i++){
                for(int j = 0; j < y.size(); j++){
                    if(p[i] == y.get(j)){
                        Long temp = calc(x.remove(j), x.remove(j), p[i]);
                        x.add(j, temp);
                        y.remove(j);
                        j--;
                    }
                }
            }
            sum = Math.max(sum, Math.abs(x.get(0)));
            return;
        }
        for(int i = 0; i < 3; i++){
            if(!visit[i]){
                visit[i] = true;
                p[count] = ans[i];
                dfs(count + 1, p);
                visit[i] = false;
            }
        }
    }
    static Long calc(Long x1, Long x2, char op){
        long num = 0;
        switch(op){
            case '+' : {
                return x1 + x2;
            }
            case '-' : {
                return x1 - x2;
            }
            case '*' : {
                return x1 * x2;
            }
        }
        return num;
    }
}