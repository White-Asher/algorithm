package SSWtest.SWEA.SWEA_4008_Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
메모리: 31,156 kb
실행시간: 145 ms
코드길이: 1,640
*/

public class SWEA_4008 {
	static int N;
	static int[] func, nums;
	static int maxVal, minVal;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			func = new int[4];
			nums = new int[N];
			maxVal = Integer.MIN_VALUE;
			minVal = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				func[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(nums));
			DFS(0, nums[0]);
			int ans = maxVal - minVal;
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}


	private static void DFS(int cnt, int value) {
		if(cnt == N-1) {
			minVal = Math.min(minVal, value);
			maxVal = Math.max(maxVal, value);
			return;
		}
		
		for (int index = 0; index < 4; index++) {
			
			if(func[index] > 0) {
				func[index]--;
				
				switch (index) {
				case 0:
					DFS(cnt + 1, value + nums[cnt+1]);
					break;
				case 1:
					DFS(cnt + 1, value - nums[cnt+1]); 
					break;
				case 2:
					DFS(cnt + 1, value * nums[cnt+1]); 
					break;
				case 3:
					DFS(cnt + 1, value / nums[cnt+1]);
					break;
				default:
					break;
				}
				func[index]++;
			}
			
			
		}
		
		
	}
	
	
	
	/*
	private static void permu(int cnt) {
		if(cnt == N-1) {
			System.out.println(Arrays.toString(out));
			
			return;
		}
		
		for (int i = 0; i < N-1; i++) {
			if(select[i]) continue;
			select[i] = true;
			out[cnt] = func[i];
			permu(cnt+1);
			select[i] = false;
		} 
		
	}
	
	public static int calc(int x, int y, int op) {
		switch (op) {
		case 1: // 덧셈
			return x + y;
		case 2: // 뺄셈
			return x - y;
		case 3: // 곱셈
			if(x == 0 || y == 0) return 0;
			return x * y;
		case 4: // 나눗셈
			if(x == 0 || y == 0) return 0;
			return x / y;
		default:
			return 0;
		}
	}
	*/
}
