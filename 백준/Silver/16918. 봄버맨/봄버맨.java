import java.awt.Point;
import java.util.*;
class Boom{
	int time;
	Boom(int time){
		this.time = time;
	}
}
public class Main {
	static int[][] arr;
	static int r, c, n;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static List<Boom>[][] list;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        r = scan.nextInt();
        c = scan.nextInt();
        n = scan.nextInt();
        arr = new int[r][c];
        list = new List[r][c];
        for(int i = 0; i < r; i++)
        	for(int j = 0; j < c; j++)
        		list[i][j] = new ArrayList<>();
        for(int i = 0; i < r; i++) {
        	String str = scan.next();
        	for(int j = 0; j < c; j++) {
        		if(str.charAt(j) == '.') {
        			arr[i][j] = 0;
        			list[i][j].add(new Boom(0));
        		}
        		else {
        			arr[i][j] = 1;
        			list[i][j].add(new Boom(2));
        		}
        	}
        }
        n--;
        while(n--> 0) {
        	ArrayList<Point> ll = new ArrayList<>();
        	for(int i = 0; i < r; i++) {
        		for(int j = 0; j <c ; j++) {
        			if(arr[i][j] == 0) {
        				arr[i][j] = 1;
        				list[i][j].get(0).time = 3;
        			}else {
        				list[i][j].get(0).time--;
        				if(list[i][j].get(0).time == 0)
        					ll.add(new Point(i, j));
        			}
        		}
        	}
        	for(Point now : ll) {
				arr[now.x][now.y] = 0; 
				for(int k = 0; k < 4; k++) {
					int nx = now.x + dir[k][0];
					int ny = now.y + dir[k][1];
					if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
					if(arr[nx][ny] == 1) {
						arr[nx][ny] = 0;
						list[nx][ny].get(0).time = 0;
					}
				}
        	}
        }
        for(int i = 0; i < r; i++) {
        	for(int j = 0; j <c ; j++) {
        		if(arr[i][j] == 0)
        			System.out.print(".");
        		else System.out.print("O");
        	}
        	System.out.println();
        }
    }
}
