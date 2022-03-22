import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 2022.02.27
 * 단어 뒤집기2
 * 
 * 내 코드는 시간이 굉장히 오래걸림..... 
 */
public class S3_17413 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean flag = false; 
		for(int i = 0, size = str.length(); i < size; i++) {
			switch(str.charAt(i)) {
			case '<' :
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				flag = true;
				System.out.print('<');
				break;
			case '>' :
				flag = false;
				System.out.print('>');
				break;
			case ' ' :
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(' ');
				break;
			default :
				if(flag) {
					System.out.print(str.charAt(i));
				}else {
					stack.add(str.charAt(i));
				}

			}

		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
}
