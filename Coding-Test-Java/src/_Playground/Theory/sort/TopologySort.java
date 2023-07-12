package _Playground.Theory.sort;

import java.io.*;
import java.util.*;

public class TopologySort {
    // 노드의 개수(V)와 간선의 개수(E) 를 나타냄
    // 노드의 개수는 최대 100,000개라고 가정한다.
    static int v, e;
    // 모든 노드에 대한 진입차수는 0으로 초기화한다.
    static int[] indegree = new int[100001];
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    static ArrayList<ArrayList<Integer>> graph =  new ArrayList<>();
    static StringTokenizer st;
    // 입출력, 메인
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end); // 정점 A에서 B로 이동 가능
            // 진입 차수를 1증가한다.
            indegree[end] += 1;
        }

        // 위상정렬
        // 정렬 수행 결과를 담을 리스트
        ArrayList<Integer> result = new ArrayList<>();
        // 큐 라이브러리 사용
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작할 때 진입차수가 0인 노드를 큐에 넣기
        for (int i = 1; i <= v; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복함
        while(!queue.isEmpty()) {
            // 큐애서 원소 꺼내기
            int cur = queue.poll();
            result.add(cur);
            // 해당 원소와 연결된 노드들의 진입차수에서 1빼기
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int target = graph.get(cur).get(i);
                indegree[target] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if(indegree[target] == 0) {
                    queue.offer(target);
                }
            }
        }

        // 위상정렬을 수행한 결과 출력하기
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
/*
input example
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
 */

/*
output
1 2 5 3 6 4 7
 */