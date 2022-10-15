package SWEA;

import java.util.*;
import java.io.*;

public class swea1859D2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t;  tc++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];

            int answer = 0;
            int max = 0;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<num; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int j = arr.length-1; j >= 0; j--){
                int today = arr[j];
                if(max > today){
                    answer += max - today;
                } else{
                    max = today;
                }
            }

            bw.write(answer);
            bw.flush();
            bw.close();
        }

    }
}
