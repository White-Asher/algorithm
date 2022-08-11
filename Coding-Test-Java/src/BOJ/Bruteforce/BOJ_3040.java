package BOJ.Bruteforce;

import java.io.*;

// 메모리: 11492KB / 실행시간: 80ms / 코드길이: 777B
public class BOJ_3040 {
	static final int DWARF_NUM = 9;
	static final int SEVEN_DWARF = 7;
	static int[] pickDwarf, dwarf;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pickDwarf = new int[SEVEN_DWARF];
		dwarf = new int[DWARF_NUM];
		for(int i = 0; i < DWARF_NUM ; i++) dwarf[i] = Integer.parseInt(br.readLine());
		comb(0,0);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == SEVEN_DWARF) {
			int ans = 0;
			for(int i : pickDwarf) ans += i;
			if(ans == 100) for(int j : pickDwarf) System.out.println(j+" ");
			return;
		}
		for (int i = start; i < DWARF_NUM; i++) {
			pickDwarf[cnt] = dwarf[i];
			comb(cnt+1, i+1);
		}
	}
}
