import java.util.*;
class Virus{
	int x;
	int y;
	int id;
	Virus(int x, int y, int id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
}
public class Main {
	static int n, k;
	static int s, x, y;
	static int[][] arr;
	static List<Virus> list = new ArrayList<>();
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		arr = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				arr[i][j] = scan.nextInt();
				if(arr[i][j] > 0)
					list.add(new Virus(i, j, arr[i][j]));
			}
		s = scan.nextInt();
		x = scan.nextInt();
		y = scan.nextInt();
		Collections.sort(list, new Comparator<Virus>() {
			@Override
			public int compare(Virus o1, Virus o2) {
				return o1.id - o2.id;
			}
		});
		Queue<Virus> queue = new LinkedList<>();
		for(Virus now : list)
			queue.offer(now);
		while(s-- > 0) {
			Queue<Virus> temp = new LinkedList<>();
			while(!queue.isEmpty()) {
				Virus now = queue.poll();
				for(int j = 0; j < 4; j++) {
					int nx = now.x + dir[j][0];
					int ny = now.y + dir[j][1];
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if(arr[nx][ny] > 0) continue;
					arr[nx][ny] = now.id;
					temp.add(new Virus(nx, ny, arr[nx][ny]));
				}
			}
			queue = new LinkedList<>(temp);
		}
		System.out.println(arr[x - 1][y - 1]);
	}

}
