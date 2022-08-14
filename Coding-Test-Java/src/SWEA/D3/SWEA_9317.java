package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_9317 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			String n1 = br.readLine();
			String n2 = br.readLine();
			
			for(int i = 0; i < n; i++) {
				if( n1.charAt(i) == n2.charAt(i)) {
					ans++;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
