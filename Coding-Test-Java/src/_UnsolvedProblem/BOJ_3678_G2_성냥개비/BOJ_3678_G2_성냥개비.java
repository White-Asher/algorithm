/*
제목 : 성냥개비
알고리즘 유형 : #dp, #greedy
플랫폼 : #BOJ
난이도 : G2
문제번호 : 3678
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/3687
특이사항 : #
*/

package _UnsolvedProblem.BOJ_3678_G2_성냥개비;

import java.io.*;
import java.util.*;

public class BOJ_3678_G2_성냥개비 {
    static long[] minDp = new long[101];
    /*
    최솟값을 구할 때 다음 자리수에 추가할 숫자를 정의함.
    성냥개비 2개를 사용할 때 추가할 수 있는 최솟값은 1
    반대로 성냥개비 5개로 추가할 수 있는 최솟값 후보는 2,3,5인데
    최솟값이므로 2를 추가.
     */
    static String[] add = {"0", "0", "1", "7", "4", "2", "0", "8"};
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        /*
        - 성냥 개비 8개로 만들 수 있는 최솟 값을 구해야함.
        - 9를만들 때 2+7, 3+6, 4+5, 5+4, 6+3, 7+2 가 있지만 8 + 1 은 고려하지 않음
        - 1의 경우는 만들 수 없기 때문이다.
         */
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1; // 1
        minDp[3] = 7; // 7
        minDp[4] = 4; // 4
        minDp[5] = 2; // 2, 3, 5
        minDp[6] = 6; // 6, 9, 0
        minDp[7] = 8; // 8
        minDp[8] = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String num = minDp[i - j] + add[j];
                minDp[i] = Math.min(Long.parseLong(num), minDp[i]);
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            solution(n);
        }
        System.out.println(sb);
    }

    protected static void solution(int n) {
        int digit = n / 2;
        /*
        큰 수 같은 경우는 7과 1로만 사용해서 만들 수 있다. 그러므로 자리수를 구해서
        홀수자리인경우 앞에 7 짝수자리인경우 1을 추가하면된다.
         */
        StringBuilder maxNum = new StringBuilder();
        if(n % 2 == 1) {
            maxNum.append("7");
        } else {
            maxNum.append("1");
        }
        for (int i = 1; i < digit; i++) {
            maxNum.append(add[2]);
        }
        sb.append(minDp[n]).append(" ").append(maxNum).append("\n");
    }
}
