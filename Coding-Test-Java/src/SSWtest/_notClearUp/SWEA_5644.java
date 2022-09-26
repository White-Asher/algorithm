package SSWtest._notClearUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5644 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int M, A;
	static int[] personA, personB;
	static int[][] dire = new int[][] {{0,0},{0,-1},{1,0},{0,1},{-1,0}}; // 상-> 우-> 하-> 좌
	static int Ax, Ay, Bx, By;
	static List<BC> bcList;
	static int ans;
	
	static class BC implements Comparable<BC>{
		int x,y,coverage,power;

		public BC(int x, int y, int coverage, int power) {
			super();
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.power = power;
		}

		@Override
		public int compareTo(BC o) {
			return o.power - this.power;
		}
		
		public boolean isCoverage(int userX, int userY) {
			return (Math.abs(this.x - userX) + Math.abs(this.y - userY)) <= coverage;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			inputData();
			flowTime();
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
	
	public static void inputData() throws IOException {

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());

		personA = new int[M];
		personB = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) personA[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) personB[i] = Integer.parseInt(st.nextToken());

		bcList = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			int inputX = Integer.parseInt(st.nextToken());
			int inputY = Integer.parseInt(st.nextToken());
			int inputCoverage = Integer.parseInt(st.nextToken());
			int inputPower = Integer.parseInt(st.nextToken());
			bcList.add(new BC(inputX-1, inputY-1, inputCoverage, inputPower));
		}
		Collections.sort(bcList);
	}
	
	public static void init() { Ax = 0;Ay = 0;Bx = 9;By = 9; }
	
	public static void flowTime() {
		init();
		
		for(int time = 0; time <= M; time++) {
			int max = 0;
	
			ArrayList<Integer> enableA = new ArrayList<>();
			ArrayList<Integer> enableB = new ArrayList<>();
			
			for(int i = 0; i < A; i++) {
				BC bc = bcList.get(i);
				if(bc.isCoverage(Ax, Ay)) enableA.add(i);
				if(bc.isCoverage(Bx, By)) enableB.add(i);
			}
			
			if(!enableA.isEmpty() || !enableB.isEmpty()) {
				if(!enableA.isEmpty() && !enableB.isEmpty()) {
					if(enableA.get(0) == enableB.get(0)) {
						if(enableA.size() >= 2) {
							int Apower = bcList.get(enableA.get(1)).power;
							int Bpower = bcList.get(enableB.get(0)).power;
							max = Math.max(Apower+Bpower, max);
						}
						if(enableB.size() >= 2) {
							int Apower = bcList.get(enableA.get(0)).power;
							int Bpower = bcList.get(enableB.get(1)).power;
							max = Math.max(Apower+Bpower, max);
						}
					}
					else {
						int Apower = bcList.get(enableA.get(0)).power;
						int Bpower = bcList.get(enableB.get(0)).power;
						max = Math.max((Apower+Bpower), max);
					}
				}
				if(!enableA.isEmpty()) max = Math.max(bcList.get(enableA.get(0)).power, max);
				if(!enableB.isEmpty()) max = Math.max(bcList.get(enableB.get(0)).power, max);
				ans += max;
			} 
			if(time == M) continue;
			int aIdx = personA[time];
			int bIdx = personB[time];
			Ax += dire[aIdx][0];
			Ay += dire[aIdx][1];
			Bx += dire[bIdx][0];
			By += dire[bIdx][1];
		}
	}
}
