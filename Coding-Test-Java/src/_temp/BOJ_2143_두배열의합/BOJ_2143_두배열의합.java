package _temp.BOJ_2143_두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2143_두배열의합 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] narr = new int[n];
        long[] snarr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        int n0 = Integer.parseInt(st.nextToken());
        narr[0] = n0;
        snarr[0] = n0;
        for (int i = 1; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            narr[i] = input;
            snarr[i] = snarr[i-1] + (long) input;
        }

        int m = Integer.parseInt(br.readLine());
        int[] marr = new int[m];
        long[] smarr = new long[m+1];
        st = new StringTokenizer(br.readLine());
        int m0 = Integer.parseInt(st.nextToken());
        marr[0] = m0;
        smarr[0] = m0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            marr[i] = input;
            smarr[i] = snarr[i-1] + (long) input;
        }


    }
}
