package BOJ.KMP.BOJ_1786_P5_찾기;

import java.util.*;
import java.io.*;

public class BOJ_1786_P5_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();

        KMP(text, pattern);

    }

    private static void KMP(String text, String pattern) {
        int[] table = makeTable(pattern);
        int tLen = text.length();
        int pLen = pattern.length();
        int idx = 0;
        int cnt = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tLen; i++) {
            while (idx > 0 && text.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (text.charAt(i) == pattern.charAt(idx)) {
                if(idx == pLen - 1) {
                    sb.append(i - idx + 1).append("\n");
                    cnt++;
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb);

    }

    private static int[] makeTable(String pattern) {
        int pLen = pattern.length();
        int[] table = new int[pLen];

        int index = 0;
        for (int i = 1; i < pLen; i++) {
            while(index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(index)) {
                table[i] = ++index;
            }
        }
        return table;
    }


}
