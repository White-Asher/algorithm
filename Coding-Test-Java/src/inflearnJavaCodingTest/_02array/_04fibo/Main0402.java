package inflearnJavaCodingTest._02array._04fibo;

import java.util.*;

// 피보나치 수열 : 배열을 사용하지 않고 구현
public class Main0402 {
	public Main0402() {
		Main0402 main = new Main0402();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		main.solution(n);
		scanner.close();
	}
	
	public void solution(int n) {
		int a = 1, b = 1, c;
		System.out.println(a+ " " + b + " ");
		for (int i = 2; i < n; i++) {
			c = a + b;
			System.out.println(c + " ");
			a=b;
			b=c;
		}
	}
}