package SSWtest.SWEA.SWEA_2383;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2383 {
	
	static class Stair{
		int x;
		int y;
		int moveTime;
		public Stair(int x, int y, int moveTime) {
			this.x = x;
			this.y = y;
			this.moveTime = moveTime;
		}
		@Override
		public String toString() {
			return "Stair [x=" + x + ", y=" + y + ", moveTime=" + moveTime + "]";
		}
		
	}
	
	static class Human{
		int x;
		int y;
		int distA;
		int distB;
		int outTime;
		
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
		
		
		@Override
		public String toString() {
			return "Human [x=" + x + ", y=" + y + ", distA=" + distA + ", distB=" + distB + ", outTime=" + outTime
					+ "]";
		}
	}

	/*
	 테케 9번 틀리는사람 이거 확인해보세요
	"1층에 최종적으로 도착하자마자 새로운 사람이 계단에 진입할 수 있어요"
	그러니까 1층에 누군가 도착했을 당시 새로운 사람이 진입할 수 있으므로 순간적으로 4명이 계단에 있을 수 있다는 뜻(?) 이에요.
	 */
	static int[][] map;
	static int[] select;
	static StringTokenizer st;
	static List<Stair> stairList;
	static List<Human> humanList;
	static int ans;
	static int cnt;
	
	public static int calDist(int sx, int sy, int hx, int hy) {
		int dist = 0;
		dist = Math.abs(sx -hx) + Math.abs(sy - hy);
		return dist;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("C:\\Users\\dkxmp\\Documents\\GithubStore\\algorithm\\Coding-Test-Java\\src\\SSWtest\\SWEA\\swea_2383.txt"));
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
			
			// 3 명 계단 -> 후발주자 계단도착 (기다림) 
			
//			for (Human human : humanList) {
//				System.out.println(human);
//			}
//			
//			for (Stair s : stairList) {
//				System.out.println(s);
//			}
			DFS(0);
			System.out.printf("#%d %d\n",t,ans);

		}
	}
	public static List<Human> copyHumanList(){
		List<Human> temp = new ArrayList<>();
		for (int i = 0; i < humanList.size(); i++) {
			Human t = humanList.get(i);
			int x = t.x;
			int y = t.y;
			int distA = t.distA;
			int distB = t.distB; 
			int outTime = t.outTime;
			temp.add(new Human(x,y,distA,distB,outTime));
		}
		return temp;
		
	}
	
	public static int simulate() {
		LinkedList<Human> aHumanList = new LinkedList<Human>();
		LinkedList<Human> bHumanList = new LinkedList<Human>();

		List<Human> aStairQueue = new ArrayList<>();
		List<Human> bStairQueue = new ArrayList<>();
		
		List<Human> copyList = copyHumanList();
//		 select = new int[] {1, 2, 2, 1, 2, 2, 1};
//		System.out.println(Arrays.toString(select) + ": "+select.length);
		
		for (int i = 0; i < select.length; i++) {
			if(select[i] == 1) {
				aHumanList.add(copyList.get(i));
			} else if(select[i] == 2) {
				bHumanList.add(copyList.get(i));
			}
		}
		
		Collections.sort(aHumanList, (o1, o2) -> (o1.distA - o2.distA));
		Collections.sort(bHumanList, (o1, o2) -> (o1.distB - o2.distB));
//		for (Human human : aHumanList) {
//			System.out.print(human+" ");
//		}
//		System.out.println();
//		
//		for (Human human : bHumanList) {
//			System.out.print(human + " ");
//		}
		
		// a계단
		int aTime = 0;
		while(! (aHumanList.isEmpty() && aStairQueue.isEmpty()) ) {
			// 해당 시간이 되면 계단 큐에서 사람 빼기
			while(!aStairQueue.isEmpty()) {
				Human aStairQ = aStairQueue.get(0);
				if(aTime >= aStairQ.outTime) {
					aStairQueue.remove(0);
				} else {
					break;
				}
			}
			
			if(aHumanList.size() == 0 && aStairQueue.size()==0) {
				break;
			}
			
			// 계단에 사람 넣기 
			while(true) {
				if(aHumanList.size() == 0) break;
				
				Human q = aHumanList.peek();
				if(q.distA != aTime) break;
				// 계단에 3명 이하라면 계단 리스트에 넣기
				if(aStairQueue.size() < 3) {
					q.outTime = aTime + stairList.get(0).moveTime;
					aStairQueue.add(aHumanList.poll());
				} 
				// 계단 3명 이상이면 계단 리스트에 넣지말고 대기하기

				else  {
					for (int i = 0; i < aHumanList.size(); i++) {
						Human temp = aHumanList.get(i);
//						temp.distA++;
						if(temp.distA < aStairQueue.get(0).outTime) {
							temp.distA = aStairQueue.get(0).outTime;
							continue;
						}
					}
				}
			}
//			System.out.println("aTime: + "+aTime + "| aStairQueue: "+aStairQueue.size());
//			if(aHumanList.isEmpty() && aStairQueue.size() == 1) {
//				aResultTime = aStairQueue.get(0).outTime;
//			}
			aTime++;
		}
		
		//b계단
		int bTime = 0;
		while(! (bHumanList.isEmpty() && bStairQueue.isEmpty()) ) {
			// 해당 시간이 되면 계단 큐에서 사람 빼기
			while(!bStairQueue.isEmpty()) {
				Human bStairQ = bStairQueue.get(0);
				if(bTime >= bStairQ.outTime) {
					bStairQueue.remove(0);
				} else {
					break;
				}
			}
			
			if(bHumanList.size() == 0 && bStairQueue.size()==0) {
				break;
			}
			
			// 계단에 사람 넣기 
			while(true) {
				if(bHumanList.size() == 0)break;
				
				Human q = bHumanList.peek();
				if(q.distB != bTime) break;
				// 계단에 3명 이하라면 계단 리스트에 넣기
				if(bStairQueue.size() < 3) {
					q.outTime = bTime + stairList.get(1).moveTime;
					bStairQueue.add(bHumanList.poll());
				} 
				// 계단 3명 이상이면 계단 리스트에 넣지말고 대기하기 
				else {
					for (int i = 0; i < bHumanList.size(); i++) {
						Human temp = bHumanList.get(i);
//						temp.distB++;
						if(temp.distB < bStairQueue.get(0).outTime) {
							temp.distB = bStairQueue.get(0).outTime;
							continue;
						}
					}
				}
			}
//			System.out.println("bTime: + "+bTime + "| bStairQueue: "+bStairQueue.size());
//			if(bHumanList.isEmpty() && bStairQueue.size() == 1) {
//				bResultTime = bStairQueue.get(0).outTime;
//			}
			bTime++;

		}
//		System.out.println(Arrays.toString(select));
//		System.out.println(Math.max(aTime, bTime));
		return Math.max(aTime, bTime); 
		
	}
	
	// a, b 계단 사용자 나누기
	public static void DFS(int index) {
		if(index == humanList.size()) {
//			int time = simulate();
//			System.out.println(time);
//			if(time != 0) {
			
			ans = Math.min(simulate(), ans);
			// a b 
//			}2^7 = 128...
			return;
		}
		select[index] = 1;
		DFS(index+1);
		select[index] = 2;
		DFS(index+1);
	}
}