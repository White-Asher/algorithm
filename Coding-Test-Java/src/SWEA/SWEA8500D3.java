package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA8500D3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			for(int i = 0; i < n ;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			for (int i = arr.length-1; i >= 0; i--) {
				if(i == arr.length-1) {
					ans+=(arr[i]*2+1);
				} else {
					ans+=(arr[i]+1);
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
