class Solution {
    public int solution(int[] a) {
        int[] count = new int[a.length];
        for(int i : a)
        	count[i]++;
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
        	if(count[i] == 0) continue;
        	if(count[i] < answer) continue;
        	int size = 0;
        	for(int j = 0; j < a.length-  1; j++) {
        		if(a[j] != i && a[j + 1] != i) continue;
        		if(a[j] == a[j + 1]) continue;
        		size++;
        		j++;
        	}
        	answer = Math.max(size,  answer);
        }
        return answer * 2;
    }
}