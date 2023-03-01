package _Playground.inflearnJavaCodingTest._01string._01findText;

import java.util.*;

// 1-1. 문자 찾기
public class Main{
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		// next와 nextLine 의 차이점이 무엇일까?
		String input1 = scanner.next();
		// next는 string으로 받는다 char는 문자 1개를받아야 하므로 .charAt()을 사용함.
		char input2 = scanner.next().charAt(0);
		
		System.out.println(main.solution(input1, input2));
		
		scanner.close();
	}
	public int solution(String input1, char input2) {
		int answer = 0;
		// 특정 문자의 대소문자 구분없이 몇 개 존재하는지 알아내야 하므로 전부 대문자로 바꿈
		// 찾으려는 문자도 대문자로 찾기 위해 변경
		input1 = input1.toUpperCase();
		input2 = Character.toUpperCase(input2);
        
        for(int i = 0; i< input1.length(); i++) {
        	if(input1.charAt(i) == input2) {
        		answer++;
        	}
        }
        
        /* for-each
        // String을 문자 한개씩 만들어 줘야 한다. => toCharArray()사용
        for(char input2 : input1.toCharArray()) {
        	if (input2 == input1) {
				answer++;
			}
        }
         */
		
		return answer;
	}
}