package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int N, M, R;
	static int[][] arr;
	static int[][] answer;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int r = 0; r < R; r++) {
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1: switchUpDown();	break;
			case 2: switchLeftRight(); break;
			case 3: rightRotate(); break;
			case 4: leftRotate(); break;
			case 5: moveForward(); break;
			case 6: moveReverse(); break;
			default: break;
			}
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	public static void switchUpDown() {
		answer = new int[N][M];
		for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) answer[N-i-1][j] = arr[i][j];
		arr = answer;
	}
	
	public static void switchLeftRight() {
		answer = new int[N][M];
		for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) answer[i][M-j-1] = arr[i][j];
		arr =  answer;
	}
	
	public static void rightRotate() {
		answer = new int[M][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) answer[j][i] = arr[N-i-1][j];
		swapNM();
		arr = answer;
	}
	
	public static void leftRotate() {
		answer = new int[M][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) answer[j][i] = arr[i][M-j-1];
		swapNM();
		arr = answer;
	}
	
	public static void moveForward() {
		int midN = N/2;
		int midM = M/2;
		answer = new int[N][M];
		for(int i = 0; i < midN; i++) {
			for(int j = 0; j < midM; j++) {
				answer[i][j]           = arr[i+midN][j];
				answer[i][j+midM]      = arr[i][j];
				answer[i+midN][j+midM] = arr[i][j+midM];
				answer[i+midN][j]      = arr[i+midN][j+midM];
			}
		}
		arr = answer;
	}
	
	public static void moveReverse() {
		int midN = N/2;
		int midM = M/2;
		answer = new int[N][M];
		for(int i = 0; i < midN; i++) {
			for(int j = 0; j < midM; j++) {
				answer[i][j]           = arr[i][j+midM];
				answer[i][j+midM]      = arr[i+midN][j+midM];
				answer[i+midN][j+midM] = arr[i+midN][j];
				answer[i+midN][j]      = arr[i][j];
			}
		}
		arr = answer;
	}
	
	public static void swapNM() {
		int temp = N;
		N = M;
		M = temp;
	}
}