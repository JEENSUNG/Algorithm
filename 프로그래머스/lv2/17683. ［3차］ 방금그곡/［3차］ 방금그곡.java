import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static class File implements Comparable<File>{
        int num;
        String name;
        int time;
        File(int num, String name, int time){
            this.num = num;
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(File o) {
            int a = o.time;
            int b = this.time;
            if (this.time == o.time)
                return this.num - o.num;
            return a - b;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int size = 0;
        ArrayList<File> list = new ArrayList<File>();
        for(int i = 0; i < musicinfos.length; i++){
            String[] temp = musicinfos[i].split(",");
            String start = temp[0];
            String end = temp[1];
            int time = (Integer.parseInt(end.substring(0,2)) - Integer.parseInt(start.substring(0, 2))) * 60;
            time += Integer.parseInt(end.substring(3)) - Integer.parseInt(start.substring(3));
            String name = temp[2];
            String now = temp[3];
            now = replace(now);
            m = replace(m);
            String s = "";
            System.out.println(time);
            for(int j = 0; j < time; j++)
                s += now.charAt(j % now.length());
            if(s.contains(m)){
                list.add(new File(list.size(), name, time));
            }
        }
        Collections.sort(list);
        if(list.size() == 0)
            return "(None)";
        File o = list.get(0);
        return o.name;
    }
    static String replace(String str){
        str = str.replaceAll("C#", "H");
        str = str.replaceAll("D#", "I");
        str = str.replaceAll("F#", "J");
        str = str.replaceAll("G#", "k");
        str = str.replaceAll("A#", "L");
        return str;
    }
}