package Codeup.ps90;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ps99 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력

        int n = 10; // 입력과 동시에 int 로 변환

        int[][] arr = new int[n][n];

        for(int i = 0; i < arr.length; i++) {
            String[] line = br.readLine().split(" ");

            for(int j = 0; j < line.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        int x = 1;
        int y = 1;

        while(true){
            if(arr[x][y] == 2){
                arr[x][y] = 9;
                break;
            }
            if(arr[x][y+1]==1){
                if(arr[x+1][y] ==1)
                    break;
                else
                    x++;
            }

            else if (arr[x][y+1] != 1){
                y++;
            }

            if(arr[x][y]==2) {
                arr[x][y]=9;
                break;
            }

            arr[x][y]=9;
        }

        arr[1][1] = 9;

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }


//        bw.write(Arrays.deepToString(arr));

        bw.flush(); // 남아있는 버퍼의 내용을 출력
        bw.close(); // 버퍼 해제
    }
}
