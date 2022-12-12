package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1388 {
    static char[][] arr;
    static boolean[][] visited;
    static int y, x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new char[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String input = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(!visited[i][j]){
                    DFS(i,j, arr[i][j]);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void DFS(int i, int j, char input){
        visited[i][j] = true;
        if(input == '-'){
            while(true){
                j++;
                if(j >= x) return;
                if(arr[i][j] == '-') visited[i][j] = true;
                else return;
            }

        } else if(input == '|'){
            while(true){
                i++;
                if(i >= y) return;
                if(arr[i][j] == '|') visited[i][j] = true;
                else return;
            }
        }
        return;
    }
}
