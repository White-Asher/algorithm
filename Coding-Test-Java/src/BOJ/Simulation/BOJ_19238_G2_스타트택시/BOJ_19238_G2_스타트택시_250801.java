package BOJ.Simulation.BOJ_19238_G2_스타트택시;

import java.util.*;
import java.io.*;

public class BOJ_19238_G2_스타트택시_250801 {
    static int N, M;
    static int[][] arr;
    static int y, x;
    static long fuel;
    static List<Passenger> passengerList = new ArrayList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            passengerList.add(new Passenger(i, sy, sx, ey, ex));
            arr[sy][sx] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            boolean success = findAndDrive();
            if(!success) {
                fuel = -1;
                break;
            }
        }
        System.out.println(fuel);
    }

    private static boolean findAndDrive() {
        // 가장 가까운 승객 찾기 (BFS)
        Passenger nearPassenger = findHuman();

        // 승객이 없다면 끝내기
        if(nearPassenger == null || fuel < nearPassenger.dist) {
            return false;
        }

        // 승객에게 이동하기
        fuel -= nearPassenger.dist;
        y = nearPassenger.startY;
        x = nearPassenger.startX;
        arr[y][x] = 0;

        // 승객으로부터 목적지까지 거리 계산 (BFS)
        int distToDest = getDistanceDestination(nearPassenger.endY, nearPassenger.endX);

        // 목적지 이동 및 연료 충전
        if(distToDest == -1 || fuel < distToDest) {
            return false;
        }

        // 목적지 이동 및 연료 충전하기
        y = nearPassenger.endY;
        x = nearPassenger.endX;
        fuel -= distToDest;
        fuel += distToDest * 2L;

        passengerList.remove(nearPassenger);

        return true;
    }

    private static int getDistanceDestination(int endY, int endX) {
        if(y == endY && x == endX) return 0;

        Queue<Position> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N + 1][N + 1];
        q.add(new Position(y, x, 0));
        visit[y][x] = true;

        while(!q.isEmpty()) {
            Position cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if(ny < 1 || nx < 1 || ny >= N+1 || nx >= N+1) continue;
                if(visit[ny][nx] || arr[ny][nx] == 1) continue;
                visit[ny][nx] = true;

                if(ny == endY && nx == endX) {
                    return cur.dist + 1;
                }
                q.add(new Position(ny, nx, cur.dist + 1));
            }

        }

        // 목적지에 도달할 수 없음.
        return -1;
    }

    // 현재 택시 위치에서 가장 가까운 승객 찾기.
    private static Passenger findHuman() {
        Queue<Position> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N+1][N+1];
        List<Passenger> candidate = new ArrayList<>();

        q.add(new Position(y, x, 0));
        visit[y][x] = true;

        if(arr[y][x] > 1) {
            int passengerId = arr[y][x] - 1;
            Passenger p = passengerList.get(passengerId - 1);
            p.dist = 0;
            candidate.add(p);
        }

        int shortDist = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Position cur = q.poll();
            // 현재 찾은 거리보다 더 최단거리일 때 탐색할 필요는 없음
            if(cur.dist > shortDist) continue;

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if(ny < 1 || nx < 1 || ny >= N+1 || nx >= N+1) continue;
                if(visit[ny][nx] || arr[ny][nx] == 1) continue;
                visit[ny][nx] = true;

                if(arr[ny][nx] > 1) {
                    int passengerId = arr[ny][nx] - 1;
                    Passenger p = passengerList.get(passengerId - 1);
                    p.dist = cur.dist + 1;
                    candidate.add(p);
                    shortDist = p.dist;
                }

                q.add(new Position(ny, nx, cur.dist + 1));

            }
        }

        // 탐색한 애들 중에서 우선순위 뽑아야함
        if(candidate.isEmpty()) return null;
        Collections.sort(candidate);
        return candidate.get(0);
    }

    static class Position {
        int y ,x, dist;

        public Position(int _y, int _x, int _dist) {
            y = _y;
            x = _x;
            dist = _dist;
        }
    }

    static class Taxi {
        int y;
        int x;

        public Taxi (int _y, int _x) {
            y = _y;
            x = _x;
        }
    }

    static class Passenger implements Comparable<Passenger> {
        int id;
        int startY;
        int startX;
        int endY;
        int endX;
        int dist;

        public Passenger(int _id, int _startY, int _startX, int _endY, int _endX) {
            id = _id;
            startY = _startY;
            startX = _startX;
            endY = _endY;
            endX = _endX;
        }

        @Override
        public int compareTo(Passenger other) {
            if(this.dist != other.dist) {
                return this.dist - other.dist;
            }
            if(this.startY != other.startY) {
                return this.startY - other.startY;
            }
            return this.startX - other.startX;
        }
    }


}
