package Softeer.level1;

import java.util.*;
import java.io.*;


public class 근무시간{
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String[] strArr1 = st.nextToken().split(":");
            String[] strArr2 = st.nextToken().split(":");
            int t = Integer.parseInt(strArr2[0]) - Integer.parseInt(strArr1[0]);
            int m = Integer.parseInt(strArr2[1]) - Integer.parseInt(strArr1[1]);
            if (m  < 0){
                m = (60 + m);
                t-=1;
                sum += (t*60 + m);
            } else {
                sum += (t*60 + m);
            }
        }
        System.out.println(sum);
    }
}