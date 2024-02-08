/*
제목 : DanceDanceRevolution
알고리즘 유형 : #dp
플랫폼 : #BOJ
난이도 : G3
문제번호 : 2342
시간 : INF
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/2342
특이사항 : #
*/

package _UnsolvedProblem.BOJ_2342_G3_DanceDanceRevolution;

import java.util.*;
import java.io.*;

public class BOJ_2342_G3_DanceDanceRevolution {
    static List<Integer> list;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        while(true) {
            int input = Integer.parseInt(st.nextToken());
            if(input == 0) break;
            list.add(input);
        }
        int size = list.size();
        dp = new int[size][5][5];
        int ans = ddr(0,0,0);
        System.out.println(ans);
    }

    public static int ddr(int idx, int left, int right) {
        // 발판 모두 밟았을 때
        if(idx == list.size()) {
            return 0;
        }
        // 이미 밟은 발판인경우
        if(dp[idx][left][right] != 0) {
            return dp[idx][left][right];
        }
        int next = list.get(idx);
        dp[idx][left][right] = Math.min(
                ddr(idx + 1, next, right) + energy(left, next),
                ddr(idx + 1, left, next) + energy(right, next)
        );

        return dp[idx][left][right];
    }

    public static int energy(int start, int end) {
        int num = Math.abs(start - end);
        if(start == 0) return 2;
        if(start == end) return 1;
        if(num == 1 || num == 3) return 3;
        else return 4;
    }
}
