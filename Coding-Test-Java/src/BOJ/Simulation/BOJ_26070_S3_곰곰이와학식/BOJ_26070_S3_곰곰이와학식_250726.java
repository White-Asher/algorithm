package BOJ.Simulation.BOJ_26070_S3_곰곰이와학식;

import java.util.*;
import java.io.*;

public class BOJ_26070_S3_곰곰이와학식_250726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] gom = new long[3];
        gom[0] = Integer.parseInt(st.nextToken());
        gom[1] = Integer.parseInt(st.nextToken());
        gom[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] ticket = new long[3];
        ticket[0] = Integer.parseInt(st.nextToken());
        ticket[1] = Integer.parseInt(st.nextToken());
        ticket[2] = Integer.parseInt(st.nextToken());

        long ans = 0;
        while(true) {
            boolean change = false;
            for(int i = 0; i < 3; i++){
                long minus = Math.min(gom[i], ticket[i]);
                gom[i] -= minus;
                ticket[i] -= minus;
                ans += minus;
                if(ticket[i] >= 3) {
                    ticket[(i+1)%3] += ticket[i] / 3;
                    ticket[i] %= 3;
                    change = true;
                }
                if(minus > 0) change = true;
            }
            if(!change) break;

        }

        System.out.println(ans);

    }
}
