import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.01.19
 * 반지
 */
public class S5_5555 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pattern = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		int result = 0; 
		for(int i = 0; i < n; i++) {
			String string = br.readLine();
			if(string.concat(string).contains(pattern)) result++;
		}
		
		System.out.println(result);
	}
}
