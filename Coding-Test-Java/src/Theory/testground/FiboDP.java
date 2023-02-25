package Theory.testground;

import java.util.Scanner;

public class FiboDP {
	public static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		System.out.println(fibo(n));
	}
	
	public static int fibo(int i) {
		if (i == 0) {
			return 0;
		} else if (i == 1 || i == 2){
			return 1;
		} 
		
		if(memo[i] != 0) {
			return memo[i];
		}
		
		memo[i] = fibo(i-1) + fibo(i-2);
		return memo[i];
	}
}
