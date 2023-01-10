import java.util.*;

public class Main {
	static class Node{
		char root;
		char x;
		char y;
		Node left;
		Node right;
		Node(char root, char x, char y, Node left, Node right){
			this.root = root;
			this.x = x;
			this.y = y;
			this.left = left;
			this.right = right;
		}
		
	}
	static int n;
	static char[][] answer;
	static int index = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Node> list = new ArrayList<>();
		n = scan.nextInt();
		answer = new char[3][n];
		for(int i = 0; i < n; i++) {
			char[] arr = new char[3];
			for(int j = 0; j < 3; j++) {
				char t = scan.next().charAt(0);
				arr[j] = t;
			}
			list.add(new Node(arr[0], arr[1], arr[2], null,null));
		}
		Node root = list.get(0);
		for(int i = 0; i < list.size(); i++)
			NodeInput(root, list.get(i));
		index = 0;
		preOrder(root);
		index = 0;
		inOrder(root);
		index = 0;
		postOrder(root);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}
	static void preOrder(Node root) {
		if(root != null) {
			answer[0][index++] = root.root;
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			answer[1][index++] = root.root;
			inOrder(root.right);
		}
	}
	static void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			answer[2][index++] = root.root;
		}
	}
	static void NodeInput(Node parent, Node child) {
		if(parent.root == child.root) {
			parent.left = (child.x == '.' ? null : new Node(child.x,'.', '.', null,null));
			parent.right = (child.y == '.' ? null : new Node(child.y, '.', '.', null, null));
		}else {
			if(parent.left != null)
				NodeInput(parent.left, child);
			if(parent.right != null)
				NodeInput(parent.right, child);
		}
	}
}
