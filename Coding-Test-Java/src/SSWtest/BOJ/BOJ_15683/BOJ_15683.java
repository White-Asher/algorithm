package SSWtest.BOJ.BOJ_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
	
	public static class CCTV{
		int r;
		int c;
		int type;
		
		public CCTV(int r, int c, int type){
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	static int N, M;
	static StringTokenizer st;
	static int[][] map;
	static int[] cctvCase;
	static List<CCTV> cctv;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}}; //상 우 하 좌
	static int minBlindArea;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		duplicatePermutation(0);
		System.out.println(minBlindArea);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp >= 1 && temp <= 5) {
					cctv.add(new CCTV(i,j,temp));
				}
			}
		}
		cctvCase = new int[cctv.size()];
		minBlindArea = Integer.MAX_VALUE;
	}
	
	public static void duplicatePermutation(int cnt) {
		if(cnt == cctv.size()) {
			searchBlindArea();
			return;
		}
		for (int i = 0; i < 4; i++) {
			cctvCase[cnt] = i;
			duplicatePermutation(cnt+1);
		}
	}
	
	
	public static void searchBlindArea() {
		int[][] tempMap = copyMap();
		
		for(int i = 0; i < cctv.size(); i++) {
			int cr = cctv.get(i).r;
			int cc = cctv.get(i).c;
			int direction = cctvCase[i];

			switch (cctv.get(i).type) {
			case 1:
				tempMap = checkBlindArea(direction, tempMap, cr, cc);
				break;
			case 2:
				tempMap = checkBlindArea(direction, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+2) % 4, tempMap, cr, cc);
				break;
			case 3:
				tempMap = checkBlindArea(direction, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+1) % 4, tempMap, cr, cc);
				break;
			case 4:
				tempMap = checkBlindArea(direction, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+1) % 4, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+2) % 4, tempMap, cr, cc);
				break;
			case 5:
				tempMap = checkBlindArea(direction, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+1) % 4, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+2) % 4, tempMap, cr, cc);
				tempMap = checkBlindArea((direction+3) % 4, tempMap, cr, cc);
				break;
			}
		}
		countBlindArea(tempMap);
	}
	
	public static int[][] copyMap() {
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		return tempMap;
	}
	
	public static int[][] checkBlindArea(int dire, int[][] tempMap, int r, int c) {
		while(true) {
			r += delta[dire][0];
			c += delta[dire][1];
			if(r < 0 || r >= N || c < 0 || c >= M || tempMap[r][c] == 6) break;
			if(tempMap[r][c] != 0) continue;
			tempMap[r][c] = 9;
			
		}
		return tempMap;
	}
	
	public static void countBlindArea(int[][] tempMap) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tempMap[i][j] == 0) cnt++;
			}
		}
		minBlindArea = Math.min(minBlindArea, cnt);
	}
}
