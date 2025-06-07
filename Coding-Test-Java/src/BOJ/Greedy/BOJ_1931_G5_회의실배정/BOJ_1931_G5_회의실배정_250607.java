package BOJ.Greedy.BOJ_1931_G5_회의실배정;

import java.io.*;
import java.util.*;

public class BOJ_1931_G5_회의실배정_250607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0]; // 내림차순
                }
            }
        });


        int ans = 0;
        int index = 0;
        int end = Integer.MAX_VALUE;
        while(true) {
            if(index >= N) {
                System.out.println(ans);
                return;
            }

            int[] cur = list.get(index);
            int cs = cur[0];
            int ce = cur[1];
            if(end >= ce) {
                end = cs;
                ans++;
            }
            index++;
        }
    }
}
