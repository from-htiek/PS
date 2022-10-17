import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
 * 2022.10.17
 * 압축
 * 일단 숫자만 입력이 들어왔을 때 읽을 수 없음
 * ()가 중간에 닫혔을 때 '+'를 넣어줘야할 것 같음
 */
public class G5_1662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		boolean flag = false;
		int cnt = 0;
		for(int i = 0, size = input.length(); i < size; i++) {
			char ch = input.charAt(i);
			
			if(ch >= '0' && ch <= '9') {
				cnt++;
			}else if(ch == '(') {

				stack.add((char)(cnt-1 + '0'));
				stack.add('+');
				stack.add(input.charAt(i-1));
				stack.add('*');
				cnt = 0;
			}else if(ch == ')') {
				if(stack.peek() == '*' || stack.peek() == '+') stack.add((char)(cnt + '0'));
				
				while(true) {
					char _ch1 = stack.pop();
					char op = stack.pop();
					char _ch2 = stack.pop();
					
					if(op == '+') {
						stack.add((char) ((_ch1 - '0') + (_ch2 - '0') + '0'));
					}else if(op == '*') {
						stack.add((char) ((_ch1 - '0') * (_ch2 - '0') + '0'));
						break;
					}
				}
				
			}
			
			System.out.println(stack);
		}
		
//		while(!stack.isEmpty()) {
//			
//		}

	}
}
