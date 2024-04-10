package BOJ.SJB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_NM5 {
	static int N, R;
	static int[] nums, inputs;
	static StringTokenizer st;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int[R];
		inputs = new int[N];

		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) inputs[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(inputs);		
		perm(0, 0);
		bw.flush();
		bw.close();
	}
	
	public static void perm(int cnt, int flag) throws IOException {
		if(cnt == R) {
			for (int i : nums) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			nums[cnt] = inputs[i];
			perm(cnt+1, flag | 1 << i);
		}
		
	}
}
