import java.util.*;
class In{
	int x;
	int y;
	In(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int nx = scores[0][0];
        int ny = scores[0][1];
        List<In> list = new ArrayList<>();
        for(int i = 0; i < scores.length; i++)
        	list.add(new In(scores[i][0], scores[i][1]));
        Collections.sort(list, new Comparator<In>() {
			@Override
			public int compare(In o1, In o2) {
				// TODO Auto-generated method stub
				if(o1.x == o2.x)
					return o1.y - o2.y;
				return o2.x - o1.x;
			}
		});
        int max = 0;
        for(In now : list) {
        	if(now.y < max){
        		if(nx == now.x && ny == now.y)
        			return -1;
            }else {
    			max = Math.max(now.y, max);
    			if(nx + ny < now.x + now.y)
    				answer++;
    		}
        }
        return answer;
    }
}