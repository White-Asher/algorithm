package SSWtest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5656 {
	static StringTokenizer st;
	static int N, W, H;
	static int[][] map;
	static int[] nums;
	static boolean[] isSelect;
	static int minBrick;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			nums = new int[N];
			map = new int[H][W];
			isSelect = new boolean[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			permu(0);
			int ans = 0;
			System.out.printf("#%d %d", t, ans);
		}
		
	}
	
	public static void simulate() {
		int[][] tempMap = copyMap();
		for (int i = 0; i < nums.length; i++) {
			
			for (int j = H-1; j >=0 ; j--) {
				if(tempMap[j][i] != 0) {
					breakBrick(tempMap[j][i], j, i);
				}
			}
			
			
		}
	}
	public static void breakBrick(int value, int x, int y) {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= value; j++) {
				int nx = x + dx[i] *j;
				int ny = y + dy[i] *j;
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
					
				}
			}
		}
	}
	
	
	
	public static void permu(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(nums));
			simulate();
			return;
		}
		
		for(int i = 0; i < W; i++) {			
			nums[cnt] = i;
			isSelect[cnt] = true;
			permu(cnt+1);
			isSelect[cnt] = false;	
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
