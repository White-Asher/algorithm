import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else if(s.charAt(i) == ')' && stack.size() > 0) {
                stack.pop();
            } else {
                stack.push('(');
            }
        }
        
        if(stack.size () > 0) {
            answer = false;
        }
        return answer;
    }
}