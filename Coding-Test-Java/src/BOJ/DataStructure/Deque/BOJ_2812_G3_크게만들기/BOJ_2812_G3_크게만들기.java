package BOJ.DataStructure.Deque.BOJ_2812_G3_크게만들기;

import java.util.*;
import java.io.*;

public class BOJ_2812_G3_크게만들기 {
    static StringTokenizer st;
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int len = N - K;

        Deque<Character> queue = new ArrayDeque<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char tar = input.charAt(i);
            while (!queue.isEmpty() && K > 0) {
                if (queue.getLast() < tar) {
                    queue.removeLast();
                    K--;
                } else {
                    break;
                }
            }
            if(queue.size() == len) {
                break;
            }
            queue.add(tar);

        }

        StringBuilder sb = new StringBuilder();

        for (Character c : queue) {
            sb.append(c.toString());
        }
        System.out.println(sb);
    }
}
