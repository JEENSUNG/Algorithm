import java.util.*;

public class Main {
	static int n;
	static int[][] answer;
	static int[] arr;
	static int index;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		n = scan.nextInt();
		answer = new int[3][n + 1];	
		for(int i = 1; i <= n; i++)
			answer[0][i] = scan.nextInt();
		for(int i = 1; i <= n; i++)
			answer[1][i] = scan.nextInt();
		arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[answer[0][i]] = i;
		index = 1;
		preOrder(1, n, 1, n);
		for(int i = 1; i <= n; i++)
			System.out.print(answer[2][i] + " ");
	}
	static void preOrder(int start, int end, int nStart, int nEnd) {
		if(start > end || nStart > nEnd) return;
		int root = answer[1][nEnd];
		answer[2][index++] = root;
		int rootIndex = arr[root];
		int left = rootIndex - start;
		preOrder(start, rootIndex - 1, nStart, nStart + left - 1);
		preOrder(rootIndex + 1, end, nStart + left, nEnd - 1);
	}
}
