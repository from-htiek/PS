import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.02.10
 * 계산기3
 */
public class D4_1224 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<>();
			Stack<Integer> stackCal = new Stack<>();
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char ch = 0;
			
			// 후위 표기식으로 변환
			for(int _ = 0; _ < n; _++) {
				ch = str.charAt(_);
				switch(ch) {
				// ( 는 스택에 넣음
				case '(' :
					stack.push(ch);
					break;
				// )는 (을 만나기 전까지 스택에서 pop해 출력
				case ')' :
					while(!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop(); // ( 빼기
					break;
				// (를 제외한 본인과 같거나 낮은 우선순위를 만나면 pop, 그 후 본인은 스택에 넣음
				case '+' :
				case '*' :
					while(!stack.isEmpty() && ch >= stack.peek() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.push(ch);
					break;
				// 피연산자는 바로 출력
				default :
					sb.append(ch); 
				}
			}
			
			// 스택에 남아있는 연산자 출력
			while(!stack.isEmpty()) sb.append(stack.pop());
			
			// 변환된 표기식 확인
			// System.out.println(sb.toString());
			str = sb.toString();
			
			// 후위 표기식 계산 
			int a = 0;
			int b = 0;
			for(int _ = 0; _ < sb.length(); _++) {
				ch = str.charAt(_);
				if(ch >= 48) stackCal.push(ch - 48);
				else {
					a = stackCal.pop();
					b = stackCal.pop();
					switch(ch){
					case '+' :
						stackCal.push((a+b));
						break;
					case '*' :
						stackCal.push(a*b);
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, stackCal.pop());
		}
	}
}
