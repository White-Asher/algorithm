package BOJ.String.BOJ_1522_S1_문자열교환;

import java.util.*;
import java.io.*;

public class BOJ_1522_S1_문자열교환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int min = Integer.MAX_VALUE;
        // a개수 세기
        int aCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'a') {
                aCnt++;
            }
        }

        // 부분 문자열에서 a의 개수 중 최대값
        for (int i = 0; i < input.length(); i++) {
            int bCnt = 0; // 부분 문자열에서 a의 개수 카운트
            for (int j = i; j < aCnt + i; j++) {
                if(input.charAt(j % input.length()) == 'b') {
                    bCnt++;
                }
            }
            min = Math.min(min, bCnt);
        }

        System.out.println(min);

    }
}
