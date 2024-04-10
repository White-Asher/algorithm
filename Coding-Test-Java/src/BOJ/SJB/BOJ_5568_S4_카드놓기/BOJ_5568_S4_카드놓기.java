package BOJ.SJB.BOJ_5568_S4_카드놓기;

import java.util.*;
import java.io.*;

public class BOJ_5568_S4_카드놓기 {
    static int N, R;
    static int[] nums, input;
    static boolean[] isSelect;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        nums = new int[R];
        isSelect = new boolean[N + 1];
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        permutation(0);

        System.out.println(set.size());

    }

    private static void permutation(int cnt) {
        if(cnt == R) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(nums[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSelect[i]) continue;
            nums[cnt] = input[i];
            isSelect[i] = true;
            permutation(cnt + 1);
            isSelect[i] = false;
        }
    }
}

