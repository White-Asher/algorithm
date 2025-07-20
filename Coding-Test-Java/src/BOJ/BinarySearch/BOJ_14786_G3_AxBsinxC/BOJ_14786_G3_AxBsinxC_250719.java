package BOJ.BinarySearch.BOJ_14786_G3_AxBsinxC;

import java.util.*;
import java.io.*;

public class BOJ_14786_G3_AxBsinxC_250719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        double start = (double) (c - b) / a;
        double end = (double) (c + b) / a;
        double mid = 0.0;
        int count = 50000;

        while (end - start > 0 && count-- > 0) {
            mid = (start + end) / 2.0;

            double val = (c - b * Math.sin(mid)) / a;

            if (mid > val) {
                end = mid;
            } else if (mid < val) {
                start = mid + 0.000000001;
            }
        }
        System.out.printf("%.6f%n", mid);
    }
}
