package BOJ.TwoPointer.BOJ_2473_세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int ls = 0;
        int rs = 0;
        int ri = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while (left < right) {

                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                long sum = Math.abs(arr[left] + arr[right] + arr[i]);
                if(sum < min){
                    min = sum;
                    ls = left;
                    rs = right;
                    ri = i;
                }

                if (arr[left] + arr[right] + arr[i] > 0) {
                    right--;
                } else {
                    left++;
                }

            }

        }
        long[] res = new long[3];
        res[0] = arr[ls];
        res[1] = arr[rs];
        res[2] = arr[ri];
        Arrays.sort(res);

        for (int j = 0; j < 3; j++) {
            System.out.print(res[j] + " ");
        }
    }
}
