package _Playground.inflearnJavaCodingTest._01string._03wordInSentence;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(main.solution(str));
		scanner.close();
	}
	
	public String solution(String str) {
		String answer = "";
		
		// indexOf, subString 사용
		int m = Integer.MIN_VALUE, pos;
		
		// 띄어쓰기를 발견 못하면 -1을 리턴, 발견하면 index번호 리턴
		while((pos = str.indexOf(' ')) != -1) {
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos+1);
		}
		// 마지막 단어의 길이가 str보다 크다면 정답을 바꾼다.
		if(str.length()>m) {
			answer = str;
		}
		
		// split로 단어 분리.
		/* 
		int m = Integer.MIN_VALUE;
		String[] s = str.split(" ");
		for(String x : s) {
			int len = x.length();
			// 최대값 구하는 알고리즘. (여기서 가장 긴 단어를 구함)
			if(len > m) {
				m = len;
				answer =x;
			}
		}
		*/
		
		return answer;
	}

}
