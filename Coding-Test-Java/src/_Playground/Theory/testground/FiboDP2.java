package _Playground.Theory.testground;

import java.util.Scanner;

public class FiboDP2 {
	public static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		
		if(n == 0) {
			memo[0] = 0;
		} else if(n == 1) {
			memo[1] = 1;
		} else if(n == 2) {
			memo[2] = 1;
		} else {
			memo[0] = 0;
			memo[1] = 1;
			memo[2] = 1;
			for (int i = 3; i < n+1; i++) {
				memo[i] = memo[i-1] + memo[i-2];
			}
		}

		System.out.println(memo[n]);
	}
}
