package BOJ.String.BOJ_10431_S5_줄세우기;

import java.io.*;

public class BOJ_10431_S5_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");

            int ans = 0;
            for (int j = 1; j <= 20; j++) {
                for (int k = 1; k < j; k++) {
                    if (Integer.parseInt(arr[k]) > Integer.parseInt(arr[j])) {
                        ans++;
                    }
                }
            }
            sb.append(arr[0]).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
