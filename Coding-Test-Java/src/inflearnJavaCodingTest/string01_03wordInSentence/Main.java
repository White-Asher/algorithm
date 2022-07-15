package inflearnJavaCodingTest.string01_03wordInSentence;

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
		int m = Integer.MIN_VALUE;
		String[] s = str.split(" ");
		for(String x : s) {
			int len = x.length();
			if(len > m) {
				m = len;
				answer =x;
			}
		}
		return answer;
	}

}
