import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			Stack<Character> stack = new Stack<Character>();
			for(int j = 0; j < str.length(); j++) {
				if(stack.isEmpty())
					stack.add(str.charAt(j));
				else if(stack.peek() != str.charAt(j)) 
					stack.add(str.charAt(j));
				else
					stack.pop();
			}
			if(stack.size() == 0)
				count++;
		}
		System.out.println(count);	
	}
}
