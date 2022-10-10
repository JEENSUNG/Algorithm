import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String s = br.readLine();
        if(str.length() < s.length()) {
            bw.write("FRULA");
            bw.flush();
            bw.close();
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if(stack.size() >= s.length()){
                boolean isOk = true;
                for(int j = 0; j < s.length(); j++){
                    if(stack.get(stack.size() - s.length() + j) != s.charAt(j)){
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    for(int j = 0; j < s.length(); j++)
                        stack.pop();
                }
            }
        }
        for(Character c : stack)
            sb.append(c);
        if(sb.length() == 0)
            bw.write("FRULA");
        else
            bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}