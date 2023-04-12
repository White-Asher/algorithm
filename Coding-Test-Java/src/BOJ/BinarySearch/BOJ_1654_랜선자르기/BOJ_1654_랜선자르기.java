package BOJ.BinarySearch.BOJ_1654_랜선자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고한 곳 : https://sete3683.tistory.com/50

public class BOJ_1654_랜선자르기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long maxNum = 0;
        long[] arr = new long[K];

        for (int i = 0; i < K; i++) {
            long inputNum = Long.parseLong(br.readLine());
            arr[i] = inputNum;
            maxNum = Math.max(maxNum, inputNum);
        }

        long left = 1;
        long right = ++maxNum;

        while(left < right) {
            long mid = (left + right) / (long) 2;

            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i]/mid;
            }

            if (cnt >= N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}
