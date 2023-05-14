package BOJ.NandM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15652_NM4 {
	static int N, R;
	static int[] nums;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		nums = new int[R];
		
		duplicatePermutation(0, 1);
		bw.flush();
		bw.close();
	}
	
	public static void duplicatePermutation(int cnt, int start) throws IOException {
		if(cnt == R) {
			for (int i : nums) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}
		for(int i = start; i <= N; i++) {
			nums[cnt] = i;
			duplicatePermutation(cnt+1, i);
		}
	}
}
