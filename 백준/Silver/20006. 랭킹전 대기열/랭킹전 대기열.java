import java.util.*;
class Rank{
	int x;
	String y;
	Rank(int x, String y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int m = scan.nextInt();
		List<Rank> list = new ArrayList<>();
		for(int i = 0; i < p; i++) {
			int x = scan.nextInt();
			String y = scan.next();
			list.add(new Rank(x, y));
		}
		List<Rank>[] aList = new List[p];
		for(int i = 0; i < p; i++)
			aList[i] = new ArrayList<>();
		boolean[] visit = new boolean[p];
		for(int j = 0; j < list.size(); j++) {
			for(int i = 0; i < aList.length; i++) {
				if(visit[j])
					continue;
				if(aList[i].size() < m && aList[i].size() > 0) {
					int now = aList[i].get(0).x;
					if(now - 10 <= list.get(j).x && now + 10 >= list.get(j).x) { 
						aList[i].add(new Rank(list.get(j).x, list.get(j).y));
						visit[j] = true;
						break;
					}
				}else if(aList[i].size() == 0) {
					aList[i].add(new Rank(list.get(j).x, list.get(j).y));
					visit[j] = true;
				}
			}
		}
		for(int i = 0; i < p; i++) {
			if(aList[i].size() == 0)
				break;
			Collections.sort(aList[i], new Comparator<Rank>() {
				@Override
				public int compare(Rank o1, Rank o2) {
					return o1.y.compareTo(o2.y);
				}
			});
			if(aList[i].size() > 0) {
				if(aList[i].size() < m) {
					System.out.println("Waiting!");
					for(int j = 0; j < aList[i].size(); j++)
						System.out.println(aList[i].get(j).x + " " + aList[i].get(j).y);
				}else {
					System.out.println("Started!");
					for(int j = 0; j < aList[i].size(); j++)
						System.out.println(aList[i].get(j).x + " " + aList[i].get(j).y);
				}
			}
		}
	}
}
