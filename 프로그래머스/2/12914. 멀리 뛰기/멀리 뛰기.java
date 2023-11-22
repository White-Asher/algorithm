/*
제목 : 멀리 뛰기
알고리즘 유형 : #dp 
플랫폼 : #Programmers 
난이도 : L2
문제번호 : 12914
시간 : 3
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12914
특이사항 : 
*/

import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n >= 2) {
            dp[2] = 2;
        }
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n] % 1234567;
    }
}