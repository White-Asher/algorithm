package BOJ._SSWtest;

import java.util.*;
import java.io.*;
public class BOJ_17070_Sol3 {
    //3:00

    public static void main(String[] args) throws IOException{
        //파이프는 3가지 모양, 가로,세로, 대각선(왼쪽위-오른쪽아래)   

        //파이프 이동은 밀면서 변경가능
            //가로는 가로쭉, 대각선
            //세로는 세로쭉, 대각선
            //대각선은 쭉대각선,가로,세로
        //이동시 이동반경은 빈칸이어야 한다.
            //대각선은 3개의 공간 사용

        //무조건 가로, 가로아래만 가능하다. 
            //경우의 수이므로 계산이 편하다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][][] memo = new int[N][N][3];//가로상태,세로상태,대각선방향

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());   
            }
        }

        //초기
        memo[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(i==0){
                    if(map[i][j]==0){//현위치가 빈칸인 경우
                        //왼쪽만 확인
                        memo[i][j][0] += memo[i][j-1][0];//왼쪽의 경우의 수를 더해준다.
                        if(j==N-1){//우측 상위는 경우의수를 확인하면 안되므로 초기화 해준다.
                            memo[i][j][0]=0;
                        }
                    }
                }else{
                    //왼쪽, 왼쪽위, 위의 경우의 수를 확인한다.
                    if(map[i][j]==0){//현위치가 빈칸일경우
                        if(map[i][j-1]==0&&map[i-1][j]==0){//양쪽다 장애물이 없을때
                            memo[i][j][1] += (memo[i-1][j][1]+memo[i-1][j][2]);//위
                            memo[i][j][0] += (memo[i][j-1][0]+memo[i][j-1][2]);//왼쪽
                            //대각선
                            memo[i][j][2] += (memo[i-1][j-1][0]+memo[i-1][j-1][1]+memo[i-1][j-1][2]);//대각선의 가로나 세로 상태의 값을 다 더해준다.
                        }else if(map[i][j-1]!=0&&map[i-1][j]==0){//왼쪽에만 장애물 있을때
                            //위에서의 경우의 수를 더해준다.
                            memo[i][j][1] += (memo[i-1][j][1]+memo[i-1][j][2]);//세로 상태를 업데이트
                        }else if(map[i-1][j]!=0&&map[i][j-1]==0){//위에만 장애물이 있을때
                            //왼쪽에서의 경우의 수를 더해준다.
                            memo[i][j][0] += (memo[i][j-1][0]+memo[i][j-1][2]);//가로 상태만 업데이트
                        }
                    }
                }
            }
        }

        // for (int i = 0; i < memo.length; i++) {
        //     for (int j = 0; j < memo.length; j++) {
        //         System.out.print(Arrays.toString(memo[i][j]));
        //     }
        //     System.out.println("");
        // }

        
        //결과
        System.out.println(memo[N-1][N-1][0]+memo[N-1][N-1][1]+memo[N-1][N-1][2]);




    }
}
