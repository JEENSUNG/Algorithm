import java.util.*;
class Node{
    int x;
    int cost;
    Node(int x, int cost){
        this.x = x;
        this.cost = cost;
    }
}
class Main{
    static int[]arr;
    static PriorityQueue<Node> queue;
    static boolean[] visit;
    static int answer;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) {
        answer = 50000001;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        arr = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            arr[i] = 50000001;
        }
        for(int i = 0; i < n + 1; i++)
            list.add(new ArrayList<>());
        while(m--> 0){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int cost = scan.nextInt();
            list.get(y).add(new Node(x, cost));
            list.get(x).add(new Node(y, cost));
        }

        queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        queue.offer(new Node(1, 0));
        arr[1] = 0;
        dfs();
        System.out.println(arr[n]);
    }
    static void dfs(){
        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(!visit[now.x]) visit[now.x] = true;
            else
                continue;
            for(int i = 0; i < list.get(now.x).size(); i++){
                Node nx = list.get(now.x).get(i);
                if(arr[now.x] + nx.cost < arr[nx.x]){
                    arr[nx.x] = arr[now.x] + nx.cost;
                    queue.offer(new Node(nx.x, arr[nx.x]));
                }
            }
        }
    }
}