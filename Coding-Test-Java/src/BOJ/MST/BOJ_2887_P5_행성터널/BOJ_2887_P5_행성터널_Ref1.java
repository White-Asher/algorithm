package BOJ.MST.BOJ_2887_P5_행성터널;

import java.io.*;
import java.util.*;

public class BOJ_2887_P5_행성터널_Ref1 {
    static int N;
    static int[] parent;
    static PriorityQueue<Edge> edgeList = new PriorityQueue<>();

    static List<Point> pointList;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pointList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            pointList.add(new Point(i, x, y, z));
        }

        make();

        pointList.sort(((o1, o2) -> o1.x - o2.x));
        for (int i = 0; i < N - 1; i++) {
            int weight = getDist(pointList.get(i), pointList.get(i+1), 'x');
            edgeList.add(new Edge(pointList.get(i).idx, pointList.get(i+1).idx, weight));
        }

        pointList.sort(((o1, o2) -> o1.y - o2.y));
        for (int i = 0; i < N - 1; i++) {
            int weight = getDist(pointList.get(i), pointList.get(i+1), 'y');
            edgeList.add(new Edge(pointList.get(i).idx, pointList.get(i+1).idx, weight));
        }

        pointList.sort(((o1, o2) -> o1.z - o2.z));
        for (int i = 0; i < N - 1; i++) {
            int weight = getDist(pointList.get(i), pointList.get(i+1), 'z');
            edgeList.add(new Edge(pointList.get(i).idx, pointList.get(i+1).idx, weight));
        }


        int ans = 0;
        int cnt = 0;
        while (!edgeList.isEmpty()) {
            Edge edge = edgeList.poll();
            if(union(edge.start, edge.end)) {
                ans+= edge.weight;
                if(++cnt == N-1) break;
            }
        }
        System.out.println(ans);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parent[aRoot] = bRoot;
        return true;
    }

    public static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void make() {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public static int getDist(Point p1, Point p2, char mode) {
        switch (mode) {
            case 'x':
                return Math.abs(p1.x - p2.x);
            case 'y':
                return Math.abs(p1.y - p2.y);
            case 'z':
                return Math.abs(p1.z - p2.z);
            default:
                return 0;
        }
    }

    protected static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        public Edge (int start_, int end_, int weight_) {
            start = start_;
            end = end_;
            weight = weight_;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    protected static class Point {
        int idx;
        int x;
        int y;
        int z;
        public Point (int idx_, int x_, int y_, int z_) {
            idx = idx_;
            x = x_;
            y = y_;
            z = z_;
        }

    }
}

