/*
제목 : 바탕화면 정리
알고리즘 유형 : #string 
플랫폼 : #Programmers 
난이도 : L1
문제번호 : 161990
시간 : -
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
특이사항 : -
*/

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int xmin = 100;
        int xmax = 0;
        int ymin = 100;
        int ymax = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                if(String.valueOf(wallpaper[i].charAt(j)).equals("#")) {
                    int y = i;
                    int x = j;
                    xmin = Math.min(xmin, x);
                    xmax = Math.max(xmax, x);
                    ymin = Math.min(ymin, y);
                    ymax = Math.max(ymax, y);
                }
            }
        }
        ymax++;
        xmax++;
        answer = new int[]{ymin, xmin, ymax, xmax};
        return answer;
    }
}