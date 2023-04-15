package BOJ.Geometry.BOJ_2166_다각형의면적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n+1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        long resLeft = 0;
        long resRight = 0;

        for (int i = 0; i < n; i++) {
            resLeft += arr[i][0] * arr[i+1][1];
            resRight += arr[i+1][0] * arr[i][1];
        }
        System.out.printf("%.1f", Math.abs(resLeft - resRight) / 2.0);

    }
}
