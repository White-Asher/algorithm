/*
제목 : 거스름돈
알고리즘 유형 : #dp
플랫폼 : #Programmers 
난이도 : L3
문제번호 : 12907
시간 : 60m
해결 : X
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12907
특이사항 : 
*/

import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        
        int[] answer = new int[n+1];
        answer[0] = 1;
        
        for(int m : money) {
            for(int i = m; i <= n; i++) {
                answer[i] += answer[i - m];
            }
        }
        
        return (int) answer[n] % 1000000007;
    }
}