package BOJ.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_Normal {
	static boolean[] isSelected;
	static int[][] nums;
	static int N, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		nums = new int[N][2];
		isSelected = new boolean[N];
		
		for(int n = 0 ; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[n][0] = Integer.parseInt(st.nextToken());
			nums[n][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(ans);
	}

	public static void subset(int idx) {
		int sourTasteSum = 1;
		int bitterTasteSum = 0;

		if (idx == N) {
				for (int j = 0; j < N; j++)
					if (isSelected[j]) {
						sourTasteSum *= nums[j][0];
						bitterTasteSum += nums[j][1];
						int result = Math.abs(sourTasteSum - bitterTasteSum);
						if (ans >= result) ans = result;
					}
			return;
		}

		isSelected[idx] = true;
		subset(idx+1);
		isSelected[idx] = false;
		subset(idx+1);
	}

}
