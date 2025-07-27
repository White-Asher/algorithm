package BOJ.DataStructure.Stack.BOJ_1918_G2_후위표기식;

import java.util.*;
import java.io.*;

public class BOJ_1918_G2_후위표기식_250723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(convert(br.readLine()));
    }

    public static String convert(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if(Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c =='(') {
                stack.push(c);
            } else if (c == ')') {
                // 스택이 비어있지 않고, 최상단이 여는 괄호가 아닐 동안 반복
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                // 스택이 비어있지 않고, 현재 연산자의 우선순위보다 스택의 최상단 연산자 우선순위가 높거나 같을 동안 반복
                while(!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static int getPriority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case ')':
                return 0;
            default:
                return -1;
        }
    }
}
