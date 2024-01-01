/*
제목 : 타일채우기
알고리즘 유형 : #dp
플랫폼 : #BOJ
난이도 : G4
문제번호 : 2133
시간 : X
해결 : X
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/2133
특이사항 :
아이디어 : 
*/

package BOJ.DP.BOJ_2133_G4_타일채우기;

import java.util.*;

public class BOJ_2133_G4_타일채우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 0;
        if(n >= 2) dp[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2] * dp[2];
            for (int j = i - 4; j >= 0 ; j-=2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }
        System.out.println(dp[n]);
    }
}
