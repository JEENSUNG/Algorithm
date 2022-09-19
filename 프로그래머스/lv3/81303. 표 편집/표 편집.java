import java.util.Stack;

class Solution {
    class Node{
        boolean removed;
        Node prev;
        Node next;
    }
    Node[] arr = new Node[1000000];
    public String solution(int n, int k, String[] cmd) {
        for(int i = 0; i < n; i++)
            arr[i] = new Node();
        for(int i = 1; i < n; i++) {
            arr[i - 1].next = arr[i];
            arr[i].prev = arr[i - 1];
        }
        Node now = arr[k];
        Stack<Node> stack = new Stack<>();
        for (String s : cmd) {
            char temp = s.charAt(0);
            if (temp == 'U') {
                int num = Integer.parseInt(s.substring(2));
                for (int j = 0; j < num; j++)
                    now = now.prev;
            } else if (temp == 'D') {
                int num = Integer.parseInt(s.substring(2));
                for (int j = 0; j < num; j++)
                    now = now.next;
            } else if (temp == 'C') {
                stack.push(now);
                now.removed = true;
                Node up = now.prev;
                Node down = now.next;
                if (up != null)
                    up.next = down;
                if (down != null) {
                    down.prev = up;
                    now = down;
                } else {
                    now = up;
                }
            } else {
                Node node = stack.pop();
                node.removed = false;
                Node up = node.prev;
                Node down = node.next;
                if (up != null)
                    up.next = node;
                if (down != null)
                    down.prev = node;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(arr[i].removed)
                answer.append('X');
            else
                answer.append('O');
        }
        return answer.toString();
    }
}