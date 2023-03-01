package _Playground._Practice.day0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combi_duplicate {
	static int N, R;
	static int[] nums, input;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		nums = new int[R];
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		combiDuplicate(0,0);
		
	}
	
	private static void combiDuplicate(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = input[i];
			combiDuplicate(cnt+1, i);
		}
	}
}
/*
5 3
1 2 3 4 5
[1, 1, 1]
[1, 1, 2]
[1, 1, 3]
[1, 1, 4]
[1, 1, 5]
[1, 2, 2]
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 3]
[1, 3, 4]
[1, 3, 5]
[1, 4, 4]
[1, 4, 5]
[1, 5, 5]
[2, 2, 2]
[2, 2, 3]
[2, 2, 4]
[2, 2, 5]
[2, 3, 3]
[2, 3, 4]
[2, 3, 5]
[2, 4, 4]
[2, 4, 5]
[2, 5, 5]
[3, 3, 3]
[3, 3, 4]
[3, 3, 5]
[3, 4, 4]
[3, 4, 5]
[3, 5, 5]
[4, 4, 4]
[4, 4, 5]
[4, 5, 5]
[5, 5, 5]
*/
