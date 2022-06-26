import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.06.26
 * 제로
 */
public class S4_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		long result = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				result -= stack.pop();
			}else {
				result += num;
				stack.add(num);
			}
		}
		
		System.out.println(result);
	}
}
