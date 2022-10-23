package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
	static final int SIZE = 5;
	public static void main(String[] args) throws IOException {
		int[][] bingoBoard = new int[SIZE][SIZE];
		int[] num = new int[SIZE*SIZE];
		
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				bingoBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int index = 0;
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				num[index++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for (int i = 0; i < num.length; i++) {
			
			for (int j = 0; j < SIZE; j++) {
				for (int j2 = 0; j2 < SIZE; j2++) {
					if(bingoBoard[j][j2] == num[i]) {
						bingoBoard[j][j2] = 0;
					}
				}
			}
			
			if(checkBingo(bingoBoard)) {
				ans = i;
				break;
			}
		}
		System.out.println(ans+1);
	}
	
	public static boolean checkBingo(int[][] bingoBoard) {
		int bingCnt = 0;
		
		// 가로빙고 체크
		for (int i = 0; i < SIZE; i++) {
			boolean flag = true;
			for (int j = 0; j < SIZE; j++) {
				if(bingoBoard[i][j] != 0) {
					flag = false;
				}
			}
			if(flag) {
				bingCnt++;
			}
		}
		
		//세로 빙고 체크
		for (int i = 0; i < SIZE; i++) {
			boolean flag = true;
			for (int j = 0; j < SIZE; j++) {
				if(bingoBoard[j][i] != 0) {
					flag = false;
				}
			}
			if(flag) {
				bingCnt++;
			}
			
		}
		
		boolean flag = true;	
		// 대각 빙고 체크 좌하
		for (int i = 0; i < SIZE; i++) {
			if(bingoBoard[i][i] != 0) {
//				System.out.println(bingoBoard[i][i]);
				flag = false;
			}
		}
		if(flag) {
			bingCnt++;
		}
		
		// 대각 빙고 체크 우하
		flag = true;	
		for (int i = 0; i < SIZE; i++) {
			if(bingoBoard[SIZE-1 - i][i] != 0) {
				flag = false;
			}
		}
		if(flag) bingCnt++;
		
		return bingCnt >= 3;
	}
}
