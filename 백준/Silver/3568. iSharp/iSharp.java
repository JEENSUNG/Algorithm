import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		String [] data = in.split(" ");
		for(int i=1;i<data.length;i++)
			getParam(data[0], data[i]);
		System.out.println(sb.toString());
	}
	public static void getParam(String type, String str) {
		String out="";
		StringBuilder sym=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char cur = str.charAt(i);
			if(cur=='*' || cur=='&')
				sym.append(cur);
			else if(cur=='[')
				sym.append(']');
			else if(cur==']')
				sym.append('[');
			else if(('A'<=cur && cur<='Z') ||('a'<=cur && cur<='z') )
				out+=str.charAt(i);
		}
		sb.append(type+sym.reverse()+" ").append(out+";\n");
	}
}