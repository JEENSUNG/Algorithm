import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int num;
        Node left;
        Node right;
        Node(int num, int x, int y, Node left, Node right){
            this.x = x;
            this.y = y;
            this.num = num;
            this.left = left;
            this.right = right;
        }
        @Override
        public int compareTo(Node o) {
            if(this.y == o.y)
                return this.x - o.x;
            return o.y - this.y;
        }
    }
    static int[][] answer;
    static int index;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++)
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        Collections.sort(list);

        Node root = list.get(0);
        for(int i = 1; i < list.size(); i++)
            NodeInput(root, list.get(i));
        index = 0;
        preOrder(root);
        index = 0;
        postOrder(root);
        return answer;
    }
    static void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            answer[1][index++] = root.num;
        }
    }
    static void preOrder(Node root){
        if(root != null){
            answer[0][index++] = root.num;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static void NodeInput(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null)
                parent.left = child;
            else
                NodeInput(parent.left, child);
        }else{
            if(parent.right == null)
                parent.right = child;
            else
                NodeInput(parent.right, child);
        }
    }
}