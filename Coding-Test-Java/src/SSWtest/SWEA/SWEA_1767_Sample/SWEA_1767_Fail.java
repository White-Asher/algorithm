package SSWtest.SWEA.SWEA_1767_Sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// start 1:21
// 문제에서 구하려는 것 최대한 코어를 연결했을 때 그 때의 전선 길이가 가장 짧은 값을 구하시오

public class SWEA_1767_Fail {
	static int N;
	static int[][] map;
	static StringTokenizer st;
	static class Core{
		int y, x;
		public Core(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Core [y=" + y + ", x=" + x + "]";
		}
		
		
	}
	// 상0, 하1, 좌2, 우3
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static List<Core> coreList;
	static int minLength;
	static int maxCore;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			minLength = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(!(i==0 || i==N-1|| j == 0 || j==N-1)) {
							coreList.add(new Core(i, j));
						}						
					}
				}
			}
			
			DFS(0,0,0);
			System.out.printf("#%d %d\n", t, minLength);
		}
	}
	

	public static void DFS(int totalLength, int coreIndex, int connectCoreNum) {

		// 마지막 코어 전부 다 돌면 비교함.
		if(coreIndex == coreList.size()) {
			
			// 크거나 같을 때 최대값 갱신시
			if(connectCoreNum >= maxCore) {
				// 크다면
				if(connectCoreNum > maxCore) {
					maxCore = connectCoreNum;
					minLength = totalLength;
				}
				
				// 개수 만 같으면 (길이 가장짧은 것 비교)
				if(connectCoreNum == maxCore) {
					if(minLength > totalLength) {
						minLength = totalLength;
					}
				}
			}
			return;
		}
		
		Core curCore = coreList.get(coreIndex);
		int y = curCore.y;
		int x = curCore.x;

		// 코어 한개의 경우 수 ( 상, 하, 좌, 우)
		for (int d = 0; d < 4 ; d++) {
			// 길이 s
			int length = 0;
			int ny = y;
			int nx = x;
			
			// 모서리까지 연결할 수 있는지 확인하고 그때의 길이를 세기
			while(true) {
				length++;
				
				ny = y + dy[d] * length;
				nx = x + dx[d] * length;
				
				// 맵 밖으로 나가면 중지 
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) {
					length -= 1;
					break;
				}
				// 탐색 중에 코어, 선을 만났다면 중지 
				if(map[ny][nx] == 1 || map[ny][nx] == 2) {
					length = -1;
					break;
				}
				
			} //while end

			// 길이가 s가  0이면 어떤 경우에도 전선을 연결할 수 없음.
			if(length == -1) DFS(totalLength, coreIndex+1, connectCoreNum);
			
			// 전선을 연결할 수 있는 경우
			else {
				// 전선 놓기
				int lineY = y;
				int lineX = x;
				for(int i = 1; i < length; i++) {
					lineY = y + dy[d] * length;
					lineX = x + dx[d] * length;
					map[lineY][lineX] = 2;
				}
				
				DFS(totalLength + length, coreIndex + 1, connectCoreNum + 1);
				// 전선 되돌리기
				for(int i = 1; i < length; i++) {
					lineY = y + dy[d] * length;
					lineX = x + dx[d] * length;
					map[lineY][lineX] = 0;
				}
				
			} // else end
		
		} // for-loop d end 
		
	}
}
