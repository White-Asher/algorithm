package BOJ.BFSDFS.BOJ_2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2239_TRY1 {
	static final int SUDOKU_SIZE = 9;
	static int[][] map = new int[SUDOKU_SIZE][SUDOKU_SIZE];
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			String input = br.readLine();
			for (int j = 0; j < SUDOKU_SIZE; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		
		DFS(0,0);
		
	}
	
	public static void DFS(int x, int y) {
		if(x == SUDOKU_SIZE) {
			printSudoku();
		}
		
		if(y == SUDOKU_SIZE) {
			DFS(x+1, 0);
			return;
		}
		if(map[x][y] != 0) {
			DFS(x, y+1);
		} else if(map[x][y] == 0) {
			for (int num = 1; num <= SUDOKU_SIZE; num++) {
				if(check(x,y,num)) {
					map[x][y] = num;
					DFS(x, y+1);
				}
			
			}
			map[x][y] = 0;
			return;
		}
		
	}
	
	private static void printSudoku() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			for (int j = 0; j < SUDOKU_SIZE; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		System.exit(0);
	}

	public static boolean check(int x, int y, int value) {
		
		// 가로
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			if(map[x][i] == value) return false;
		}
		
		// 세로
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			if(map[i][y] == value) return false;
		}
		
		// 박스
		
		int sx = x / 3 * 3;
		int sy = y / 3 * 3;
		
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if(map[i][j] == value) return false;
			}
		}
		
		return true;
	}
}
