package BOJ.TwoPointer.BOJ_2230_수고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230_수고르기 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 1;

        int min = Integer.MAX_VALUE;
        int mi = 0;
        while(left <= right && right < N){
            mi = arr[right] - arr[left];
            if (mi >= M && mi < min) {
                min = mi;
            }
            else if (mi >= min){
                left++;
            } else {
                right++;
            }
        }
        System.out.println(min);
    }
}
