package _Playground.inflearnJavaCodingTest._02array._04fibo;

import java.util.*;

// 배열사용하여 피보나치 수열 해결
public class Main0401 {

	public static void main(String[] args) {
		Main0401 main = new Main0401();
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		for (int x : main.solution(n)) {
			System.out.print(x + " ");
		}
		
		scanner.close();
	}
	
	public int[] solution(int n) {
		int[] answer = new int[n];
		answer[0] = 1;
		answer[1] = 1;
		for(int i = 2; i< n; i++) {
			answer[i] = answer[i-2] + answer[i-1];
		}
		return answer;
	}

}
