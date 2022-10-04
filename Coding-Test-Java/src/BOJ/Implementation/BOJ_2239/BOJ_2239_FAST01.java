package BOJ.Implementation.BOJ_2239;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2239_FAST01 {
	static char[][] sudoku;
	static int[] xCheck = new int[9];
	static int[] yCheck = new int[9];
	static int[][] boxCheck = new int[3][3];
	static ArrayList<int[]> zeroPos = new ArrayList<int[]>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new char[9][];
		
		for (int i = 0; i < 9; i++) {
			sudoku[i] = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				if(sudoku[i][j] == '0') zeroPos.add(new int[] {i, j});
				else {
					int toSum = 1 << ((sudoku[i][j] - '0') - 1);
					xCheck[i] += toSum;
					yCheck[j] += toSum;
					boxCheck[i / 3][j / 3] += toSum;
				}
			}
		}		
		solve(0);
		
		
		System.out.println(sb);
	}
	
	static boolean solve(int p) {
		
		if(p == zeroPos.size()) {
			for (int i = 0; i < 9; i++)
				sb.append(String.valueOf(sudoku[i])).append("\n");
			return true;
		}
		
		int[] pos = zeroPos.get(p);
		
		int forCheck = 1;
	
		for (int i = 0; i < 9; i++) {
			if((xCheck[pos[0]] & forCheck) == 0 && (yCheck[pos[1]] & forCheck) == 0 && (boxCheck[pos[0] / 3][pos[1] / 3] & forCheck) == 0) {
				sudoku[pos[0]][pos[1]] += (i + 1);
				xCheck[pos[0]] += forCheck;
				yCheck[pos[1]] += forCheck;
				boxCheck[pos[0] / 3][pos[1] / 3] += forCheck;
				
				if(solve(p + 1)) return true;
				
				xCheck[pos[0]] -= forCheck;
				yCheck[pos[1]] -= forCheck;
				boxCheck[pos[0] / 3][pos[1] / 3] -= forCheck;		
				sudoku[pos[0]][pos[1]] = '0';
			}
			
			forCheck <<= 1;
		}
		
		return false;
	}
}