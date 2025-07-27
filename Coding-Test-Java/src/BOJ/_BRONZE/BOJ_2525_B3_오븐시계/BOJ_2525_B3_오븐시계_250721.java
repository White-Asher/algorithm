package BOJ._BRONZE.BOJ_2525_B3_오븐시계;

import java.util.*;
import java.io.*;

public class BOJ_2525_B3_오븐시계_250721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int addm = Integer.parseInt(br.readLine());
        int adds = addm / 60;
        addm = addm % 60;
        m += addm;
        s += adds;
        if(m >= 60) {
            m -= 60;
            s++;
        }

        System.out.println( s % 24 + " " + m );

    }
}
