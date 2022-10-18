import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
 * 2022.10.18
 * 압축
 * 꼭 써야할까 스택을? 반례가 도대체 뭐지? 
 */
public class G5_1662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int result = 0;
		int cnt = 0; 
		
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false; 
		for(int size = input.length(), i = size-1; i >= 0; i--) {
			if(input.charAt(i) == ')') {
				flag1 = true;
			}
			else if(input.charAt(i) == '(') {
				flag1 = false;
				flag2 = true;
				if(input.charAt(i+1) == ')') flag3 = true;
			}
			else {
				if(flag1) {
					cnt++;
				}
				else if(flag2) {
					flag2 = false;
					if(!flag3 && cnt == 0) {
						result *= input.charAt(i) - '0';
						flag3 = false;
						continue;
					}
					cnt *= input.charAt(i) - '0';
					result += cnt;
					cnt = 0;
				}else {
					result++; 
				}
				
			}
//			System.out.println(result + " " + cnt);
		}
		
		System.out.println(result);

	}
}
