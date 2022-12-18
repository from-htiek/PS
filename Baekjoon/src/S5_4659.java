import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 2022.12.18
 * 비밀번호 발음하기
 * 코드의 상태가..
 */
public class S5_4659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("end")) break;
			
			boolean flag = false; 
			boolean check = false;

			char prev = input.charAt(0);
			if(prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') check = true;  
			int cnt = 1; 
			for(int i = 1, size = input.length(); i < size; i++) {
				char ch = input.charAt(i); 
				
				if(prev == ch && ch != 'o' && ch != 'e') {
					flag = true; 
					break; 
				}
				

				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					check = true;  
					
					if(prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') {
						cnt++; 
					}else {
						cnt = 1; 
					}
					
				}else {
					if(prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') {
						cnt = 1; 
					}else {
						cnt++; 
					}
				}
				
				prev = ch;
				
				
				if(cnt == 3) {
					flag = true;
					break;
				}
				
			}
			
			
			if(!flag && check) sb.append("<").append(input).append(">").append(" is acceptable.").append("\n");
			else sb.append("<").append(input).append(">").append(" is not acceptable.").append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}
}
