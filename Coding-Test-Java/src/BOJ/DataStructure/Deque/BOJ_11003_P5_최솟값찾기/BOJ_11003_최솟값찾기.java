package BOJ.DataStructure.Deque.BOJ_11003_P5_최솟값찾기;

import java.util.*;
import java.io.*;

public class BOJ_11003_최솟값찾기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().val > target) {
                deque.removeLast();
            }
            deque.addLast(new Node(target, i));

            if(deque.getFirst().idx <= i - L) {
                deque.removeFirst();
            }
            sb.append(deque.getFirst().val);
            sb.append(" ");
        }

        System.out.println(sb);

    }

    public static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
