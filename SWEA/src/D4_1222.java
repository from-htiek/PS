import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.02.09
 * 계산기1 
 */
public class D4_1222 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();

			// 후위 표기식으로 변환 
			char ch = 0; 
			for(int _ = 0; _ < n; _++) {
				ch = str.charAt(_);
				switch(ch) {
				case '+' :
					sb.append(str.charAt(_+1));
					sb.append(ch);
					_++;
					break;
				default :
					sb.append(ch);
				}
			}

			// 변환된 표기식 할당
			str = sb.toString();

			// 후위 표기식 계산
			int a = 0;
			int b = 0;
			for(int _ = 0; _ < n; _++) {
				ch = str.charAt(_);
				switch(ch){
				case '+' :
					a = stack.pop();
					b = stack.pop();
					stack.push(a+b);
					break;
				default :
					stack.push(ch-48);
				}
			}

			System.out.printf("#%d %d\n", tc, stack.pop());
		}
	}
}
