package SSWtest.SWEA.SWEA_4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int N, R;
	static int[] nums, otherNums;
	static int[][] fruit;
	static int ans = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ans = Integer.MAX_VALUE;
			R = N/2; 
			nums = new int[R]; // A음식
			otherNums = new int[R]; // B음식
			fruit = new int[N][N]; // 재료 
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) fruit[i][j] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
	
	// 조합을 이용해 A음식에 사용할 재료를 구하자
	public static void combination(int cnt, int start) {
		if(cnt == R) {;
			getOtherNums(); //A음식에 사용되지 않은 재료는 B음식의 재료
			solution();
			return;
		}
		for(int i = start; i < N; i++) {
			nums[cnt] = i;
			combination(cnt+1, i+1);			
		}
	}
	
	public static void getOtherNums() {
		int idx = 0;
		for(int i = 0; i < N; i++ ) {
			boolean flag = true;
			for(int j = 0; j < R; j++) {
				if(i == nums[j]) {
					flag = false;				
				}
			}
			if(flag) otherNums[idx++] = i;
		}
	}
	
	// 시너지 구하기 
	public static void solution() {
		int a = 0;
		int b = 0;
		for(int i = 0; i < R; i++) {
			for(int j = i+1; j< R; j++ ) {
				a += fruit[nums[i]][nums[j]] + fruit[nums[j]][nums[i]];
				b += fruit[otherNums[i]][otherNums[j]] + fruit[otherNums[j]][otherNums[i]];
			}
		}
		int diff = Math.abs(a-b);
		if(ans > diff) ans = diff;
		// ans = Math.min(Math.abs(a-b), ans); //와 같음
	}
}
