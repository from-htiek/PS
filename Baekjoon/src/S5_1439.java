import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.01.20
 * 뒤집기
 */
public class S5_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int one = 0;
		int zero = 0; 
		char prev = input.charAt(0);
		
		if(prev == '0') zero++;
		else one++;
		
		for(int i = 1, size = input.length(); i < size; i++) {
			char cur = input.charAt(i);
			
			if(prev != cur) {
				if(cur == '0') zero++;
				else one++;
				
				prev = cur; 
			}
		}
		
		System.out.println(Math.min(one, zero));
		
	}
}
