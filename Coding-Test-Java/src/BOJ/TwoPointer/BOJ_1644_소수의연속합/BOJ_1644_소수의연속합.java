package BOJ.TwoPointer.BOJ_1644_소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1644_소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N+2];
        arr[0] = arr[1] = true;

        // 소수 구하기 false 가 소수
        for(int i = 2; i <= N; i++) {
            // 소수라면
            if(!arr[i]) {
                for (int j = 2; i*j <= N; j++) {
                    arr[i*j] = true;
                }
            }
        }
        int cnt = 0;
        int[] prime = new int[N];
        for (int i = 0; i <= N; i++) {
            if(!arr[i]) {
                prime[cnt++] = i;
            }
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int result = 0;

        while(start <= cnt && end <= cnt){

            if(sum == N) {
                result++;
            }

            if(sum < N) {
                sum += prime[end++];
            } else {
                sum -= prime[start++];
            }
        }
        System.out.println(result);
    }
}
