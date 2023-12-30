package BOJ.Greedy.BOJ_2457_G3_공주님의정원;

import java.io.*;
import java.util.*;

public class BOJ_2457_G3_공주님의정원_2 {
    static int n;
    static final int LAST_DAY = 1201;
    static List<Flower> list;
    public static void main(String[] args) throws Exception {
        // start :: input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Flower(br.readLine()));
        }
        list.sort((o1, o2) -> {
            if(o1.start == o2.start) return o2.end - o1.end;
            return o1.start - o2.start;
        });

        int sd = 301;
        int ed = 0;
        int idx = 0;
        int ans = 0;

        while(sd < LAST_DAY) {
            boolean findFlower = false;
            for(int i = idx; i < n; i++) {
                Flower cur = list.get(i);
                if(cur.start > sd) break;
                if(cur.end > ed) {
                    ed = cur.end;
                    idx = i + 1;
                    findFlower = true;
                }
            }

            if(findFlower) {
                ans++;
                sd = ed;
            } else {
                break;
            }

        }
        System.out.println(ed < LAST_DAY ? "0" : ans);
    }

    public static class Flower{
        int start; // 꽃 시작일
        int end; // 꽃 종료일
        public Flower(String a) {
            String[] spl = a.split(" ");
            if(Integer.parseInt(spl[1]) < 10) {
                spl[1] = "0" + spl[1];
            }
            if(Integer.parseInt(spl[3]) < 10) {
                spl[3] = "0" + spl[3];
            }
            this.start = Integer.parseInt(spl[0]+spl[1]);
            this.end = Integer.parseInt(spl[2]+spl[3]);
        }

        // debug
        @Override
        public String toString() {
            return "Flower{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

    }
}
