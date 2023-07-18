package BOJ.DataStructure.Stack.BOJ_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        String a = br.readLine();
        String boom = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            char tar = a.charAt(i);
            stack.push(tar);
            if(tar == boom.charAt(boom.length()-1)) {
                boolean flag = false;
                for (int j = 0; j < boom.length(); j++) {
                    if(stack.size() - 1 - j < 0 || boom.length() - 1 - j < 0) {
                        flag = true;
                        break;
                    }
                    char tara = stack.get(stack.size() - 1 - j);
                    char tarb = boom.charAt(boom.length() - 1 - j);
                    if(tara != tarb) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        } else{
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
        }
        System.out.println(sb);

    }
}
