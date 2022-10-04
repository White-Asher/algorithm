package BOJ.Implementation.BOJ_2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239_FIrst {
	static final int SIZE = 9; 
	static int[][] map;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 데이터 입력
		map = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			String input = br.readLine();
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		
		DFS(0,0);
	}

	private static void DFS(int y, int x) throws IOException {
		// x좌표 끝까지 이동하면 다음 y좌표 이동
		if(x == SIZE) {
			y++;
			DFS(y, 0);
			return;
		}
		
		// 끝까지 완료했다면 출력후 종료
		if (y == SIZE) {
			mapOut();
		}
		
		// 빈칸일 때
		if(map[y][x] == 0) {
			// 값 1부터 9까지 넣어보기
			for (int i = 1; i <= SIZE; i++) {
				
				// 입력할 수 있는지 체크
				if(check(y,x,i)) {
					map[y][x] = i; // 해당 값 넣고 탐색 
					DFS(y, x+1);
				}
			}
			// 원복
			map[y][x] = 0;
			return;
		} else if(map[y][x] != 0) {
			// 빈칸이 아니라면 다음 x좌표 탐색
			DFS(y, x+1);
		}
		
	}
	
	// y좌표, x좌표, 대입해 볼 값  파라미터로 입력
	public static boolean check(int y, int x, int val) {
		
		// 박스체크
		int yArea = y/3;
		int xArea = x/3;
		for (int i = yArea*3; i < 3 + yArea*3; i++) {
			for (int j = xArea*3; j < 3 + xArea*3; j++) {
				if(map[i][j] == val) return false;
			}
		}
		
		// 가로체크
		for (int i = 0; i < SIZE; i++) {
			if(map[y][i] == val) return false;
		}
		
		// 세로체크
		for (int i = 0; i < SIZE; i++) {
			if(map[i][x] == val) return false;
		}
		
		// 위 세 조건을 전부 통과한다면 넣을 수 있는 값이므로 return
		return true;
	}
	
	// 출력
	public static void mapOut() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		System.exit(0);
	}
	
}
