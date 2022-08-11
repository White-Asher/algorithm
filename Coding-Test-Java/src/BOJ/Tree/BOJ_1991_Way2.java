/*
package BOJ.Tree;

import java.io.*;
import java.util.*;

class Node{
	char data;
	Node left;
	Node right;
	
	Node(char data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

// 메모리: 11656KB 실행시간: 76ms 코드길이:2057B
public class BOJ_1991_Way2 {
	static StringTokenizer st;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Node root = new Node('A', null, null);
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char leftData = st.nextToken().charAt(0);
			char rightData = st.nextToken().charAt(0);
			addNode(root, data, leftData, rightData);
		}

		preOrder(root);
		bw.write("\n");
		inOrder(root);
		bw.write("\n");
		postOrder(root);
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	
	public static void addNode(Node node, char data, char left, char right) {
		if(node.data != data) {
			if(node.left != null) addNode(node.left, data, left, right);
			if(node.right != null) addNode(node.right, data, left, right);
		} else {
			if(left == '.') node.left = null;
			else node.left = new Node(left, null, null);
			if(right == '.') node.right = null;
			else node.right = new Node(right, null, null);
		}
		
	}
	
	public static void preOrder(Node root) throws IOException {
		bw.write(root.data);
		if(root.left != null) preOrder(root.left);
		if(root.right != null) preOrder(root.right);
	}
	
	public static void inOrder(Node root) throws IOException {
		if(root.left != null) inOrder(root.left);
		bw.write(root.data);
		if(root.right != null) inOrder(root.right);
	}
	
	public static void postOrder(Node root) throws IOException {
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		bw.write(root.data);
	}
}
*/