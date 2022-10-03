package SSWtest.SWEA.SWEA_2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2383_Refactoring_Submit {

	static class Stair{
		int x, y, moveTime;
		public Stair(int x, int y, int moveTime) {
			this.x = x;
			this.y = y;
			this.moveTime = moveTime;
		}
	}
	
	static class Human{
		int x, y, distA, distB, outTime;
		public Human(int x, int y) {
			this.x = x;
			this.y = y;
			this.distA = 0;
			this.distB = 0;
		}
		public Human(int x, int y, int distA, int distB, int outTime) {
			this.x = x;
			this.y = y;
			this.distA = distA;
			this.distB = distB;
			this.outTime = outTime;
		}
		
	}

	static int[][] map;
	static int[] select; 
	static StringTokenizer st;
	static List<Stair> stairList; 
	static List<Human> humanList;
	static int ans;

	public static int calDist(int sx, int sy, int hx, int hy) {
		int dist = 0;
		dist = Math.abs(sx -hx) + Math.abs(sy - hy);
		return dist;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			stairList = new ArrayList<>();
			humanList = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >= 2) {
						stairList.add(new Stair(i, j, map[i][j]));						
					} else if(map[i][j] == 1) {
						humanList.add(new Human(i, j));
					}
				}
			}

			ans = Integer.MAX_VALUE;
			select = new int[humanList.size()];
			for (int i = 0; i < humanList.size(); i++) {
				int hx = humanList.get(i).x;
				int hy = humanList.get(i).y;
				humanList.get(i).distA = (calDist(stairList.get(0).x, stairList.get(0).y, hx, hy) + 1);
				humanList.get(i).distB = (calDist(stairList.get(1).x, stairList.get(1).y, hx, hy) + 1);
			}
			
			DFS(0);
			System.out.printf("#%d %d\n",t,ans);

		}
	}
	
	public static List<Human> copyHumanList(){
		List<Human> temp = new ArrayList<>();
		for (int i = 0; i < humanList.size(); i++) {
			Human t = humanList.get(i);
			temp.add(new Human(t.x, t.y, t.distA, t.distB, t.outTime));
		}
		return temp;
	}
	
	public static int simulate() {
		LinkedList<Human> aHumanList = new LinkedList<Human>(); 
		LinkedList<Human> bHumanList = new LinkedList<Human>();

		List<Human> aStairList = new ArrayList<>();
		List<Human> bStairList = new ArrayList<>();
		List<Human> copyList = copyHumanList();
		
		for (int i = 0; i < select.length; i++) {
			if(select[i] == 1) {
				aHumanList.add(copyList.get(i));
			} else if(select[i] == 2) {
				bHumanList.add(copyList.get(i));
			}
		}

		Collections.sort(aHumanList, (o1, o2) -> (o1.distA - o2.distA)); 
		Collections.sort(bHumanList, (o1, o2) -> (o1.distB - o2.distB));
		
		int aTime = 0;
		while(true) {
			while(!aStairList.isEmpty()) {
				Human aStairQ = aStairList.get(0);
				if(aTime >= aStairQ.outTime) {
					aStairList.remove(0);
				} else {
					break;
				}
			}
			if(aHumanList.size() == 0 && aStairList.size()==0) break;
			
			while(true) {
				if(aHumanList.size() == 0) break;
				Human q = aHumanList.peek();
				if(q.distA != aTime) break;
				if(aStairList.size() < 3) {
					q.outTime = aTime + stairList.get(0).moveTime;
					aStairList.add(aHumanList.poll());
				} 
				else  {
					for (int i = 0; i < aHumanList.size(); i++) {
						Human temp = aHumanList.get(i);
						if(temp.distA < aStairList.get(0).outTime) {
							temp.distA = aStairList.get(0).outTime;
							continue;
						}
					}
				}
			}
			aTime++;
		}
		
		int bTime = 0;
		while(! (bHumanList.isEmpty() && bStairList.isEmpty()) ) {
			while(!bStairList.isEmpty()) {
				Human bStairQ = bStairList.get(0);
				if(bTime >= bStairQ.outTime) {
					bStairList.remove(0);
				} else {
					break;
				}
			}
			
			if(bHumanList.size() == 0 && bStairList.size()==0) break;
			
			while(true) {
				if(bHumanList.size() == 0) break;
				
				Human q = bHumanList.peek();
				if(q.distB != bTime) break;
				if(bStairList.size() < 3) {
					q.outTime = bTime + stairList.get(1).moveTime;
					bStairList.add(bHumanList.poll());
				} 
				else {
					for (int i = 0; i < bHumanList.size(); i++) {
						Human temp = bHumanList.get(i);
						if(temp.distB < bStairList.get(0).outTime) {
							temp.distB = bStairList.get(0).outTime;
							continue;
						}
					}
				}
			}
			bTime++;
		}
		return Math.max(aTime, bTime); 
	}
	
	public static void DFS(int index) {
		if(index == humanList.size()) {
			ans = Math.min(simulate(), ans);
			return;
		}
		select[index] = 1;
		DFS(index+1);
		select[index] = 2;
		DFS(index+1);
	}
}
