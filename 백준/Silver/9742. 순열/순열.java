import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static String arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(line," ");
			String temp=st.nextToken();
			arr=temp.split("");
			time=0;
			temparr=new String[arr.length];
			visit=new boolean[arr.length];
			N=Integer.parseInt(st.nextToken());
			find(0);
			
			System.out.print(temp+" "+N+" = ");
			if(time<N) {	//순열이 없을 경우
				System.out.println("No permutation");
			}else {	//순열이 있을 경우
				
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[j]);
				}
				System.out.println();
			}
			
		}
	}
	private static String temparr[];
	private static boolean visit[];
	private static int time;
	private static void find(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==arr.length) { //순열이 만들어 졌을 경우
			time++;	//순열의 수를 세어준다.
			if(time==N) {	//해당 위치랑 같다면 결과 배열에 저장을 해준다.
				for (int i = 0; i < arr.length; i++) {
					arr[i]=temparr[i];
				}
				
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {	// 순열을 만들어 주는 작업이다.
			if(visit[i])continue;	//visit 배열이 true면 무시한다.
			temparr[cnt]=arr[i];	//임시배열에 순열을 저장해 준다.
			visit[i]=true;
			find(cnt+1);
			visit[i]=false;
		}
	}
}