package BOJ.Dijkstra.BOJ_1238_G3_파티;

import java.util.*;
import java.io.*;

public class BOJ_1238_G3_파티_250728 {
    static final int INF =1000000;
    static class Node implements Comparable<Node> {
        int start;
        int to;
        int cost;
        public Node(int _start, int _to, int _cost) {
            start = _start;
            to = _to;
            cost = _cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static List<Node>[] a = new ArrayList[20001];
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int dist[] = new int[20001];
    static boolean check[] = new boolean[20001];

    public static void main(String[] args) {

    }
}
