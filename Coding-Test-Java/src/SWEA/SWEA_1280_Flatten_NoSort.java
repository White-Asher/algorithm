package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1280_Flatten_NoSort {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int cnt = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> lowerQueue = new PriorityQueue<>();
			PriorityQueue<Integer> upperQueue = new PriorityQueue<>(Collections.reverseOrder());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				int input = Integer.parseInt(st.nextToken());
				lowerQueue.add(input);
				upperQueue.add(input);
			}
			
			while(cnt-- > 0) {
				int min = lowerQueue.poll();
				int max = upperQueue.poll();
				if(min == max) break;
				lowerQueue.add(min+1);
				upperQueue.add(max-1);
			}
			System.out.printf("#%d %d\n", tc, upperQueue.poll() - lowerQueue.poll());
		}
	}
}
/*
21,032 kb
메모리
128 ms
실행시간
1,026
코드길이
*/