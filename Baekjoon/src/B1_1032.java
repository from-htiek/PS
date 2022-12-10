import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.12.10
 * 명령 프롬프트
 */
public class B1_1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[] input = br.readLine().toCharArray();
		
		if(n == 1) {
			System.out.println(new String(input));
			return; 
		}
		
		
		for(int i = 0; i < n-1; i++) {
			String str = br.readLine();
			
			for(int j = 0, size = str.length(); j < size; j++) {
				if(input[j] != '?' && input[j] != str.charAt(j)) {
					input[j] = '?';
				}
			}
		}
		
		
		System.out.println(new String(input));
	}
}
