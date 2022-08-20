package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 메모리: 12504 KB
 * 실행시간: 1068 ms
 * 코드길이: 1502 B
 */

public class BOJ_1987_Sol1 {
	static int R, C, max;
	static char[][] map;
	static boolean[] check;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input();
		solution(0, 0, 0, check);
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
	
	public static void solution(int r, int c, int cnt, boolean[] check) {
		if (check[map[r][c]]) {
			max = Math.max(max, cnt);
			return;
		} else {
			check[map[r][c]] = true;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				solution(nr, nc, cnt + 1, check);
			}
			check[map[r][c]] = false;
		}
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = (char) (input.charAt(j)-'A');
			}
		}
		check = new boolean[26];
	}
}