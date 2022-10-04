package SSWtest.SWEA.SWEA_5656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA_5656_FAST_01{
    static int[][] map;
    static int n,w,h;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static int answer;
    static Queue<int[]> q = new ArrayDeque<int[]>();
    static boolean inRange(int a,int b) {
        if(a<0||a>=h||b<0||b>=w)
            return false;
        return true;
    }
    static int gravity() {
        int dif;
        int cnt = 0;
        int temp;
        for(int j = 0;j<w;j++) {
            dif = 0;
            for(int i = h-1;i>=0;i--) {
                if(map[i][j]==0)
                    dif++;
                else {
                    temp = map[i][j];
                    map[i][j] = 0;
                    map[i+dif][j] = temp;
                    cnt++;
                }
            }
        }
        return cnt;
    }
     
    static void bomb(int loc) {
        q.clear();
        for(int i = 0;i<h;i++) {
            if(map[i][loc]!=0) {
                q.add(new int[] {i,loc,map[i][loc]-1});
                map[i][loc] = 0;
                break;
            }
        }
        int[] now;
        int x,y,d,nd,nx,ny;
        while(!q.isEmpty()) {
            now = q.poll();
            x = now[0];
            y = now[1];
            d = now[2];
             
            if(now[2]==0)
                continue;
            for(int i = 0;i<4;i++) {
                nx = x;
                ny = y;
                nd = d;
                while(nd-->0) {
                    nx+=dx[i];
                    ny+=dy[i];
                    if(!inRange(nx,ny))
                        break;
                    if(map[nx][ny]>1) {
                        q.add(new int[] {nx,ny,map[nx][ny]-1});
                    }
                    map[nx][ny] = 0;
                }
            }
        }
    }
    static void perm(int k) {
        int[][] temp = new int[h][w];
        for(int i = 0;i<h;i++) {
            temp[i] = Arrays.copyOf(map[i], w);
        }
        int cnt;
        for(int j = 0;j<w;j++) {
            bomb(j);
 
            cnt = gravity();
 
            if(k==n)
                answer = answer>cnt?cnt:answer;
            else
                perm(k+1);
            for(int i = 0;i<h;i++) {
                map[i] = Arrays.copyOf(temp[i], w);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1;t<=tc;t++) {
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            for(int i = 0;i<h;i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0;j<w;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            perm(1);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());      
    }
}