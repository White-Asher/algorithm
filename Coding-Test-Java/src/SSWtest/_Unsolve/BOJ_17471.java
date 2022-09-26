package SSWtest._Unsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {

	static int N;
	static int[] population, election;
	static ArrayList<Integer>[] cityList;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		cityList = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cityList[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				cityList[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		election = new int[N + 1];
		subset(0);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	// 부분집합 구하기
	public static void subset(int idx) {
		if (idx == N + 1) {
			visited = new boolean[N + 1];
			int linkCnt = 0;

			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					bfs(i, election[i]);
					linkCnt++;
				}
			}

			// 지역이 2개 인것 확인, 2개의 지역안에서 서로 연결되어 있다면 각 구역의 합을 구하고 두 구역 차의 최소값 계산
			if (linkCnt == 2) {
				int area1 = 0;
				int area2 = 0;
				for (int i = 1; i <= N; i++) {
					if (election[i] == 1)
						area1 += population[i];
					else
						area2 += population[i];
				}
				min = Math.min(min, Math.abs(area1 - area2));
			}

			return;
		}

		election[idx] = 1;
		subset(idx + 1);
		election[idx] = 2;
		subset(idx + 1);
	}

	public static void bfs(int startCityNum, int electionLocationNum) {
		Queue<Integer> queue = new LinkedList<>();
		visited[startCityNum] = true;
		queue.offer(startCityNum);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < cityList[current].size(); i++) {
				int nextCity = cityList[current].get(i);
				if (election[nextCity] == electionLocationNum && !visited[nextCity]) {
					queue.offer(nextCity);
					visited[nextCity] = true;
				}
			}
		}
	}
}
