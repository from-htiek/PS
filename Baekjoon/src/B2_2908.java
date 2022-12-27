import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.12.27
 * 상수
 * 와.. 그냥 거꾸로 숫자를 계산했으면 됐는데 이걸 이렇게 푸는 나......... 
 */
public class B2_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		
		if(num1.charAt(2) > num2.charAt(2)) {
			for(int i = 2; i >= 0; i--) {
				System.out.printf("%c", num1.charAt(i));
			}
		}else if(num2.charAt(2) > num1.charAt(2)) {
			for(int i = 2; i >= 0; i--) {
				System.out.printf("%c", num2.charAt(i));
			}
		}else {
			if(num1.charAt(1) > num2.charAt(1)) {
				for(int i = 2; i >= 0; i--) {
					System.out.printf("%c", num1.charAt(i));
				}
			}else if(num2.charAt(1) > num1.charAt(1)) {
				for(int i = 2; i >= 0; i--) {
					System.out.printf("%c", num2.charAt(i));
				}
			}else {
				if(num1.charAt(0) > num2.charAt(0)) {
					for(int i = 2; i >= 0; i--) {
						System.out.printf("%c", num1.charAt(i));
					}
				}else if(num2.charAt(0) > num1.charAt(0)) {
					for(int i = 2; i >= 0; i--) {
						System.out.printf("%c", num2.charAt(i));
					}
				}
			}
		}
	}
}
