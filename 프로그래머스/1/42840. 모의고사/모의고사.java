import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자들의 패턴들
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];
        
        // 수포자들의 패턴과 정답과 일치하는 횟수 확인
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        // 가장 높은 점수 저장한다.
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        // 가장 높은 점수를 가진 수포자들 번호 찾은 뒤 리스트에 적재
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
class Solution {
    public int[] solution(int[] answers) {
        int[] aa = {1, 2, 3, 4, 5};
        int[] bb = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cc = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == aa[i % 5]) {
                a++;
            }
            if(answers[i] == bb[i % 8]) {
                b++;
            }
            if(answers[i] == cc[i % 10]) {
                c++;
            }
        }
        int max = 0;
        
        max = Math.max(max, a);
        max = Math.max(max, b);
        max = Math.max(max, c);
        
        List<Integer> list = new ArrayList<>();
        if(max == a) {
            list.add(1);
        }
        if(max == b) {
            list.add(2);
        }
        if(max == c) {
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
*/