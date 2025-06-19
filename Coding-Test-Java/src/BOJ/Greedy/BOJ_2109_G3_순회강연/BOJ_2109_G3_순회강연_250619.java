package BOJ.Greedy.BOJ_2109_G3_순회강연;

import java.util.*;
import java.io.*;

public class BOJ_2109_G3_순회강연_250619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        StringTokenizer  st = null;
        int maxday = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Lecture(p, d));
            maxday = Math.max(maxday, d);
        }

        Collections.sort(list, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.day - o2.day;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0;
        for (int d = 1; d <= maxday; d++) {
            while(idx < n && list.get(idx).day == d) {
                pq.add(list.get(idx).price);
                idx++;
            }

            while (pq.size() > d) {
                pq.poll();
            }
        }

        long total = 0;
        while(!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }

    static class Lecture {
        int day;
        int price;

        public Lecture(int _price, int _day){
            day = _day;
            price = _price;
        }

    }
}
