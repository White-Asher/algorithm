package SSWtest.BOJ.BOJ_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_TRY1 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static class CCTV{
		int x, y, type;

		public CCTV(int x, int y, int type) {

			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	static List<CCTV> cctvList;
	// 상좌하우
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] select;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = Integer.MAX_VALUE;
		
		cctvList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					cctvList.add(new CCTV(i,j, map[i][j]));
				}
			}
		}
		select = new int[cctvList.size()];
		
		getCCTV(0);
		System.out.println(ans);
		
	}

	private static void getCCTV(int cnt) {
		if(cnt == cctvList.size()) {
//			System.out.println(Arrays.toString(select));
			simulate();
			return;
		}
		for (int i = 0; i < 4; i++) {
			select[cnt] = i;
			getCCTV(cnt+1);
		}
		
	}
	
	// 경우의 수 시뮬레이션 
	public static void simulate() {
		// CCTV 방향 하나씩 뽑기 
		int[][] copyMap = copyMap();
		for (int index = 0; index < select.length; index++) {
			int curType = cctvList.get(index).type;
			int curX = cctvList.get(index).x;
			int curY = cctvList.get(index).y;
			int curDire = select[index];
			
			// 상0 좌1 하2 우3
			switch (curType) {
			
			case 1: // 우
				checkArea(curX, curY, curDire, copyMap);
				break;
			case 2: // 좌, 우
				checkArea(curX, curY, curDire, copyMap);
				checkArea(curX, curY, (curDire + 2) % 4, copyMap);
				break;
			case 3: // 상, 우
				checkArea(curX, curY, curDire, copyMap);
				checkArea(curX, curY, (curDire + 1) % 4, copyMap);
				break;
			case 4: // 좌, 상, 우
				checkArea(curX, curY, curDire, copyMap);
				checkArea(curX, curY, (curDire + 1) % 4, copyMap);
				checkArea(curX, curY, (curDire + 2) % 4, copyMap);
				break;
			case 5: // 상, 하, 좌, 우
				checkArea(curX, curY, curDire, copyMap);
				checkArea(curX, curY, (curDire + 1) % 4, copyMap);
				checkArea(curX, curY, (curDire + 2) % 4, copyMap);
				checkArea(curX, curY, (curDire + 3) % 4, copyMap);
				break;
			default:
				break;
			}

		}
		calc(copyMap);
		
	}
	
	public static void checkArea(int x, int y, int dire, int[][] copyMap) {
		int length = 1;
		while(true) {
			int nx = x + dx[dire] * length; 
			int ny = y + dy[dire] * length;
			length++;
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || copyMap[nx][ny] == 6) break;
			if(copyMap[nx][ny] != 0) continue;
			copyMap[nx][ny] = 9;
		}
//		while(true) {
//			x += dx[dire];
//			y += dy[dire];
//			if(x < 0 || x >= N || y < 0 || y >= M || copyMap[x][y] == 6) break;
//			if(copyMap[x][y] != 0 ) continue;
//			copyMap[x][y] = 9;
//		}
		
	}
	
	// 사각 지대 구하기
	public static void calc(int[][] copyMap) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					sum++;
				}
			}
		}
		ans = Math.min(ans, sum);
	}
	
	
	public static int[][] copyMap(){
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
}
