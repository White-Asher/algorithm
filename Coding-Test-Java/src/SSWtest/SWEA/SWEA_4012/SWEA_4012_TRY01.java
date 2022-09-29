package SSWtest.SWEA.SWEA_4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_TRY01 {
	static int N, R;
	static int[][] fruit;
	static int[] nums;
	static int[] othernums;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			nums = new int[R];
			othernums = new int[R];
			ans = Integer.MAX_VALUE;
			
			fruit = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					fruit[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0, 0);
			
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}
	
	public static void calc() {
		int sum = 0;
		int othersum = 0;
		//컴비네이션을 또 쓰네 
		for (int i = 0; i < R; i++) {
			for (int j = i+1; j < R; j++) {
				sum += (fruit[nums[i]][nums[j]] + fruit[nums[j]][nums[i]]);
				othersum += (fruit[othernums[i]][othernums[j]] + fruit[othernums[j]][othernums[i]]);
			}
		}
		ans = Math.min(ans, Math.abs(sum-othersum));
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == R) {
//			System.out.println(Arrays.toString(nums));
			getOtherNums();
			calc();
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}
	
	
/*
[0, 1]
[0, 2]
[0, 3]
[1, 2]
[1, 3]
[2, 3]
 */
	private static void getOtherNums() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < R; j++) {
				if(i == nums[j]) {
					flag = true;
				}
			}
			if(flag == false) {
				othernums[cnt++] = i;
			}
		}
//		System.out.println(Arrays.toString(othernums));
		
	}
}
