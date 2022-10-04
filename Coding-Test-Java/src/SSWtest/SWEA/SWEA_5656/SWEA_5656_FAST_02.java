package SSWtest.SWEA.SWEA_5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Data{
     
    int x, y, val;
     
    Data(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
     
}
 
public class SWEA_5656_FAST_02 {
    static int N, W, H, res;
    static int[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
     
    static void resort(int[][] cp) {
         
        for(int i = H - 1; i >= 0; i--) {
             
            for(int j = W - 1; j >= 0; j--) {
                if(cp[i][j] > 0) {
                    int x = i+1;
                    while(true) {
                        if(x >= H || cp[x][j] > 0) break;
                         
                        if(cp[x][j] == 0) {
                            int temp = cp[x][j];
                            cp[x][j] = cp[x-1][j];
                            cp[x-1][j] = temp;
                            x++;
                        }
                    }
                     
                }
            }
        }
         
    }
     
    static boolean find(int yidx, int[][] cp) {
         
        int x = -1;
        int y = yidx;
        for(int i = 0; i < H; i++) {
            if(cp[i][y] != 0) {
                x = i;
                break;
            }
        }
         
        if(x == -1) return false;
         
        Queue<Data> q = new LinkedList<Data>();
        q.offer(new Data(x,y,cp[x][y]));
        cp[x][y] = 0;
         
        while(!q.isEmpty()) {
             
            Data polled = q.poll();
             
            for(int dir = 0; dir < 4; dir++) {
                                 
                for(int c = 1; c < polled.val; c++) {
                     
                    int nx = polled.x + dx[dir] * c;
                    int ny = polled.y + dy[dir] * c;
                     
                    if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if(cp[nx][ny] > 1)
                            q.offer(new Data(nx,ny, cp[nx][ny]));
                         
                        cp[nx][ny] = 0;
                    }   
                }   
            }       
        }
                 
        return true;
    }
     
    static void breakBrick(int v, int[][] arr) {
        if(v == N) {
            int num = 0;
             
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(arr[i][j] > 0) num++;
                }
            }
                     
            res = Math.min(res, num);
            return;
        }
         
        int[][] cp = new int[H][W];
         
        for(int i = 0; i < W; i ++) {
             
            // 배열 복사하기
            for(int j = 0; j < H; j++) {
                System.arraycopy(arr[j], 0, cp[j], 0, arr[j].length);
            }
             
            // 터뜨릴 값 찾기
            if(find(i, cp)) {
                resort(cp);
                breakBrick(v+1, cp);
            }else {
                breakBrick(v+1, cp);
            }           
                         
        }
         
    }
     
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            res = Integer.MAX_VALUE;
             
            board = new int[H][W];
             
            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());         
                for(int j =0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            breakBrick(0, board);
            System.out.println("#" + test_case + " " + res);
        }
 
    }
 
}
