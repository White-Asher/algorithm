package BOJ.DnC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
	static int N;
	static int[][] map;
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = new int[2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		solution(0, 0, N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}
	public static void solution(int r, int c, int size) {
		int temp = map[r][c];
		boolean check = true;
		for(int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if(temp != map[i][j]) {
					check = false;
					break;
				}
			}
		}
		
		if(check) cnt[temp]++;
		
		else {
			size /= 2;
			solution(r, c, size);
			solution(r+size, c, size);
			solution(r, c+size, size);
			solution(r+size, c+size, size);
		}
	}
}
