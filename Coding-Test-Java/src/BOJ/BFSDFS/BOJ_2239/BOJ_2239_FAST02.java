package BOJ.BFSDFS.BOJ_2239;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2239_FAST02 {

	static int[][] grid;
	static int[][] bitsArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// initialize grid and bits
		grid = new int[9][9];
		bitsArr = new int[3][9]; // bitsArr["type"]["group_id"]
		for (int r = 0; r < 9; r++) {
			String line = br.readLine();
			for (int c = 0; c < 9; c++) {
				int x = line.charAt(c) - '1'; // convert to zero-base
				grid[r][c] = x;
				if (x >= 0) {
					bitsArr[0][r] |= (1 << x);
					bitsArr[1][c] |= (1 << x);
					bitsArr[2][3 * (r / 3) + (c / 3)] |= (1 << x);
				}
			}
		}

		// search starting from the left-upper corner
		search(0);

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(grid[r][c] + 1); // convert to one-base
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static boolean search(int cnt) {
		if (cnt == 81) { // target condition
			return true;
		}

		int r = cnt / 9;
		int c = cnt % 9;
		int x = grid[r][c];

		if (x >= 0) { // fixed number
			return search(cnt + 1);
		}

		// store original bits
		int bits0 = bitsArr[0][r];
		int bits1 = bitsArr[1][c];
		int bits2 = bitsArr[2][3 * (r / 3) + (c / 3)];
		int bitsx = bits0 | bits1 | bits2;

		for (int nx = 0; nx < 9; nx++) {
			if ((bitsx & (1 << nx)) != 0) continue;

			grid[r][c] = nx;
			bitsArr[0][r] |= (1 << nx);
			bitsArr[1][c] |= (1 << nx);
			bitsArr[2][3 * (r / 3) + (c / 3)] |= (1 << nx);

			boolean found = search(cnt + 1);
			if (found) {
				return true;
			}

			grid[r][c] = x;
			bitsArr[0][r] = bits0;
			bitsArr[1][c] = bits1;
			bitsArr[2][3 * (r / 3) + (c / 3)] = bits2;
		}

		return false;
	}

}