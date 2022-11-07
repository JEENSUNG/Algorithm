import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        //(0)h e l l o(5)
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < str.length; i++) list.add(str[i].charAt(0));
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) iter.next();
        while (n--> 0){
            char[] s = br.readLine().toCharArray();
            switch (s[0]) {
                case 'L':
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default:
                    char t = s[2];
                    iter.add(t);
                    break;
            }
            //a b c d y x
        }
        for(Character c : list)
            bw.write(c);
        bw.flush();
        bw.close();
    }
}
