package BOJ.DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int ans = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.push('(');
				continue;
			} else {
				stack.pop();
				if (input.charAt(i - 1) == '(') ans += stack.size();
				else ans += 1;
			}
		}
		System.out.println(ans);
	}
}

// stack을 사용하지 않은 풀이
//
//import java.util.*;
//import java.io.*;
//
//public class BOJ_10799 {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int check = 0;
//        int result = 0;
//
//        String input = br.readLine();
//
//        for(int i = 0; i < input.length(); i++){
//            if(input.charAt(i) == '(')
//                check++;
//            else{
//                check--;
//                if(input.charAt(i-1) == '(')
//                    result+=check;
//                else
//                    result++;
//            }
//        }
//
//        System.out.println(result);
//    }
//
//}