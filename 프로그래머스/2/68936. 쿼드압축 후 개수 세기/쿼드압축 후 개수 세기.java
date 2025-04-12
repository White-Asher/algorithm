/*
제목 : 쿼드압축 후 개수 세기
알고리즘 유형 : #재귀 , #분할정복
플랫폼 : #Programmers
난이도 : L2
문제번호 : 68936
시간 : 30
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68936
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

class Solution {
    static int[] ans = new int[]{0,0};
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        recursive(0, 0, arr.length, arr);
        return ans;
    }

    void recursive(int h, int w, int size, int[][] arr) {
        int tar = arr[h][w];
        boolean sameValChk = true;
        for(int i = h; i < h + size; i++) {
            for(int j = w; j < w + size; j++) {
                if(tar != arr[i][j]) {
                    sameValChk = false;
                }
            }
        }
        if(sameValChk) ans[tar]++;
        
        else {
            size /= 2;
            recursive(h, w, size,arr);
            recursive(h + size, w, size, arr);
            recursive(h, w + size, size, arr);
            recursive(h + size, w + size, size, arr);
        }
    }
}