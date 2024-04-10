package BOJ.SJB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_NM8 {
	static int N, R;
	static int[] inputs, nums;
	static StringTokenizer st;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		nums = new int[R];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);
		comb(0,0);
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start) throws IOException {
		if(cnt == R) {
			for (int i : nums) {
				bw.write(i + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = inputs[i];
			comb(cnt+1, i);
		}
		
	}
}
