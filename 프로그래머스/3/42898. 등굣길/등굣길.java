/*
제목 : 등굣길
알고리즘 유형 : #dp
플랫폼 : #Programmers 
난이도 : L3
문제번호 : 42898
시간 : 20m
해결 : O
저장 : X
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42898
특이사항 : #프로그래머스-고득점
*/

import java.util.*;

class Solution {
    static long[][] arr;
    static int ans = 0;

    public long solution(int m, int n, int[][] puddles) {
        
        arr = new long[n+1][m+1];
        for(int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            arr[y][x] = -1;
        }
        arr[1][1] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(arr[i][j] == -1 || (i == 1 && j == 1)) {
                    continue;
                }
                
                long up = arr[i-1][j];
                long left = arr[i][j-1];
                if(up == -1) {
                    up = 0;
                }
                if(left == -1) {
                    left = 0;
                }

                arr[i][j] = (long) (up + left) % 1000000007;

            }
        }

        return arr[n][m] % 1000000007;
    }
    
}