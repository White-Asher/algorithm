package _Playground.ps_skill;

import java.util.*;
import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        BufferedReaderTest brTest = new BufferedReaderTest();
//        brTest.test01();
//        brTest.test02();
//        brTest.test03();
//        brTest.test04();
//        brTest.test05();
//        brTest.test0502();
//        brTest.test06();
//        brTest.test0602();
//        brTest.test07();
        brTest.test0702();
    }

    // 정수 입출력 => 입력: 3 / 출력: 3
    public void test01() throws Exception {
    	

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 정수 n을 BufferedWriter에 넣어서 출력하게 되면 글자가 깨진다. (String형으로의 변환이 필요함!)
        // bw.write(n);
        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
    }

    // 공백을 기준으로 입력받고, 공백을 넣어서 출력하기 입력:123 456 / 출력: 123 456
    public void test02() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        bw.write(String.valueOf(a)+"\t");
        bw.flush();
        bw.write(String.valueOf(b));
        bw.flush();
        bw.close();
    }
    
    /* 입력
    3 3
    111
    222
    333
    */
    public void test03() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[n][m];
    	for(int i=0; i<n; i++) {
    		String str = br.readLine();
    		for(int j = 0; j < m ; j++) {
    			arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
    		}
    	}
    	
    	System.out.println(n + " "+ m);
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]);
			}
    		System.out.println();
		}
    }
    
    /* 한줄로 입력
    5
	1
	2
	3
	4
	5
     */
    
    public void test04() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			System.out.println(m);
		}
    }
    
    // 123457383923
    // [1, 2, 3, 4, 5, 7, 3, 8, 3, 9, 2, 3]
    public void test05() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	int len = str.length();
    	
    	int ans[] = new int[len];
    	for(int i = 0; i < len ; i++) {
    		ans[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
    	}
    	
    	System.out.println(Arrays.toString(ans));
    }
    
    // 입력 : 23222232
    // 출력 : 23222232
    public void test0502() throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	String s = br.readLine();
    	int n = Integer.parseInt(br.readLine());
    	System.out.println(n);
    }
    
    // 무한정한 공백 입력 split()으로 분리
    // 입력: 1 2 3 4 5 6 7 8 9 10
    // 출력: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    public void test06() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] arr = br.readLine().split(" ");
    	System.out.println(Arrays.toString(arr));
    }
    
    // 공백 포함 입력이 무한정한 데이터를 배열로 저장
    // 입력: 1 2 3 4 5 6 7 8 9 10
    // 출력: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    public void test0602() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int nCount = st.countTokens();
    	int[] arr = new int[nCount];
    	for(int i = 0; i < nCount; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	System.out.println(Arrays.toString(arr));
    }
    
    public void test07() throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int size = Integer.parseInt(br.readLine());
    	int[][] map = new int[size][size];

    	// 맵 데이터 입력
    	for (int i = 0; i < size; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < size; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
    }
    public void test0702() throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int [][] map = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		map[i] = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
    	}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
    }
}
