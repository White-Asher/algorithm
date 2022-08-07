package ps_skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputStringToArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// test01();
		// test02();
		test03();
	}

	public static void test01() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		System.out.println(Arrays.deepToString(map));
	}
	
	public static void test02() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] map = new String[N][N];
		for(int i=0; i<N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = tmp[j];
				}
			}
		System.out.println(Arrays.deepToString(map));
	}
	
	public static void test03() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
			}
		}
		System.out.println(Arrays.deepToString(map));
	}
	
}
