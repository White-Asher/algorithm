/*
제목 : 점프
알고리즘 유형 : #dp
플랫폼 : #BOJ
난이도 : S1
문제번호 : 1890
시간 : 30m
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/1890
특이사항 :
*/

package BOJ.DP.BOJ_1890_S1_점프;

import java.io.*;
import java.util.*;

public class BOJ_1890_S1_점프 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int next = map[i][j];
                if(dp[i][j] >= 1 && next !=0){
                    if(i + next < n) {
                        dp[i + next][j] += dp[i][j];
                    }
                    if(j + next < n) {
                        dp[i][j + next] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
