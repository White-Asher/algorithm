package Softeer.level2;

import java.util.*;
import java.io.*;

public class _8단변속기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String args[]) throws Exception {
        st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken());
        int cur = 0;
        boolean acFlag = true;
        boolean dcFlag = true;
        while(st.hasMoreTokens()) {
            cur = Integer.parseInt(st.nextToken());
            if(last+1 != cur) {
                acFlag = false;
            }
            if(last-1 != cur) {
                dcFlag = false;
            }
            last = cur;
        }
        if(!acFlag && !dcFlag) System.out.println("mixed");
        else if(acFlag) System.out.println("ascending");
        else if(dcFlag) System.out.println("descending");
    }
}
