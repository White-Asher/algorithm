package BOJ.DP.BOJ_14501_S3_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Job> list = new ArrayList<>();

        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new Job(t, p));
        }

        for (int i = list.size()-1; i >= 0 ; i--) {
            int curTime = list.get(i).time;
            int curPrice = list.get(i).price;

            if(curTime + i > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], curPrice + dp[curTime + i]);
            }

//        System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[0]);
    }
}

class Job {
    int time;
    int price;

    public Job(int time, int price) {
        this.time = time;
        this.price = price;
    }
}
