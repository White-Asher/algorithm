package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6730 {
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int high = 0;
			int low = 0;
			
			for (int i = 0; i < arr.length -1 ; i++) {
				if(arr[i] > arr[i+1]) high = Math.max(arr[i]- arr[i+1], high);
				else if(arr[i] < arr[i+1]) low = Math.max(arr[i+1]- arr[i], low);
			}
			
			System.out.printf("#%d %d %d\n", t, low, high);
		}
		
	}
}
