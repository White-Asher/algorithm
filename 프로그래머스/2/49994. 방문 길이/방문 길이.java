/*
제목 : 방문 길이
알고리즘 유형 : #implement 
플랫폼 : #Programmers
난이도 : L2
문제번호 : 49994
시간 : 30
해결 : O
저장 : X
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
특이사항 : #Summer/Winter-Coding(2018)
*/

import java.util.*;

class Solution {
    static int x = 0;
    static int y = 0;
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            String s = String.valueOf(dirs.charAt(i));
            int sx = x;
            int sy = y;
            direMethod(s);
            
            if(x < -5) {
                x = -5;
            } else if (x > 5) {
                x = 5;
            } else if (y < -5) {
                y = -5;
            } else if (y > 5) {
                y = 5;
            } else {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                sb1.append(sx).append(sy).append(x).append(y);
                sb2.append(x).append(y).append(sx).append(sy);

                set.add(sb1.toString());
                set.add(sb2.toString());
            }
            
        }
        
        return set.size() / 2;
    }
    
    public void direMethod (String dire) {
        switch(dire) {
            case "U": 
                y--;
                break;
            case "D":
                y++;
                break;
            case "R":
                x++;
                break;
            case "L":
                x--;
                break;
            default:
        }
    }
}