import java.util.*;
class Main{
	static int[] parents;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int g = scan.nextInt();
		int p = scan.nextInt();
		parents = new int[g + 1];
		//부모 노드는 최초에 방문시 i번 비행기가 방문하므로 i삽입
		for(int i = 0; i <= g; i++)
			parents[i] = i;
		int count = 0;
		while(p-- > 0) {
			int x = scan.nextInt();
			//x가 주어질 때 x의 부모를 temp에 저장
			int temp = find(x);
			if(temp != 0) {
				count++;
				union(temp - 1, temp);
				//i번 비행기는 i번 이하의 공항에 잘 착륙되었으므로 이보다 낮은 수를 미리 parents에 삽입
			}else break;
		}
		System.out.println(count);
	}
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parents[pb] = pa;
		//a의 부모, b의 부모를 구하여 분리된집합일 경우 pa 주입
	}
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
		//x번 방문이 최초면 x return하고 아니면 parents[x]의 부모를 구함
	}
}