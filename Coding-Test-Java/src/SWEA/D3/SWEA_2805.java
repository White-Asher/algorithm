package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		
		// 알고리즘
		for (int tc = 1; tc <= T; tc++) {
			// 맵 사이즈 입력, 맵 배열 선언
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			
			// 맵 데이터 입력
			for (int i = 0; i < size; i++) {
				char[] c = br.readLine().toCharArray();
//				String[] temp = br.readLine().split("");
//				int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
				for (int j = 0; j < size; j++) {
					map[i][j] = c[j] - '0';
//					map[i][j] = Integer.parseInt(temp[j]);
//					map[i][j] = arr[j];
				}
			}
			
			// 가운데 인덱스 찾기
			int mid = ( (size+1) / 2 ) - 1;
			int ans = 0;
			
			// 합 구하기 (가운데 줄)
			ans+=map[mid][mid];
			for(int i = 1; i <= mid; i++) {
				ans+=map[mid][mid+i];
				ans+=map[mid][mid-i];
			}
			
			// 합 구하기 (가운데 줄 위, 아래)
			for (int j = 1; j <= mid; j++) {
				ans += map[mid+j][mid];
				ans += map[mid-j][mid];
				for(int i = 1; i <= mid-j;  i++) {
					ans+=map[mid+j][mid+i];
					ans+=map[mid+j][mid-i];
					ans+=map[mid-j][mid+i];
					ans+=map[mid-j][mid-i];
				}
			}		
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
