package SWEA.SWNormal;

import java.io.FileInputStream;

import java.util.Scanner;

// 카운팅 정렬...?
public class SWEA_1208_Flatten_Pro1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea_1208.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] box = new int[101];
			int minH = 100, maxH = 1;
			
			for (int i = 0; i < 100; i++) {
				int h = sc.nextInt();
				box[h]++;
				if(maxH < h) maxH = h;
				if(minH > h) minH = h;
			}
			
			while(N > 0 && minH < maxH - 1) {
				box[maxH]--;
				box[minH]--;
				
				box[maxH-1]++;
				box[minH+1]++;
				
				if(box[maxH] == 0) maxH--;
				if(box[minH] == 0) minH--;
				N--;
			}
			
			System.out.printf("#" + t + " " + (maxH-minH));
		}
	}
}
/*
메모리: 21,040 kb
실행시간: 136 ms
코드길이: 960
*/