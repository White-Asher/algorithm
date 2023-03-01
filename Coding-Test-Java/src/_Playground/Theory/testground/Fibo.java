package _Playground.Theory.testground;

import java.util.Scanner;

public class Fibo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fibo(sc.nextInt()));
	}
	
	static int fibo(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1 || n == 2) {
			return 1;
		}
		else {
			return fibo(n-1) + fibo(n-2);
		}
	}
}
