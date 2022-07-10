import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.07.10
 * 초심자의 회문 검사
 */
public class D2_1989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			String string = br.readLine();
			
			boolean palindrome = true; 
			for(int i = 0, size = string.length(); i < size/2; i++) {
				if(string.charAt(i) != string.charAt(size-i-1)) { 
					palindrome = false; 
					break; 
				}
			}
			
			if(palindrome) sb.append("#").append(tc).append(" ").append(1).append("\n");
			else sb.append("#").append(tc).append(" ").append(0).append("\n");
		}
		
		
		System.out.println(sb.toString());
	}
}
