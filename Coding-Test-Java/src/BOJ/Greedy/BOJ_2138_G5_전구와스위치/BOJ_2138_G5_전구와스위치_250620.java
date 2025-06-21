package BOJ.Greedy.BOJ_2138_G5_전구와스위치;

import java.util.*;
import java.io.*;

public class BOJ_2138_G5_전구와스위치_250620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a1 = br.readLine();
        String a2 = br.readLine();

        int[] i1 = new int[n];
        int[] i2 = new int[n];
        int[] i3 = new int[n];

        for (int i = 0; i < n; i++) {
            i1[i] = a1.charAt(i) - '0';
            i2[i] = a1.charAt(i) - '0';
            i3[i] = a2.charAt(i) - '0';
        }

        boolean chk = true;
        for (int i = 0; i < n; i++) {
            if(i1[i] != i3[i]) chk = false;
        }
        if(chk) {System.out.println(0); return;}

        int cnt1 = 0;
        switching(i1, 0);
        if(i1.length > 1) {
            switching(i1, 1);
        }
        cnt1++;

        for (int i = 1; i < n; i++) {
            if(i1[i-1] != i3[i-1]) {
                switching(i1, i-1);
                switching(i1, i);
                if(i + 1 < n){
                    switching(i1, i+1);
                }
                cnt1++;
            }
        }

        int cnt2 = 0;
        for (int i = 1; i < n; i++) {
            if(i2[i-1] != i3[i-1]) {
                switching(i2, i-1);
                switching(i2, i);
                if(i + 1 < n) {
                    switching(i2, i+1);
                }
                cnt2++;
            }
        }

        boolean chk1 = true;
        boolean chk2 = true;
        for (int i = 0; i < n; i++) {
            if(i1[i] != i3[i]) chk1 = false;
            if(i2[i] != i3[i]) chk2 = false;
        }

        if(chk1 && chk2) {System.out.println(Math.min(cnt1, cnt2)); return;}
        if(chk1) {System.out.println(cnt1); return;}
        if(chk2) {System.out.println(cnt2); return;}
        System.out.println(-1);

    }

    public static void switching(int[] arr, int i) {
        if(arr[i] == 1) arr[i] = 0;
        else arr[i] = 1;
    }

}
