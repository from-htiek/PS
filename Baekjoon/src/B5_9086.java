import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2023.12.10
 * 문자열
 */
public class B5_9086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String word = br.readLine();
			sb.append(word.charAt(0));
			sb.append(word.charAt(word.length()-1));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
}
