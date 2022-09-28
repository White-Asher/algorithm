package _Practice.day0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combi {
	static int N, R;
	static int[] nums;
	static int[] inputs;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		nums = new int[R];
		inputs = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0,0);
		
	}

	private static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
			
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = inputs[i];
			combination(cnt+1, i+1);
		}
		
	}
	
}
/*
5 3
1 2 3 4 5
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 4]
[1, 3, 5]
[1, 4, 5]
[2, 3, 4]
[2, 3, 5]
[2, 4, 5]
[3, 4, 5]
*/
