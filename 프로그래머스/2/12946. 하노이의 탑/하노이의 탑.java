/*
제목 : 하노이의 탑
알고리즘 유형 : #재귀 
플랫폼 : #Programmers
난이도 : L3
문제번호 : 12946
시간 : 60
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12946
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    void hanoi(int n, int start, int end, int sub) {
        if(n == 1) {
            move(start, end);
            return;
        }
        else {
            hanoi(n - 1, start, sub, end);
            move(start, end);
            hanoi(n -1 , sub, end, start);
        }
    }
    
    void move(int start, int end) {
        list.add(new int[]{start, end});
    }
}