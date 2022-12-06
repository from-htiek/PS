import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2022.12.06
 * 과제는 끝나지 않아!
 */
public class S3_17952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 이번학기 몇 분인지 
		StringTokenizer st = null;
		
		Stack<Integer> stack = new Stack<>();
		int result = 0; 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken()); 
			
			if(num != 0) { // 과제가 주어졌을 때
				stack.add(Integer.parseInt(st.nextToken()));
				stack.add(Integer.parseInt(st.nextToken())-1);
			}else { // 과제가 없을 때
				if(!stack.isEmpty()) stack.add(stack.pop()-1);
			}
			
			if(!stack.isEmpty() && stack.peek() == 0) { // 다 했으면 점수 얻음
				stack.pop();
				result += stack.pop();
			}
			
		}
		
		System.out.println(result);
	}
}
