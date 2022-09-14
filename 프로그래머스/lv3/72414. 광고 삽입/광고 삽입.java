import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        if(play_time.equals(adv_time))
            return "00:00:00";
        int playTime = Integer.parseInt(play_time.substring(0, 2)) * 60 * 60 +
                Integer.parseInt(play_time.substring(3, 5)) * 60 +
                Integer.parseInt(play_time.substring(6));
        int advTime = Integer.parseInt(adv_time.substring(0, 2)) * 60 * 60 +
                Integer.parseInt(adv_time.substring(3, 5)) * 60 +
                Integer.parseInt(adv_time.substring(6));
        int[] arr = new int[playTime + 1];
        for (String log : logs) {
            int start = Integer.parseInt(log.substring(0, 2)) * 60 * 60 +
                    Integer.parseInt(log.substring(3, 5)) * 60 +
                    Integer.parseInt(log.substring(6, 8));
            int end = Integer.parseInt(log.substring(9, 11)) * 60 * 60 +
                    Integer.parseInt(log.substring(12, 14)) * 60 +
                    Integer.parseInt(log.substring(15));
            for (int j = start; j < end; j++)
                arr[j]++;
        }
        long cost = 0;
        for(int i = 1; i < advTime; i++)
            cost += arr[i];
        long now = cost;
        for(int i = 0, j = advTime; j < playTime; i++, j++){
            now = now - arr[i] + arr[j];
            if(now > cost){
                answer = i + 1;
                cost = now;
            }
        }
        String hour = String.valueOf(answer / 3600);
        answer = answer % 3600;
        String min = String.valueOf(answer / 60);
        answer = answer % 60;
        String str = "" + answer;
        if(hour.length() == 1)
            hour = "0" + hour;
        if(min.length() == 1)
            min = "0" + min;
        if(answer < 10)
            str = "0" + answer;
        return "" + hour + ":" + min + ":" + str;
    }
}