package SWEA.D3;

import java.util.Scanner;

public class SWEA_8821 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= t; i++) {
			String n = sc.nextLine();
			int[] ans = new int[10];
			
			String[] strarr = n.split("");
			
			for(String s : strarr) {
				int a = Integer.parseInt(s);
				if (ans[a] == 0) {
					ans[a] = 1;
				} else {
					ans[a] = 0;
				}
			}
			
			int count = 0;
			for(int b : ans) {
				if(b == 1) {
					count++;
				}
			}
			
			System.out.printf("#%d %d\n", i, count);
		}
	}
}
