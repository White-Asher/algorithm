package _Playground._Practice.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CD {
	static int N, R;
	static int[] nums;
	static int[] inputs;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		inputs = new int[N];
		nums = new int[R];
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		combiDup(0,0);
	}

	private static void combiDup(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = inputs[i];
			combiDup(cnt+1, i);
		}
		
	}
}
