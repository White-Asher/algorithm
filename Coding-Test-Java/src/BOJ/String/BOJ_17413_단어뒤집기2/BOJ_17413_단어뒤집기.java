package BOJ.String.BOJ_17413_단어뒤집기2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413_단어뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean check = false;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
                check = true;
            }
            else if (c == '>') {
                sb.append(c);
                check = false;
            }
            else if (check) {
                sb.append(c);
            }
            else {
                if (c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
                else {
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}