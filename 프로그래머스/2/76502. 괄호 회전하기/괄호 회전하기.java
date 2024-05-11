import java.util.*;
import java.io.*;

// 다른 풀이
class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        // 괄호 정보를 저장하여, 코드를 간결하게 할 수 있음
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int n = s.length(); // 원본 문자열 길이 저장
        s += s; // 원본 문자 뒤에 원본 문자열을 이어 붙여 2번 나오도록 만듦
        int answer = 0;
        
        // 확인할 문자열의 시작 인덱스를 0부터 n까지 이동.
        A:for(int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            // i(시작 위치) 부터 원본 문자열의 길이인 n깨까지 올바른 괄호 문자열인지 확인
            for(int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                if(!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
                
            }
            
            // continue되지 않았고, 스택이 비어있다면 올바른 괄호 문자열
            if(stack.isEmpty()) {
                answer++;
            }
            
            
        } // A:for END
        
        return answer;
    }
}


// 첫 시도 풀이
/*
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i, s.length()));
            sb.append(s.substring(0, i));
            
            Stack<String> stack = new Stack<>();
            // sb for START
            for(int j = 0; j < sb.length(); j++) {
                String tar = String.valueOf(sb.charAt(j));
                if(stack.size() == 0) {
                    stack.add(tar);
                } else if(tar.equals("[") || tar.equals("(") || tar.equals("{")) {
                    stack.add(tar);
                } else if (tar.equals("}")) {
                    if(stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        stack.add(tar);
                    }
                } else if (tar.equals(")")) {
                    if(stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.add(tar);
                    }
                } else if (tar.equals("]")) {
                    if(stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.add(tar);
                    }
                } 
                
            }
            // sb for END
            
            if(stack.size() == 0) {
                answer++;
            }
        }
        return answer;
        
    }
}
*/