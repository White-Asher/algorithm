// ListIterator 사용

package BOJ.DataStructure.LinkedList.BOJ_1406_S2_에디터;

import java.util.*;
import java.io.*;

public class BOJ_1406_S2_에디터_SOL1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();
        // 처음 커서는 문장의 맨 뒤에 있어야 한다.
        while(iter.hasNext()) {
            iter.next();
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if(iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D':
                    if(iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B':
                    // remove는 next, previous에 의해 반환된 가장 마지막 요소를 리스트에서 제거
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char v = command.charAt(2);
                    iter.add(v);
                    break;
                default:
                    break;
            }
        }

        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();

    }
}
