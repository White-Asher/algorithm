package _Playground.inflearnJavaCodingTest._01string._02CaseConversion;

import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		System.out.println(main.solution(input));
		scanner.close();
	}
	
	public String solution(String input) {
		String answer = "";
		for(char x : input.toCharArray()) {
			
			// 1. 내장함수 isLowerCase, (isUpperCase) 이용
			/*
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			} else {
				answer += Character.toLowerCase(x);
			}
			*/
			
			// 2. 아스키 코드 이용
			if(x >= 97 && x<=122) {
				// 소문자가 대문자로 변환
				answer+=(char)(x-32);
			} else {
				answer +=(char)(x+32);
			}
		}
		return answer;
	}
}