package BOJ.BFSDFS.BOJ_16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
    static int N, L, R;
    static StringTokenizer st;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int ans;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ans = 0;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean check = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(BFS(i, j)){
                            check = true;
                        };
                    }
                }
            }

            if(!check) break;
            ans++;
        }

        System.out.println(ans);
    }

    public static boolean BFS(int x, int y) {
        // 좌표 값 저장용 큐
        Queue<People> queueSave = new ArrayDeque<>();
        queueSave.add(new People(x,y, arr[x][y]));
        // 인구 이동 총합과 이동할 수 있는 지역 수
        int population = 0;
        int amount = 0;
        population += arr[x][y];

        // 탐색용 큐 선언
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];
            visited[qx][qy] = true;

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                if(nx < 0  || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                // 만약 두 수 차이가 L 이상 R 이하라면
                int diff =  Math.abs(arr[nx][ny] - arr[qx][qy]);
                // 서로 국경을 오픈할 수 있음
                if(diff >= L && diff <= R) {
                    // 방문체크 와 일반용 큐 기록용 큐에 해당 지역 정보 입력
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    queueSave.add(new People(nx, ny, arr[nx][ny]));
                    population += arr[nx][ny];
                }
            }
        }

        amount = queueSave.size();
        int res = (int) Math.floor((double) population / amount);

        while(!queueSave.isEmpty()) {
            People cur = queueSave.poll();
            int curX = cur.x;
            int curY = cur.y;
            arr[curX][curY] = res;
        }

        return amount >= 2;
    }
}

// 기록용 큐 자료형 클래스 선언
class People {
    int x;
    int y;
    int people;

    public People(int x, int y, int people) {
        this.x = x;
        this.y = y;
        this.people = people;
    }
}