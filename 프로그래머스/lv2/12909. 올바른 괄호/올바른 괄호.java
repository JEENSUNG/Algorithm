import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }else
                stack.push('(');
        }
        return stack.size() == 0;
    }
}
