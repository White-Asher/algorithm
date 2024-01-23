package BOJ.MST.BOJ_4386_G3_별자리만들기;

import java.util.*;
import java.io.*;

public class BOJ_4386_G3_별자리만들기 {
    static int N;
    static int p[];
    static List<Edge> edgeList;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Point> pointList = new ArrayList<>();
        edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double start = Double.parseDouble(st.nextToken());
            double end = Double.parseDouble(st.nextToken());
            pointList.add(new Point(i, start, end));
        }

        make();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = getDist(pointList.get(i), pointList.get(j));
                edgeList.add(new Edge(pointList.get(i).idx , pointList.get(j).idx, dist));
            }
        }

        edgeList.sort((o1, o2) -> {
            if(o1.weight < o2.weight) return -1;
            return 1;
        });

        double ans = 0.0;
        int cnt = 0;
        for (Edge edge : edgeList) {
            if(union(edge.start , edge.end)) {
                ans += edge.weight;
                if(++cnt == N - 1) break;
            }
        }
        System.out.printf("%.2f" , ans);


    }
    public static double getDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
    public static void make() {
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }

    public static int find(int x) {
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        p[aRoot] = bRoot;
        return true;
    }

    static class Edge {
        int start;
        int end;
        double weight;
        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static class Point {
        int idx;
        double x;
        double y;
        public Point (int idx_ , double x_, double y_) {
            idx = idx_;
            x = x_;
            y = y_;
        }
    }
}
