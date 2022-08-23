package SWEA.SWNormal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] clientPerm;
	static int[][] client;
	static int N, compX, compY, houseX, houseY, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			input();
			clientPermutation(0,0);
			sb.append("#"+ t+" "+ans+"\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}
	
	public static void calcDistance() {
		int dist = 0;
		dist += Math.abs(compX - client[clientPerm[0]][0]) + Math.abs(compY - client[clientPerm[0]][1]);
		
		for (int i = 0; i < N-1; i++) {
			dist += Math.abs(client[clientPerm[i]][0] - client[clientPerm[i+1]][0]) + Math.abs(client[clientPerm[i]][1] - client[clientPerm[i+1]][1]);
		}

		dist += Math.abs(houseX - client[clientPerm[N-1]][0]) + Math.abs(houseY - client[clientPerm[N-1]][1]);
		
		ans = Math.min(ans, dist);
	}
	
	public static void clientPermutation(int idx, int flag) {
		if(idx == N) {
			calcDistance();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if( (flag & 1 << i) != 0 ) continue;
			clientPerm[idx] = i;
			clientPermutation(idx+1, flag | 1 << i);
		}
	}
	
	public static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		client = new int[N][2];
		clientPerm = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		compX = Integer.parseInt(st.nextToken());
		compY = Integer.parseInt(st.nextToken());
		houseX = Integer.parseInt(st.nextToken());
		houseY = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int clientX = Integer.parseInt(st.nextToken());
			int clientY = Integer.parseInt(st.nextToken());
			client[i][0] = clientX;
			client[i][1] = clientY;
		}
		
	}
}
