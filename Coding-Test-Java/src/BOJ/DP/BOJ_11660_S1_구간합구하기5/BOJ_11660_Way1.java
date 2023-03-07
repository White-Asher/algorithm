package BOJ.DP.BOJ_11660_S1_구간합구하기5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660_Way1 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = 0;
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int j = y1; j <= y2; j++) {
				
				sum+= map[j][x2] - map[j][x1-1];
			}
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
	}
}