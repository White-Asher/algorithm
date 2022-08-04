package BOJ.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) queue.add(i);
		while(queue.size() > 1) {
				queue.poll();
				queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}
}

/* 시간복잡도 절반 솔루션... 76ms
import java.io.*;
import java.util.*;

public class Main {
    static int f(int m){
        if(m<=2) return m;
        if(m%2==0) return 2*f(m/2);
        return (2*f(m/2)+1)%(m-1)+1;
    }
    public static void main(String args[]) throws Exception {
        int n = readInt();
        System.out.println(f(n));
    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return isNegative ? sum * -1 : sum;
            else if (input == '-')
                isNegative = true;
            else
                sum = (sum * 10) + input - '0';
        }
    }
}
*/