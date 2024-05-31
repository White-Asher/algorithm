package BOJ.Greedy.BOJ_1263_G5_시간관리;

import java.util.*;
import java.io.*;

public class BOJ_1263_G5_시간관리 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1]; // 두 번째 요소(b) 기준 내림차순
                } else {
                    return o2[0] - o1[0]; // 첫 번째 요소(a) 기준 내림차순
                }
            }
        });


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            ans = Math.min(ans, list.get(i)[1]);
            ans -= list.get(i)[0];
            if(ans < 0) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(ans);


    }
}
