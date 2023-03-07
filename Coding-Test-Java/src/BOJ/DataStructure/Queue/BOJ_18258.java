package BOJ.DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch (op) {
                case "push":
                    queue.add(num);
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.peekFirst());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append("1");
                    else sb.append("0");
                    sb.append("\n");
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.pop());
                    sb.append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append("-1");
                    else sb.append(queue.peekLast());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
