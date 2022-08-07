package SWEA;

import java.util.Scanner;

// 수학적으로 접근할 수 있다.
public class SWEA_2806_Pro {
	public static void main(String[] args) {
		
		// 데이터 입력 
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] data = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = data[j] - '0';
				}
			}
			
			// 로직
			int center = N / 2;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(center - i) + Math.abs(center - j) <= center) {
						ans += farm[i][j];
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
