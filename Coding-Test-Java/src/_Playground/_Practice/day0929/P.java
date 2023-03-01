package _Playground._Practice.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P {
	static int N, R;
	static int[] nums;
	static int[] input;
	static boolean[] select;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		input = new int[N];
		nums = new int[R];
		select = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			
		}
		
		permu(0);
	}

	private static void permu(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;
			select[i] = true;
			nums[cnt] = input[i];
			permu(cnt+1);
			select[i] = false;
			
		}
	}
}
