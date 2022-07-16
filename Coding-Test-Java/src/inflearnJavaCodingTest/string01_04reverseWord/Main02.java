package inflearnJavaCodingTest.string01_04reverseWord;

import java.util.ArrayList;
import java.util.Scanner;

// 문자를 뒤집는 방법(메서드 사용 X)
public class Main02 {
	public static void main(String[] args) {
		Main02 main02 = new Main02();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = scanner.next();
		}
		
		for(String x : main02.solution(n, str)) {
			System.out.println(x);
		}
		scanner.close();
	}
	
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		for (String x : str) {
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length()-1;
			while(lt<rt) {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
			// valueOf(static 메서드)
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}
		return answer;
	}
}
