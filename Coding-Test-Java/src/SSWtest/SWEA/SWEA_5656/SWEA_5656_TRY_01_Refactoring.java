package SSWtest.SWEA.SWEA_5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_TRY_01_Refactoring {
	
	static StringTokenizer st;
	static int N, W, H;
	static int[][] map;
	static int[] location;
	static int[] dh = {-1,1,0,0};
	static int[] dw = {0,0,-1,1};
	static int ans = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			location = new int[N];
			map = new int[H][W];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			getBallLocation(0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	public static void dropBall() {
		int[][] copyMap = copyMap();

		for (int i = 0; i < location.length; i++) {
			int drop = location[i];
			
			for (int j = 0; j < H; j++) {
				if(copyMap[j][drop] > 0) {
					breakBrick(j, drop, copyMap);
					downBrick(copyMap);
					break;
				}
			}
			

		}
		
		calc(copyMap);
		
	}
	
	public static void breakBrick(int h, int w, int[][] copyMap) {
		int value = copyMap[h][w];
		copyMap[h][w] = 0;
		if(value == 1) return;
		
		
		for (int v = 1; v <= value-1; v++) {
			for (int d = 0; d < 4; d++) {
				int nh = h + dh[d]*v;
				int nw = w + dw[d]*v;
				if(nh < 0 || nw < 0 || nh >= H || nw>= W) continue;
				if(copyMap[nh][nw] == 0) continue;
				breakBrick(nh, nw, copyMap);
			}
		
		}
	}
	
	public static void downBrick(int[][] copyMap) {
		
		for (int w = 0; w < W; w++) {
			Queue<Integer> queue = new ArrayDeque<>();
			for (int h = H-1; h >= 0 ; h--) {
				if(copyMap[h][w] > 0) queue.add(copyMap[h][w]);
				copyMap[h][w] = 0;
			}
			
			for (int h = H-1; h >= 0 ; h--) {
				if(queue.isEmpty()) break;
				copyMap[h][w] = queue.poll();
			}
		}
		
		
	}
	
	public static void calc(int[][] copyMap) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(copyMap[i][j] > 0) cnt++;
			}
		}
		ans = Math.min(cnt, ans);
	}
	
	public static void getBallLocation(int cnt) {
		if(cnt == N) {
			dropBall();
			return;
		}
		
		for (int i = 0; i < W; i++) {
			location[cnt] = i;
			getBallLocation(cnt+1);
		}
	}
	
	public static int[][] copyMap(){
		int[][] temp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}
