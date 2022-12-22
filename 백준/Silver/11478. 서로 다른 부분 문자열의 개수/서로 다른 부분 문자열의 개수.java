import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			for(int j = i; j < str.length(); j++) {
				String temp = "" + str.substring(i, j + 1);
				set.add(temp);
			}
		}
		System.out.println(set.size());
	}

}
