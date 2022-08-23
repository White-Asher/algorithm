package BOJ.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1168_WrongWay {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		sb.append("<");
		int idx = 0;
		for (int i = 0; i < N - 1; i++) {
			idx += K;
			idx = (idx-1) % list.size();
			sb.append(list.remove(idx)+", ");
		}
		sb.append(list.remove(0)+">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
