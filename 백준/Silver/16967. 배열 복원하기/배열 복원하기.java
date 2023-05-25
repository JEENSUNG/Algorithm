import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int w = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int[][] b = new int[h + x][w +y];
		int[][] a = new int[h][w];
		for(int i = 0; i < h + x; i++)
			for(int j = 0; j < w + y; j++)
				b[i][j] = scan.nextInt();
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++) {
				if(i - x >= 0 && j - y >= 0)
					a[i][j] = b[i][j] - a[i - x][j - y];
				else
					a[i][j] = b[i][j];
			}
	    for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
	}

}
