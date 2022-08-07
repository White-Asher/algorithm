package BOJ.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder();

	    Stack<Integer> stack = new Stack<>();
	    
	    int N = sc.nextInt();
	    int start = 0;

	    while(N-- > 0){
	    	int target = sc.nextInt();
	    	if(target > start) {
	    		for (int i = start + 1; i <= target; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
	    		start = target;
	    	} else if (stack.peek() != target){
	    		System.out.println("NO");
	    		return;
	    	}
	    	
	    	stack.pop();
	    	sb.append('-').append('\n');
	    }
	    System.out.println(sb);
	}
}

/*
public class Main {

static int T;
static StringBuilder sb = new StringBuilder();
static int temp = 1;
static boolean err = false;

public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	T = Integer.parseInt(br.readLine());
	
	Stack<Integer> stack = new Stack<>();

	for(int i = 0 ; i < T ; i++) {
		int N = Integer.parseInt(br.readLine());
		
		for( ; temp <= N ; temp++) {
			stack.push(temp);
			sb.append("+").append("\n");
		}
		
		if(stack.peek()==N) {
			stack.pop();
			sb.append("-").append("\n");
		}else {
			err = true;
		}
	}
	
	if(err)
		System.out.println("NO");
	else
		System.out.println(sb);
	}
}*/