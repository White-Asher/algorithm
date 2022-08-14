package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7510 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			// 효율 좋지 않음.
			/*
			for(int i = 1; i <= n; i++) {
				int tmp = 0;
				outer: for(int j = i; j<=n; j++) {
					tmp += j;
					if(tmp == n) {
						ans++;
					} else if(tmp > n) {
						continue outer;
					}
				}
			}*/
			// 효율 좋게..
			/* 등차수열의 합. a * (첫항 + a) / 2
			 * 
			 */
			
			

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
