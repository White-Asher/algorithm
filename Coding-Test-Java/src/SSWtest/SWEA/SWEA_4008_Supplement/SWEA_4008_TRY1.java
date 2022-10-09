package SSWtest.SWEA.SWEA_4008_Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008_TRY1 {
	static StringTokenizer st;
	static int N;
	static int[] op;
	static int[] nums;
	static int minVal, maxVal;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			nums = new int[N];
			maxVal = Integer.MIN_VALUE;
			minVal = Integer.MAX_VALUE;
			
			// + - X /
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			

			DFS(0, nums[0]);
			int ans = maxVal - minVal;
			System.out.printf("#%d %d\n", t, ans);
		} // test-case end
		
		
	}

	private static void DFS(int count, int value) {
		
		if(count == N-1) {
			minVal = Math.min(minVal, value);
			maxVal = Math.max(maxVal, value);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				
				switch (i) {
				case 0:
					DFS(count+1, value + nums[count+1]);
					break;
				case 1:
					DFS(count+1, value - nums[count+1]);
					break;
				case 2:
					DFS(count+1, value * nums[count+1]);
					break;
				case 3:
					DFS(count+1, value / nums[count+1]);
					break;
				default:
					break;
				}
				op[i]++;
			}

		}
		
		
	}
	
	
}
