package BOJ.SJB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15663_NM9 {
	static int N, R;
	static int[] inputs, nums;
	static StringTokenizer st;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedHashSet<String> set;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		nums = new int[R];
		
		st = new StringTokenizer(br.readLine());
		set = new LinkedHashSet<>();
		for (int i = 0; i < N; i++) inputs[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(inputs);
		
		permutation(0, 0);
		for (String s : set) {
			bw.write(s);
		}
		bw.flush();
		bw.close();
	}
	
	public static void permutation(int cnt, int flag) throws IOException {
		if(cnt == R) {
			sb = new StringBuilder();
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			set.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i)!= 0) continue;
			nums[cnt] = inputs[i];
			permutation(cnt+1, flag|1<<i);
		}
	}
}
