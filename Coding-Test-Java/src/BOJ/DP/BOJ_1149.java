package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] data = new int[n+1][3];
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			data[i][0] = Math.min(data[i-1][1], data[i-1][2]) + R;
			data[i][1] = Math.min(data[i-1][0], data[i-1][2]) + G;
			data[i][2] = Math.min(data[i-1][0], data[i-1][1]) + B;
		}
		
		System.out.println(Math.min(data[n][0], Math.min(data[n][1], data[n][2])));
		
	}
}
