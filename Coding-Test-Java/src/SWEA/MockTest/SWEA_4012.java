package SWEA.MockTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int N, R;
	static boolean[] check;
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
			check = new boolean[N+1];
			nums = new int[R];
			otherNums = new int[R];
			fruit = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) fruit[i][j] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
	
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {;
			getOtherNums();
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
			for(int j = 0; j < R; j++) if(i == nums[j]) flag = false;
			if(flag) otherNums[idx++] = i;
		}
	}
	
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
	}
}
