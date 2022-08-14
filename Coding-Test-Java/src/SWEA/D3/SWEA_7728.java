package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_7728 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int[] arr = new int[10];
			String s = br.readLine();
			for(int i = 0; i< s.length(); i++) {
				int n = Integer.parseInt(String.valueOf(s.charAt(i)));
				arr[n]+=1;
			}
			
			for (int i : arr) {
				if(i!=0) {
					ans++;
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
