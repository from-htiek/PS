import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.06.25
 * 균형잡힌 세상
 * 입력으로 '(((' 처럼 열리는 괄호만 들어왔을 때 처리부분을 생각해놓지 않아 계속 다시 풀었던 문제 ^_^.. 
 */
public class S4_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			char[] sentence = br.readLine().toCharArray();
			if(sentence[0] == '.' && sentence.length == 1) break; // 입력으로 "." 하나가 들어오면 끝 
			
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0, size = sentence.length; i < size; i++) {
				char ch = sentence[i];
				
				if(ch == '(' || ch == '[') stack.push(ch); 
				else if(ch == ')') {
					if(stack.size() == 0 || stack.peek() != '(') {
						stack.push(ch); 
						break;
					}
					else {
						stack.pop();
					}
				}else if(ch == ']') {
					if(stack.size() == 0 || stack.peek() != '[') {
						stack.push(ch); 
						break; 
					}
					else {
						stack.pop();

					}
				}
				
			}
			
			if(stack.isEmpty()) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}
