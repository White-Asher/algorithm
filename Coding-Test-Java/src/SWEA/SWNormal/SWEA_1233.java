package SWEA.SWNormal;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1233 {
	static BufferedReader br;
	static int leaf;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int ans = 1;
			int n = Integer.parseInt(br.readLine());
			
				if(n % 2 == 1) leaf = (n-1) / 2 ;
				else leaf = n / 2;
				for(int i =0; i < leaf; i++) {
					String[] data = br.readLine().split(" ");
					if(!(data[1].equals("*")||data[1].equals("/")||data[1].equals("+")||data[1].equals("-"))) ans = 0;
				}
				for(int i = leaf; i<n;i++) {
					String[] data = br.readLine().split(" ");
					if(data[1].equals("*")||data[1].equals("/")||data[1].equals("+")||data[1].equals("-")) ans = 0;
				}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
//	public static boolean solution(int leaf, int n) throws IOException {
//		for(int i = 1; i <= leaf; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int num = Integer.parseInt(st.nextToken());
//			char c = st.nextToken().charAt(0);
//			if(c != '*' || c != '/' || c != '-' || c != '+') return false;
//			int left = Integer.parseInt(st.nextToken());
//			int right = Integer.parseInt(st.nextToken());
//		}
//		
//		for(int i = leaf+1; i<=n; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int num = Integer.parseInt(st.nextToken());
//			char c = st.nextToken().charAt(0);
//			if(c == '*' || c == '/' || c == '-' || c == '+') return false;
//		}
//		return true;
//	}
}
