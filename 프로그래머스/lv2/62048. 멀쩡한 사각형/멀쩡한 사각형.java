class Solution {
	public long solution(int w, int h) {
		long answer = 1;
        
		long wl = (long)w; // 가로 길이
		long hl = (long)h; // 세로 길이
		
		answer = (wl*hl)-((wl+hl)-gcd(wl, hl));
		
		return answer;
	}

	//최대 공약수 (유클리드 호제법)
	private static long gcd(long w, long h) {
		if(h == 0) {
			return w;
		}
		return gcd(h, w%h);
	}
}