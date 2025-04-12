/*
제목 : 모음사전
알고리즘 유형 : #재귀
플랫폼 : #Programmers
난이도 : L2
문제번호 : 84512
시간 : 30
해결 : X
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/84512
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

/* SOL1 */

import java.util.*;

class Solution {
    static final char[] CHARS = "AEIOU".toCharArray();
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
    
    public void generate(String word, List<String> words) {
        words.add(word);
        
        if(word.length() == 5) return;
        for(char c : CHARS) {
            generate(word + c, words);
        }
    }
}

/* SOL2
class Solution {
	public int solution(String word) {
        int answer = word.length();
        char[] ch = {'A', 'E', 'I', 'O', 'U'};
        int []num = {781, 156, 31, 6, 1}; // 가중치 계산
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < 5; j++){
                if(word.charAt(i) == ch[j])
                    answer += num[i] * j;                            
            }
        }
        System.out.println(answer);
        return answer;
    }
}
*/