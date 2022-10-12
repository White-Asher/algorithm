package SSWtest.SWEA.SWEA_4008_Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008_TRY2 {
    static int N;
    static int[] op;
    static int[] num;
    static StringTokenizer st;
    static int ans;
    static int maxVal, minVal;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            op = new int[4];
            num = new int[N];
            ans = 0;

            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            
            DFS(0, num[0]);
            ans = maxVal - minVal;
            System.out.printf("#%d %d\n", t, ans);
            
        }

    }
    
    public static void DFS(int cnt, int sum) {
        if(cnt == N - 1) {
            maxVal = Math.max(maxVal, sum);
            minVal = Math.min(minVal, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
        	if(op[i] > 0) {
        		op[i]--;
        		switch (i) {
        		case 0:
        			DFS(cnt+1, sum + num[cnt+1]);
        			break;
        		case 1:
        			DFS(cnt+1, sum - num[cnt+1]);
        			break;
        		case 2:
        			DFS(cnt+1, sum * num[cnt + 1]);
        			break;
        		case 3:
        			DFS(cnt+1, sum / num[cnt +1]);
        			break;
        		default:
        			break;
        		}
        		op[i]++;
        	}
		}
    }
    
}