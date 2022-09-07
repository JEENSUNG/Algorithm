import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 프로그래머스 셔틀버스 문제
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int answerTime = 0;
        int departTime = 9 * 60;
        List<List<Integer>> buses = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            buses.add(new ArrayList<>());
        }

        PriorityQueue<Integer> crews = new PriorityQueue<>();
        for (String time : timetable) {
            StringConvertTime(time);
            crews.offer(StringConvertTime(time));
        }

        for (int i = 0; i < n; i++) {
            while (!crews.isEmpty()) {
                int crew = crews.poll();
                if (crew <= departTime && buses.get(i).size() < m) {
                    buses.get(i).add(crew);
                    answerTime = crew - 1;
                }else {
                    crews.offer(crew);
                    break;
                }
            }
            departTime += t;
        }

        if (buses.get(n - 1).size() < m) {
            answerTime = departTime - t;
        }
        return TimeConvertString(answerTime);
    }

    static int StringConvertTime(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }

    static String TimeConvertString(int val) {
        String hStr = String.format("%02d", val / 60);
        String mStr = String.format("%02d", val % 60);
        return hStr +":"+mStr;
    }
}