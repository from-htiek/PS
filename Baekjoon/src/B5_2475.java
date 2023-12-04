import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.12.04
 * 검증수
 */
public class B5_2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		int num = 0;
		for(int i = 0; i < 5; i++) {
			num = Integer.parseInt(st.nextToken());
			result += (num * num);
		}
		
		System.out.println(result);
		
		result %= 10; 
		
		System.out.println(result);
	}
}
