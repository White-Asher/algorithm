/*
제목 : 수 나누기 게임
알고리즘 유형 : #math , #에라토스테네스의체
플랫폼 : #BOJ
난이도 : G5
문제번호 : 27172
시간 : -
해결 : △
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/27172
특이사항 :
*/

package BOJ.Math.BOJ_27172_G5_수나누기게임;

import java.util.*;
import java.io.*;

public class BOJ_27172_G5_수나누기게임 {
    static StringTokenizer st;
    static final int MAX = 1000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] player = new int[N];
        int[] score = new int[MAX + 1];
        boolean[] cardExist = new boolean[MAX + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            cardExist[player[i]] = true;
        }

        for (int i : player) {
            for (int j = i * 2; j <= MAX; j+=i) {
                if(cardExist[j]) {
                     score[i]++;
                     score[j]--;
                 }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : player) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }
}
