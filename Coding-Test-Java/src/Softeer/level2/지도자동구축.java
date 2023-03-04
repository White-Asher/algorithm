package Softeer.level2;

import java.util.*;
import java.io.*;

public class 지도자동구축 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 0;
        int len = 2;
        while(i++ < N) {
            len = len+len-1;
        }
        System.out.println(len*len);
    }
}
