import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * 2022.10.25
 * 0 만들기
 * 굉장히.... 노가다 + 가독성 답없음의 코드
 * dfs를 이용해서 풀 수 있더라. 훨씬 가독성도 좋음
 * 더할때 때, 뺄 때, 공백일 때 각각 dfs를 부르고 String도 같이 넘기는 형태.
 * 좀 더 고민했으면 저런 방법을 생각해 낼 수 있었을까?
 */
public class G5_7490 {
	public static int n, op[];
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			op = new int[n-1];
			permutation(0);
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 중복 순열 만들기
	public static void permutation(int idx) {
		if(idx == n-1) {

 			String string = "1";
			int result = 1;
			int num = 2;
			int value = 0;
			int factor = 0;
			int tmp = 1; 
			Stack<Integer> stack = new Stack<>(); // 공백이 있을때 stack 사용 
			
			// 0 : 숫자 이어 붙이기, 1 : 더하기, 2 : 빼기
			for(int i = 0; i < n-1; i++) {
				if(op[i] == 0) {
					if(stack.size() == 0) {
						if(i-1 >= 0 && op[i-1] == 1) {
							result -= (num-1);
							tmp = 1;
						}else if(i-1 >= 0 && op[i-1] == 2) {
							result += (num-1);
							tmp = 2;
						}else if(i == 0) {
							result -= (num-1);
						}
						
						stack.add(num-1);
						stack.add(num);
					}else {
						stack.add(num);
					}
					
					string += " ";
				}else if(op[i] == 1) {
					// 스택에 숫자가 있을 때, 똑같은 코드 3번 나옴 => 함수를 만들던가 순서를 바꾸던가
					if(stack.size() != 0) { 
						value = 0;
						factor = 0; 
						while(!stack.isEmpty()) {
							value += stack.pop() * Math.pow(10, factor);
							factor++;
						}
						
						if(tmp == 1) result += value;
						else if(tmp == 2) result -= value;
					}
					
					result += num;
					string += "+";
				}else {
					if(stack.size() != 0) {
						value = 0;
						factor = 0; 
						while(!stack.isEmpty()) {
							value += stack.pop() * Math.pow(10, factor);
							factor++;
						}
						
						if(tmp == 1) result += value;
						else if(tmp == 2) result -= value;
					}
					
					result -= num;
					string += "-";
				}
				
				string += num;
				num++; 
			}

			value = 0;
			factor = 0; 
			if(!stack.isEmpty()) {
				while(!stack.isEmpty()) {
					value += stack.pop() * Math.pow(10, factor);
					factor++;
				}
				if(tmp == 1) result += value;
				else if(tmp == 2) result -= value;
			}

			if(result == 0) {
				sb.append(string).append("\n");
			}
			
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			op[idx] = i;
			permutation(idx+1);
		}
	}
}
