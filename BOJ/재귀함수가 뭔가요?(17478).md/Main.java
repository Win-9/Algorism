import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static String[]str = {
			"\"재귀함수가 뭔가요?\"\n",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
			"라고 답변하였지.\n"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		StringBuilder underLine = new StringBuilder("");
		recursive(0, underLine);
		
		sb.append(str[4]);
		System.out.println(sb);
		
	}
	
	static void recursive(int num, StringBuilder underLine) {
		
		sb.append(underLine).append(str[0]);
		
		if (num == N) {
			sb.append(underLine).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			return;
		}

		for(int i = 1; i < 5; i++) {
			
			if (i == 4) {
				
				for(int j = 0; j < 4; j++) {
					underLine.append("_");
				}
				
				recursive(num + 1, underLine);
			}
			
			sb.append(underLine).append(str[i]);
		}		
		underLine.delete(0, 4);

		
	}
	
}
