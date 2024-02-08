package BOJ.BinarySearch.BOJ_1920_수찾기;

import java.util.*;
import java.io.*;

public class BOJ_1920_S4_수찾기_TRY2 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] m = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = a.length - 1;
            int target = m[i];
            boolean flag = false;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(target < a[mid]) {
                    right = mid - 1;
                }
                else if(target > a[mid]) {
                    left = mid + 1;
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
