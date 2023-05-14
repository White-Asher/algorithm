package _Playground.Theory.SJB;

import java.util.*;
import java.io.*;

public class CombinationDuplicate {
	static int N, R, totalCnt;
	static int[] nums, input;
	static StringTokenizer st;
	
	public static void main(String[] args ) throws IOException {
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
		
		combinationDuplicate(0,0);
		System.out.println("totalCnt : " + totalCnt);
	}
	
	private static void combinationDuplicate(int cnt, int start) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = input[i];
			combinationDuplicate(cnt+1, i);
		}
	}
}

/*
input
5 3
1 2 3 4 5

output
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
totalCnt : 35
*/
