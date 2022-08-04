package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine());
			int ans = 0;
			char[] arr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			outer: for (int i = 0; i < num; i++) {
				char input = arr[i];
				if(input == '{' || input == '[' || input == '(' || input == '<') stack.push(input);
				else if (stack.size() != 0 ) {
					if (input == '}' && stack.pop() == '{') continue;
					else if (input == ']' && stack.pop()  == '[') continue;
					else if (input == ')' && stack.pop()  == '(') continue;
					else if (input == '>' && stack.pop() == '<')continue;
					else break outer;
				}
			}
			if(stack.size() == 0) 	ans = 1;
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
