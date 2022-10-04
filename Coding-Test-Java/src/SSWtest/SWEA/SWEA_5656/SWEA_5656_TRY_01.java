package SSWtest.SWEA.SWEA_5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_TRY_01 {
	
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
//			dropBall();
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	public static void dropBall() {
		int[][] copyMap = copyMap();
		
//		location = new int[]{2,2,6};
	
//		System.out.println(Arrays.toString(location));
//		System.out.println("====init=====");
//		for (int j = 0; j < H; j++) {
//			for (int j2 = 0; j2 < W; j2++) {
//				System.out.print(copyMap[j][j2]+" ");
//			}
//			System.out.println();
//		}
		
		
		
		
		for (int i = 0; i < location.length; i++) {
			int drop = location[i];
			
			for (int j = 0; j < H; j++) {
				if(copyMap[j][drop] > 0) {
					breakBrick(j, drop, copyMap);
//					System.out.println("j :" +j+" drop : "+drop);
					break;
				}
			}
			
//			System.out.println("====break=====");
//			for (int j = 0; j < H; j++) {
//				for (int j2 = 0; j2 < W; j2++) {
//					System.out.print(copyMap[j][j2]+" ");
//				}
//				System.out.println();
//			}
			
			downBrick(copyMap);
			
//			System.out.println("====down=====");
//			for (int j = 0; j < H; j++) {
//				for (int j2 = 0; j2 < W; j2++) {
//					System.out.print(copyMap[j][j2]+" ");
//				}
//				System.out.println();
//			}
		}
		
		calc(copyMap);
		
	}
	
	public static void breakBrick(int h, int w, int[][] copyMap) {
		int value = copyMap[h][w];
		copyMap[h][w] = 0;
		
		for (int v = 1; v <= value-1; v++) {
			for (int d = 0; d < 4; d++) {
				int nh = h + dh[d]*v;
				int nw = w + dw[d]*v;
				if(nh < 0 || nw < 0 || nh >= H || nw>= W) continue;
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
//			System.out.println(Arrays.toString(location));
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
