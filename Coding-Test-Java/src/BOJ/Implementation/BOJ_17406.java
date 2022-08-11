package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int N, M, K, R, C, S;
	static int[][] arr;
	static StringTokenizer st;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] nums;
	static int[][] map;
	static int[] numSequence;
	static boolean[] isSelect;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		min = 100000000;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		nums = new int[K][3];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<3; i++) nums[k][i] = Integer.parseInt(st.nextToken());
		}
		numSequence = new int[K];
		isSelect = new boolean[K+1];
		permutation(0);
		System.out.println(min);
	}
	
    public static void permutation(int cnt) {
    	if(cnt == K) {
    		map = new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					map[j][j2] = arr[j][j2];
				}
			}
			
    		for(int i = 0; i < numSequence.length; i++) {
    			R = nums[numSequence[i]][0];
				C = nums[numSequence[i]][1];
				S = nums[numSequence[i]][2];
				rotate(R, C, S);
    		}
    		for (int i = 0; i < N; i++) {
    			int temp = 0;
    			for (int j = 0; j < M; j++) {
    				temp += map[i][j];
    			}
    			if(temp <= min) min = temp;
    		}
    		return;
    	}
    	
    	for (int i = 0; i < K; i++) {
			if(isSelect[i]) continue;
			numSequence[cnt] = i;
			isSelect[i] = true; 
			permutation(cnt+1); 
			isSelect[i] = false; 
		}
    }
	
	
	public static void rotate(int r, int c, int s) {
		for(int i = 0; i < s; i++) {
			int x = r-s+i-1;
			int y = c-s+i-1;
			
			int temp = map[x][y];
			int dire = 0;
			
			while(dire < 4) {
				int nx = x + dx[dire];
				int ny = y + dy[dire];
				
				if (nx >= r-s+i-1 && nx < r+s-i && ny >= c-s+i-1 && ny < c+s-i) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				} else {
					dire++;
				}
			}
			map[r-s+i-1][c-s+i] = temp;
		}
	}
}
