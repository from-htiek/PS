import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.02.11
 * 쇠막대기 자르기
 * 
 * stack으로 풀지 않고 변수를 통해서도 계산 가능 
 * ex. ) 들어오면 숫자를 변수 num을 +1 해줌
 */
public class D4_5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			int cnt = 0;
			char bracket = 0;
			for(int _ = 0; _ < str.length(); _++) {
				bracket = str.charAt(_);
				if(bracket == '(') {
					stack.push(bracket);
				}else {
					// ) 들어왔을 때, stack의 값이 '(' 이면 레이저 => 크기만큼 *2
					// ) 들어왔을 때, str의 바로 전 idx가 ) 라면 쇠막대기 하나가 끝남 => +1 
					if(stack.peek() == '(' && str.charAt(_-1) == '(') {
						stack.pop();
						cnt += stack.size();
					}else {
						stack.pop();
						cnt += 1;
					}
					
				}

			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
	}
}
