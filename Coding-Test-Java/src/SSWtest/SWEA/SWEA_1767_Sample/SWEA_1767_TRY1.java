package SSWtest.SWEA.SWEA_1767_Sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767_TRY1 {
	static int N;
	static StringTokenizer st;
	static int map[][];
	
	static class Cell{
		int x,y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	static List<Cell> cellList;
	static int ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int maxCoreNum;
	static int minLength;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			cellList = new ArrayList<>();
			map = new int[N][N];
			// 셀 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(!(i==0 || i==N-1|| j == 0 || j==N-1)) {
							cellList.add(new Cell(i, j));
						}						
					}
				}
			}
			maxCoreNum = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			DFS(0,0,0);
			System.out.printf("#%d %d\n", t, minLength);
		}
		
	}// main end
	
	public static void DFS(int index, int length, int coreNum) {
		// 끝까지 탐색
		
	if(index == cellList.size()) {
			
			// 크거나 같을 때 최대값 갱신시
			if(coreNum >= maxCoreNum) {
				// 크다면
				if(coreNum > maxCoreNum) {
					maxCoreNum = coreNum;
					minLength = length;
				}
				
				// 개수 만 같으면 (길이 가장짧은 것 비교)
				if(coreNum == maxCoreNum) {
					if(minLength > length) {
						minLength = length;
					}
				}
			}
			return;
		}
	
		
		Cell curCell = cellList.get(index);
		int curX = curCell.x;
		int curY = curCell.y;
		
		for (int d = 0; d < 4; d++) {

			int nx = curX;
			int ny = curY;
			// 해당 좌표부터 놓을 수 있는지 검사한다. 
			int count = 0;
			while(true) {
				nx += dx[d];
				ny += dy[d];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
				if(map[nx][ny] == 1 || map[nx][ny] == 2) {
					count = 0;
					break;
				}
				count++;
			}
			
			// 놓을 수 없음 
			if(count == 0) DFS(index + 1, length, coreNum);
			// 놓을 수 있다면?
			else {
				int lineX = curX;
				int lineY = curY;
				// 전선 놓기
				for (int i = 0; i < count; i++) {
					lineX += dx[d];
					lineY += dy[d];
					map[lineX][lineY] = 2;
				}
				DFS(index + 1, length + count, coreNum + 1);
				// 전선 회수
				lineX = curX;
				lineY = curY;
				for (int i = 0; i < count; i++) {
					lineX += dx[d];
					lineY += dy[d];
					map[lineX][lineY] = 0;
				}
			}
			
			
		}
		
		
		
	}
}
