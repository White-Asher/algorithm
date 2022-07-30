package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class SWEA2360D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigDecimal a = new BigDecimal(st.nextToken());
			BigDecimal b = new BigDecimal(st.nextToken());
			BigDecimal res = a.add(b);

			System.out.println("#"+tc+" "+res);
		}
	}
}
