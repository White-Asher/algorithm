package BOJ.DP.BOJ_2565_G5_전깃줄;

import java.io.*;
import java.util.*;

public class BOJ_2565_G5_전깃줄_250716_001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if(o1.a == o2.a) {
                    return o1.a - o2.b;
                }
                return o1.a - o2.a;
            }
        });

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(list.get(j).b < list.get(i).b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(N - ans);
    }

    static class Line{
        int a;
        int b;

        public Line(int _a, int _b){
            a = _a;
            b = _b;
        }

    }
}


