import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.12.23
 * 집 주소
 */
public class B3_1284 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break; 
		
			int result = 1;
			while(n != 0) {
				int tmp = n % 10; 
				
				if(tmp == 1) result += 3;
				else if(tmp == 0) result += 5;
				else result += 4;
				
				n = n / 10;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
