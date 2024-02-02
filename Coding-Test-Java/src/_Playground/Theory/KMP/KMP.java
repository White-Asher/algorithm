package _Playground.Theory.KMP;

import java.io.*;
import java.util.*;

public class KMP {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();

        KMP(text, pattern);
    }

    public static void KMP(String text, String pattern) {
        int[] table = makeTable(pattern);
        int tLength = pattern.length();
        int pLength = text.length();
        int idx = 0;
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tLength; i++) {
            // idx번 글자와 text의 타겟 글자와 불일치할 경우
            // 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
            while (idx > 0 && text.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            // 글자가 대응될 경우
            if(text.charAt(i) == pattern.charAt(idx)) {
                if(idx == pLength - 1) {
                    sb.append((i - idx + 1)).append(" ");
                    System.out.println("find" + (i - idx + 1) + " ~ " + (i + 1));
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
        int pLength = pattern.length();
        int[] table = new int[pLength];

        int index = 0;
        for (int i = 1; i < pLength; i++) {
            // index > 0 => 문자열 매칭이 시작됨
            // 연속으로 일치하지 않으면 index 값을 돌려주어 다시 매칭 시작
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
