package BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_5697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String inputStr = br.readLine();

            String input = sol(inputStr);
            System.out.println(input);
        }

    }

    public static String sol(String inputStr){
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < inputStr.length(); i++) {
            switch (inputStr.charAt(i)){
                case '<':
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case '>':
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case '-':
                    if (!left.isEmpty()) left.pop();
                    break;
                default:
                    left.push(inputStr.charAt(i));
                    break;
            }
        }

        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        while(!left.isEmpty()){
            sb.append(left.pop());
        }
        return sb.reverse().toString();

    }
}
