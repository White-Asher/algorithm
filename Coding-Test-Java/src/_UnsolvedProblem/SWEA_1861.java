package _UnsolvedProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정사각형 방
public class SWEA_1861 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static StringTokenizer st;
	static int cnt;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] room;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			room = new int[n][n];
			
			for(int i = 0; i<n ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) room[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int startRoom = n*n;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 1;
					int roomVal = room[i][j];
					dfs(room, i, j, roomVal);
					
					if(cnt >= max) {
						if(cnt > max) {
							startRoom = roomVal;
							max = cnt;
						} else {
							if(startRoom > roomVal) startRoom = roomVal;
						}
					}
				}
			}
			sb.append("#"+tc+" ").append(startRoom+" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int[][] room, int x, int y, int curRoom) {
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(0 <= nx && nx < n && 0 <= ny && ny < n && room[nx][ny] == curRoom+1) {
				cnt++;
				dfs(room, nx, ny, curRoom+1);
			}
		}
	}
}
