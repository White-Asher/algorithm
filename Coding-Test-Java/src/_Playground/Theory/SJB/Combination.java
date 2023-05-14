package _Playground.Theory.SJB;

import java.util.*;
import java.io.*;

public class Combination {
	static int N, R, totalCnt;
	static int[] nums, inputs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		nums = new int[R];
		inputs = new int[N];
		
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		combination(0, 0);
		System.out.println("totalCnt : " + totalCnt);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i = start; i < N; i++) {
			nums[cnt] = inputs[i];
			combination(cnt+1, i+1);
		}
	}
}

/*
input
5 3
1 2 3 4 5

output
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
totalCnt : 10
*/