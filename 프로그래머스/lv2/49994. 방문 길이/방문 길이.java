import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> hashSet = new HashSet<>();
        String str = "";
        int x = 0;
        int y = 0;
        for(int i = 0; i < dirs.length(); i++){
            char temp = dirs.charAt(i);
            str = "";
            int nx = x;
            int ny = y;
            if(temp == 'U'){
                if(y + 1> 5)
                    continue;
                y++;
                str += x;
                str += y;
                str += nx;
                str += ny;
                if(!hashSet.contains(str)){
                    hashSet.add(str);
                    answer++;
                }
                else
                    continue;
                str = "";
                str += nx;
                str += ny;
                str += x;
                str += y;
                hashSet.add(str);
            }else if(temp == 'D'){
                if(y - 1 < -5)
                    continue;
                y--;
                str += x;
                str += y;
                str += nx;
                str += ny;
                if(!hashSet.contains(str)){
                    hashSet.add(str);
                    answer++;
                }
                else
                    continue;
                str = "";
                str += nx;
                str += ny;
                str += x;
                str += y;
                hashSet.add(str);
            }else if(temp == 'L'){
                if(x - 1 < -5)
                    continue;
                x--;
                str += x;
                str += y;
                str += nx;
                str += ny;
                if(!hashSet.contains(str)){
                    hashSet.add(str);
                    answer++;
                }
                else
                    continue;
                str = "";
                str += nx;
                str += ny;
                str += x;
                str += y;
                hashSet.add(str);
            }else{
                if(x + 1 > 5)
                    continue;
                x++;
                str += x;
                str += y;
                str += nx;
                str += ny;
                if(!hashSet.contains(str)){
                    hashSet.add(str);
                    answer++;
                }
                else
                    continue;
                str = "";
                str += nx;
                str += ny;
                str += x;
                str += y;
                hashSet.add(str);
            }
            System.out.println(str);
        }
        return answer;
    }
}