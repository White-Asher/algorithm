package SSWtest.SWEA.SWEA_2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SWEA_2382_OtherSol1 {
    static int N,M,K;
    static class micro{
        int x;
        int y;
        int cnt;
        int dir;
        int maxCnt;
         
        public micro(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
            maxCnt=cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            ArrayList<micro> m = new ArrayList<>();
            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                m.add(new micro(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            int meet[][] = new int[N][N];
            while(M-->0) {
                meet = new int [N][N];
                for(int i=0;i<K;i++) {
                    micro mi = m.get(i);
                    switch(mi.dir) {
                    case 1: mi.x-=1; break;
                    case 2: mi.x+=1; break;
                    case 3: mi.y-=1; break;
                    case 4: mi.y+=1; break;
                    }
                    if(mi.x==0 || mi.x==N-1 || mi.y==0 || mi.y==N-1) {
                        mi.cnt/=2;
                        mi.dir = (mi.dir%2==0)?mi.dir-1:mi.dir+1;
                    }
                    mi.maxCnt=mi.cnt;
                    if(meet[mi.x][mi.y]==0) {
                        meet[mi.x][mi.y]=i+1;
                    }else {
                        int idx = meet[mi.x][mi.y]-1;
                        m.get(idx).cnt+=mi.cnt;
                        if(m.get(idx).maxCnt<mi.cnt) {
                            m.get(idx).maxCnt=mi.cnt;
                            m.get(idx).dir=mi.dir;
                        }
                        m.remove(i--);
                        K--;
                    }
                }
            }
            int sum=0;
            for(micro M:m) {
                sum+=M.cnt;
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}