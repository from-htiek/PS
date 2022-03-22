import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * 2022.02.09
 * 계산기2
 * 
 * 카페테라스
 * 아스키코드 이용함 + stack에 연산자 넣어 본인보다 우선순위가 낮은게 들어오면 높은 거 만날때까지 pop
 */
public class D4_1223 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			Deque<Character> q = new ArrayDeque<>();
			Stack<Integer> stack = new Stack<>();
			String str = br.readLine();

			// 후위 표기식으로 변환 
			char ch = 0;
			char tmp = 0;
			for(int _ = 0; _ < n; _++) {
				ch = str.charAt(_);
				switch(ch) {
				case '+' :
					q.offer(str.charAt(_+1));
					q.offer(ch);
					_++;
					break;
				case '*' :
					if(q.size() <= 1) {
						q.offer(str.charAt(_+1));
						q.offer(ch);
					}else {
						tmp = q.pollLast();
						q.offer(str.charAt(_+1));
						q.offer(ch);
						q.offer(tmp);
					}
					_++;
					break;
				default :
					q.offer(ch);
				}
			}

			// 변환된 표기식 확인
			System.out.println(q);

			// 후위 표기식 계산
			int a = 0;
			int b = 0;
			for(int _ = 0; _ < n; _++) {
				ch = q.poll();
				if(ch >= 48) stack.push(ch-48);
				else {
					a = stack.pop();
					b = stack.pop();
					switch(ch){
					case '+' :
						stack.push(a+b);
						break;
					case '*' :
						stack.push(a*b);
						break;
					}
				}
				System.out.println(stack);
			}
			
			System.out.printf("#%d %d\n", tc, stack.pop());
		}
	}
}
