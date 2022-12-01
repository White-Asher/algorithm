package BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            if (input.length() % 2 != 0) {
                continue;
            } else {
                for (int j = 0; j < input.length(); j++) {
                    if (!stack.isEmpty() && stack.peek().equals(input.charAt(j))) {
                        stack.pop();
                    } else {
                        stack.push(input.charAt(j));
                    }
                }
                if (stack.isEmpty()) result++;
            }
        }
        System.out.println(result);
    }
}
