package BOJ.NandM;

import java.io.*;
import java.util.*;

// BOJ_15651 N과 M (3) : 중복 순열 
public class BOJ_15651 {
	static int N, R;
	static int[] nums;
	static StringBuilder sb;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int[N];
		duplicatePermutation(0);
		bw.flush();
		bw.close();
	}
	
	public static void duplicatePermutation(int cnt) throws IOException {
		sb = new StringBuilder();
		if(cnt == R) {
			for(int i = 0; i<R; i++)
				bw.write(String.valueOf(nums[i]+" "));
			bw.write(String.valueOf("\n"));
			return;
		}
		for (int i = 1; i <= N; i++) {
			nums[cnt] = i;
			duplicatePermutation(cnt+1);
		}
	}
}
