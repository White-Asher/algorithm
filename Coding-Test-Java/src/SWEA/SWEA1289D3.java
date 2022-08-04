package com.ssafy.recur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

// 1289 원재의 메모리 복구하기
public class SWEA1289D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <=t; tc++) {
			String inputData = br.readLine();
			int[] nums = Stream.of(inputData.split("")).mapToInt(Integer::parseInt).toArray();

			String[] inputStr = br.readLine().split("");
			int[] inputInt = new int[inputStr.lenght]
			for(int i = 0; i < inputStr.length; i++){
				inputInt[i] = Integer.parseInt(inputStr[i]);
			}
			
			int ans = 0;

				int temp = 0;
				for(int j = 0; j < nums.length; j++ ) {
					if(nums[j] != temp) {
						temp = nums[j];
						ans++;
					}
				}
			
			System.out.printf("#%d %d\n", tc, ans);
		}

	}
}


// public class SWEA_1289 {
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int t = Integer.parseInt(br.readLine());
		
// 		for(int tc = 1; tc <=t; tc++) {
// 			String inputData = br.readLine();
// 			int[] nums = Stream.of(inputData.split("")).mapToInt(Integer::parseInt).toArray();
			
// 			int ans = 0;
			
// 			for (int i = 0; i < nums.length; i++) {
				
// 				int temp = nums[i];
// 				if(temp == 1) {
// 					nums[i] = 0;
// 					for(int j = i; j<nums.length; j++ ) {
// 						if(nums[j] == 1) nums[j] = 0;
// 						else nums[j] = 1;
// 					}
// 					ans += 1;
// 				}
// 			}
// 			System.out.printf("#%d %d\n", tc, ans);
// 		}

// 	}
// }
