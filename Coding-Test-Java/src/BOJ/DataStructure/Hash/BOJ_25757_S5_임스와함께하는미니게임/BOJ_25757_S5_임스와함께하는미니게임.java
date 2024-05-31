package BOJ.DataStructure.Hash.BOJ_25757_S5_임스와함께하는미니게임;

import java.io.*;
import java.util.*;

public class BOJ_25757_S5_임스와함께하는미니게임 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int g = 0;
        if(game.equals("Y")){
            g = 1;
        } else if (game.equals("F")) {
            g = 2;
        } else if (game.equals("O")) {
            g = 3;
        }

        int cnt = 0;
        int people = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            set.add(input);
        }

        System.out.println(set.size() / g);
    }
}
