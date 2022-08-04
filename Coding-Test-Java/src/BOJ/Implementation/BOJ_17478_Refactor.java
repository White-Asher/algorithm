package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 실행시간 짧게
public class BOJ_17478_Refactor {
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int number = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."+"\n");
		recursive(number, 0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	//변경되는 값 -> 매개변수에서 처리
	public static void recursive(int num, int cnt) {
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			a.append("____");
		}
		
		sb.append(a).append("\"재귀함수가 뭔가요?\""+"\n");
		if(cnt == num) {
			sb.append(a).append("\"재귀함수는 자기 자신을 호출하는 함수라네\""+"\n");
		} else {
			sb.append(a).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."+"\n");
			sb.append(a).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."+"\n");
			sb.append(a).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""+"\n");
			recursive(num, cnt+1);
		}
		sb.append(a).append("라고 답변하였지."+"\n");
	}
}
// stringbuilder 와 bufferedWrtier에 대하여 https://cantcoding.tistory.com/38