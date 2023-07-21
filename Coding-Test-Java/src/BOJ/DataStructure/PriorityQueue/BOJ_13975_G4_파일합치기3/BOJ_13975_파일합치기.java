package BOJ.DataStructure.PriorityQueue.BOJ_13975_G4_파일합치기3;

import java.util.*;
import java.io.*;

public class BOJ_13975_파일합치기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Queue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long ans = 0;
            while(pq.size() > 1) {
                long p1 = pq.poll();
                long p2 = pq.poll();
                long sum = p1 + p2;
                ans+= sum;
                pq.add(sum);
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
