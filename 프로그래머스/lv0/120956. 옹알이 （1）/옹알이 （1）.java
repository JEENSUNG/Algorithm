class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int index = 0;
        String[] arr = new String[4];
        arr[0] = "aya";
        arr[1] = "ye";
        arr[2] = "woo";
        arr[3] = "ma";
        while(index < babbling.length){
            String str = babbling[index];
            if(str.length() < 2) {
            	index++;
            	continue;
            }           
            while(true) {
            	boolean is = false;
            	if(str.length() <= 3) {
            		for(int i = 0; i < 4; i++) {
            			if(str.equals(arr[i])) {
            				answer++;
            				break;
            			}
            		}
            		break;
            	}
            	for(int i = 0; i < 4; i++) {
            		if(str.startsWith(arr[i])) {
            			str = str.substring(arr[i].length());
            			is = true;
            			break;
            		}
            	}
            	if(!is)
            		break;
            }
            index++;
        }
        return answer;
    }
}