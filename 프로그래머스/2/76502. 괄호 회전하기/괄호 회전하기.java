import java.util.*;
import java.io.*;

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