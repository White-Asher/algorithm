package BOJ.Stack;

import java.io.*;
import java.util.*;

public class BOJ_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 총 건물 수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 건물 높이와, 건물 위치를 넣을 스택 선언
		Stack<Integer> valStack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 건물 하나씩 입력 받으면서 
			int next = Integer.parseInt(st.nextToken());
			
			// 스택이 비어있지 않을 때 까지 반복
			while(!valStack.isEmpty()) {
				if(valStack.peek() >= next) { // 건물 높이 스택 최상단의 값이 비교하려는 건물보다 높으면 
					sb.append(idxStack.peek()+" "); // 해당 건물의 위치를 sb에 추가
					break;
				}
				// 건물높이 스택 최상단의 값이 비교하려는 건물보다 낮으면 pop연산 수행
				valStack.pop();
				idxStack.pop();
			}
			
			// 스택이 비어있다면 0을 sb에 추가
			if(valStack.isEmpty()) {
				sb.append("0 ");
			}

			valStack.push(next);
			idxStack.push(i);
			
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}
}
