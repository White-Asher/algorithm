package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snack = new int[N];
			int max = -1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) snack[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(snack);
			int idx = 1;
			for (int i = snack.length-1; i >= 0; i--) {
				for (int j = snack.length-1-idx; j >= 0; j--) {
					int sum = snack[i] + snack[j];
					if(sum > max && sum <= M) {
						max = sum;
					}
				}
				if(max == M) break;
				idx++;
			}
			System.out.printf("#%d %d%n", tc, max);
		}
	}
}
