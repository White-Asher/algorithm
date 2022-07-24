package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA13229D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String day = br.readLine();
			int ans = 0;
			
			switch (day) {
			case "SUN":
				ans = 7;
				break;
			case "SAT":
				ans = 1;
				break;
			case "MON":
				ans = 6;
				break;
			case "TUE":
				ans = 5;
				break;
			case "WED":
				ans = 4;
				break;
			case "THU":
				ans = 3;
				break;
			case "FRI":
				ans = 2;
				break;
			default:
				break;
			}
			

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
