package BOJ.Hash.BOJ_2002_S1_추월;

import java.util.*;
import java.io.*;

public class BOJ_2002_S1_추월 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> in = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            in.add(br.readLine());
        }
        int ans = 0;
        Queue<String> out = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            out.add(br.readLine());
        }

        while(!out.isEmpty()) {
            String outCar = out.poll();
            if(!in.peek().equals(outCar)) {
                ans++;
                in.remove(outCar);
            } else {
                in.poll();
            }
        }
        System.out.println(ans);
    }
}
