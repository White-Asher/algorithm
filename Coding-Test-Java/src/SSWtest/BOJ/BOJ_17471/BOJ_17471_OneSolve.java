package SSWtest.BOJ.BOJ_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_OneSolve {
	
	static int N;
	static int[] population;
	static StringTokenizer st;
	static int[][] connection;
	static boolean[] select;
	static int ans;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		connection = new int[11][11];
		
		select = new boolean[N];
		ans = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int loop = Integer.parseInt(st.nextToken());
			connection[i][0] = loop;
			for (int j = 1; j <= loop; j++) {
				connection[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		isConnect();
		subset(0);
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
		
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			isConnect();
			return;
		}
		select[cnt] = true;
		subset(cnt+1);
		select[cnt] = false;
		subset(cnt+1);
	}
	
	
	public static void isConnect() {
		
		// 부분집합으로 true false체크한 것 각 선거구 리스트에 구역 번호 넣기
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();

		for (int i = 0; i < select.length; i++) {
			if(select[i]) aList.add(i+1);
			else bList.add(i+1);
		}
		
		// 각 선거구는 최소 한개의 구역을 가지고 있어야 함 -> 둘중에 하나 리스트가 없다면 될 수 없는 조건이므로 리턴.
		if(aList.size() == 0 || bList.size()==0) return;
		
		int startA = aList.get(0);
		int startB = bList.get(0);
		
		boolean[] visited = new boolean[N+1];
		
		// 각 구역이 서로 연결되어 있는지 탐색함
		DFS(startA, visited, aList);
		DFS(startB, visited, bList);
		
//		BFS(startA, visited, aList);
//		BFS(startB, visited, bList);
		
		// 만약 각 구역 연결탐색 후 연결되어 있지 않은 곳이 있다면 해당 구역은 고립된 곳.
		for (int i = 1; i < visited.length; i++) {
			if(visited[i] == false) return; 
		}
		
		calc(aList, bList);
		
 	}
	
	
	private static void BFS(int location, boolean[] visited, List<Integer> list) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(location);
		visited[location] = true;

		while (!queue.isEmpty()) {
			int curLocation = queue.poll();
			// 현재 탐색하는 곳과 연결된 곳 찾기
			int connectSize = connection[curLocation][0];
			for (int i = 1; i <= connectSize; i++) {
				int nextConnect = connection[curLocation][i];
				for (int j = 0; j < list.size(); j++) {
					// 연결되어 있는 곳이고 방문하지 않은곳이면 해당 하는 곳 탐색.
					if (nextConnect == list.get(j) && !visited[nextConnect]) {
						visited[nextConnect] = true;
						queue.add(nextConnect);
					}

				}

			}
		}
	
	}

	public static void DFS(int location, boolean[] visited, List<Integer> list) {
		// 처음 탐색 하는곳 방문 체크
		visited[location] = true;
		
		// 현재 탐색하는 곳과 연결된 곳 찾기
		int connectSize = connection[location][0];
		for (int i = 1; i <= connectSize; i++) {
			// 해당 구역이 연결된 곳
			int nextConnect = connection[location][i];
			// 구역 리스트 돌면서 뽑은 구역이 해당 구역과 연결된 곳인지 확인. 
			for (int j = 0; j < list.size(); j++) {
				// 연결되어 있는 곳이고 방문하지 않은곳이면 해당 하는 곳 탐색.
				if(nextConnect == list.get(j) && !visited[nextConnect]) {
//					visited[nextConnect] = true;
					DFS(nextConnect, visited, list);
				}
			}
			
		}
		
	}
	
	// 각 선거구 최솟값 구하기.
	public static void calc(List<Integer> alist, List<Integer> blist) {
		int aListSum = 0;
		int bListSum = 0;
		
		for (int i = 0; i < alist.size(); i++) {
			int a = alist.get(i);
			aListSum += population[a];
		}

		for (int i = 0; i < blist.size(); i++) {
			int b = blist.get(i);
			bListSum += population[b];
		}
		
		ans = Math.min(ans, Math.abs(aListSum-bListSum));
	}
	
	
}
