package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 메모리: 119980 KB
 * 실행시간: 828 ms
 * 코드길이: 2194 B
 */
public class BOJ_1753 {
	
	static class Node{
		int vertex, weight;
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int V, E, K;
	static ArrayList<Node>[] list;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		Dijkstra();
		System.out.println(sb);
	}
	
	public static void Dijkstra() {
		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>((v1,v2)-> v1.weight - v2.weight);
		queue.offer(new Node(K, 0));

		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int curVertex = curNode.vertex;
			int curWeight = curNode.weight;
				
				for (int i = 0; i < list[curVertex].size(); i++) {
					int searchVertex = list[curVertex].get(i).vertex;
					int searchDistance = curWeight + list[curVertex].get(i).weight;
					if(distance[searchVertex] > searchDistance) {
						distance[searchVertex] = searchDistance;
						queue.add(new Node(searchVertex, searchDistance));
					}
				}
			
		}

		for (int i = 1; i <= V; i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
	}
	
}
