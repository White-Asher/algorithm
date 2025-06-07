package BOJ.BinarySearch.BOJ_1920_S4_수찾기;

import java.util.*;
import java.io.*;

public class BOJ_1920_S4_수찾기_250603 {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int target) {
        int start = 0;
        int end = A.length -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(target < A[mid]) {
                end = mid - 1;
            } else if (target > A[mid]) {
                start = mid + 1;
            } else if (target == A[mid]) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}
