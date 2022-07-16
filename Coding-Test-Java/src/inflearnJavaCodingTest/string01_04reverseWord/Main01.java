package inflearnJavaCodingTest.string01_04reverseWord;

import java.util.ArrayList;
import java.util.Scanner;

//StringBuilder의 reverse를 이용한 방법
public class Main01 {
	public static void main(String[] args) {
		Main01 main = new Main01();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		String[] strings = new String[n];
		
		for (int i = 0; i < n; i++) {
			strings[i] = scanner.next(); 
		}
		
		
		for (String x : main.solution(n, strings)) {
			System.out.println(x);
		}
		
		
		
		scanner.close();
	}
	
	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		for(String x : str) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
			
		}
		
		return answer;
	}

}
