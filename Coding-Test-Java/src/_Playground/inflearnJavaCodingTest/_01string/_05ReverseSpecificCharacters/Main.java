package _Playground.inflearnJavaCodingTest._01string._05ReverseSpecificCharacters;

import java.io.*;

public class Main {
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(Main.solution(input));
	}

	public static String solution(String str) {
		String answer;
		char[] s = str.toCharArray();
		int lt = 0, rt = str.length() - 1;
		while (lt < rt) {
			if (!Character.isAlphabetic(s[lt])) lt++;
			else if (!Character.isAlphabetic(s[rt])) rt--;
			else{
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
		}
		// s를 스트링화 시킨다.
		answer = String.valueOf(s);
		return answer;
	}
}
