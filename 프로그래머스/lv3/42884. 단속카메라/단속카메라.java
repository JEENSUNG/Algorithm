import java.util.*;
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<Point> list = new ArrayList<Point>();
        for(int i = 0; i < routes.length; i++)
        	list.add(new Point(routes[i][0], routes[i][1]));
        Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.y - o2.y;
			}
		});
        int min = list.get(0).y;
        for(int i = 0; i < list.size() - 1; i++) {
        	int T1 = list.get(i + 1).x;
        	int T2 = list.get(i + 1).y;
        	if(min < T1) {
        		min = T2;
        		answer++;
        	}
        }
        answer++;
        return answer;
    }
}