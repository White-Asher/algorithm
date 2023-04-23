package BOJ.DP.BOJ_2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_Sol1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		while (N > 0) {
			if (N % 5 == 0) {
				cnt += N / 5;
				N = 0;
				break;
			}
			cnt++;
			N -= 3;
		}
		if (N < 0)
			System.out.println("-1");
		else
			System.out.println(cnt);

	}
}
