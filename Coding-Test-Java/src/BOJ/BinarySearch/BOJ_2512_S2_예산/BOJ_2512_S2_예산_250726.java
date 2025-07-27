package BOJ.BinarySearch.BOJ_2512_S2_예산;

import java.util.*;
import java.io.*;

public class BOJ_2512_S2_예산_250726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }
        long limit = Long.parseLong(br.readLine());

        Arrays.sort(arr);

        long start = 0;
        long end = arr[N - 1]; // 상한액의 최대값은 요청액 중 가장 큰 값
        long ans = 0;

        while(start <= end) {
            long mid  = (start + end) / 2;
            long curSum = 0;

            // mid를 상한액으로 가정하고 총액 계산
            for (long l : arr) {
                if(l >= mid) {
                    curSum += mid;
                } else {
                    curSum += l;
                }
            }

            if(curSum <= limit) {
                // 예산 내에서 배정 가능 -> 더 큰 상한액을 찾아야함.
                ans = mid; // 유효한 답
                start = mid + 1;
            } else { // 예산초과라 다시 찾아야함.
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
