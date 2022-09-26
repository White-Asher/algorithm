package _aPractice.day0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permu {
	static int N, R;
	static int[] nums;
	static int[] input;
	static boolean[] isSelect;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		nums = new int[R];
		input = new int[N];
		isSelect = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		
	}
	
	public static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelect[i]) continue;
			isSelect[i] = true;
			nums[cnt] = input[i];
			permutation(cnt+1);
			isSelect[i] = false;
		}
	}
}
