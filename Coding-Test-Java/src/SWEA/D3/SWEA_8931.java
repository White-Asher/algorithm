package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_8931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int idx = 0;
			for(int i = 0; i < n ; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num !=0) {
					arr[idx++] = num;
				} else if(num == 0) {
					arr[--idx] = 0;
				}
			}
			for (int i : arr) {
				ans+=i;
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
