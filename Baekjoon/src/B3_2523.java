import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.02.12
 * 별 찍기 - 13
 */
public class B3_2523 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		
		for(int i = n-1; i > 0; i--) {
			for(int j = i; j > 0; j--) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}