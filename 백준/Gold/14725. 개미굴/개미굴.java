import java.util.*;
public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		TreeMap<Character, TreeMap> hash = new TreeMap<>();
		for(int i = 0; i < n; i++) {
			int k = scan.nextInt();	
			TreeMap now = hash;
			for(int j = 0; j < k; j++) {
				String str = scan.next();
				if(now.get(str) == null)
					now.put(str, new TreeMap<>());
				now = (TreeMap)now.get(str);
			}
		}
		print(hash, 0);
	}
	static void print(TreeMap hash, int t) {
		for(Object next : hash.keySet()) {
			for(int i = 0; i < t; i++)
				System.out.print("--");
			System.out.println(next);
			print((TreeMap)hash.get(next), t + 1);
		}
	}
}
