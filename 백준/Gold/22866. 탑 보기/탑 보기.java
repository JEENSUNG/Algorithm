import java.io.*;
import java.util.*;
class Top{
    int index;
    int height;
    Top(int index, int height){
        this.index = index;
        this.height = height;
    }
}
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        if(n == 1){
            System.out.println(0);
            System.exit(0);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Top> leftStack = new Stack<>();
        Queue<Top> queue = new LinkedList<>();
        int now = arr[0];
        for(int i = 1; i < n; i++) {
            if(now < arr[i]) {
                now = arr[i];
                queue.offer(new Top(i + 1, arr[i]));
            }
        }
        for(int i = 0; i < n; i++){
            if(i == 0){
                if(queue.size() == 0)
                    bw.write("0" + "\n");
                else
                    bw.write(queue.size() + " " + queue.peek().index + "\n");
            }else if(i == n - 1){
                while (!leftStack.isEmpty()){
                    Top temp = leftStack.peek();
                    if(temp.height > arr[i])
                        break;
                    leftStack.pop();
                }
                if(arr[i - 1] > arr[i])
                    leftStack.push(new Top(i, arr[i - 1]));
                if(leftStack.size() == 0)
                    bw.write("0" + "\n");
                else
                    bw.write(leftStack.size() + " " + leftStack.peek().index + "\n");
            }
            else{
                if(leftStack.isEmpty()){
                    if(arr[i - 1] > arr[i])
                        leftStack.push(new Top(i, arr[i - 1]));
                }else{
                    if(arr[i - 1] < arr[i]){
                        while (!leftStack.isEmpty()){
                            Top temp = leftStack.peek();
                            if(temp.height > arr[i])
                                break;
                            leftStack.pop();
                        }
                    }
                    else if(arr[i - 1] > arr[i]){
                        while (!leftStack.isEmpty()){
                            Top temp = leftStack.peek();
                            if(temp.height > arr[i - 1])
                                break;
                            leftStack.pop();
                        }
                        leftStack.push(new Top(i, arr[i - 1]));
                    }
                }if(!queue.isEmpty()){
                    if(arr[i] == queue.peek().height)
                        queue.poll();
                    if(!queue.isEmpty()) {
                        if (arr[i] > queue.peek().height) {
                            while (!queue.isEmpty()) {
                                Top temp = queue.peek();
                                if (temp.height > arr[i])
                                    break;
                                queue.poll();
                            }
                        }
                        else{
                            now = arr[i];
                            int max = queue.peek().height;
                            Queue<Top> t = new LinkedList<>();
                            for(int j = i + 1; j < n; j++){
                                if(now < arr[j]){
                                    if(arr[j] == max)
                                        break;
                                    t.offer(new Top(j + 1, arr[j]));
                                    now = arr[j];
                                }
                            }
                            t.addAll(queue);
                            queue = new LinkedList<>(t);
                        }
                    }
                }else{
                    now = arr[i];
                    for(int j = i + 1; j < n; j++){
                        if(now < arr[j]){
                            queue.offer(new Top(j + 1, arr[j]));
                            now = arr[j];
                        }
                    }
                }
                if(leftStack.size() + queue.size() == 0)
                    bw.write("0" + "\n");
                else {
                    Top temp;
                    if(leftStack.isEmpty()) {
                        temp = queue.peek();
                        bw.write(queue.size() + " " + temp.index + "\n");
                    }else if(queue.isEmpty()){
                        temp = leftStack.peek();
                        bw.write(leftStack.size() + " " + temp.index + "\n");
                    }
                    else {
                        int min = leftStack.peek().index;
                        int leftDir = i + 1 - leftStack.peek().index;
                        int rightDir = queue.peek().index - i - 1;
                        if (rightDir < leftDir)
                            min = queue.peek().index;
                        bw.write(leftStack.size() +  queue.size() + " " + min + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}