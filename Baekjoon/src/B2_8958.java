import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.24
 * OX퀴즈
 */
public class B2_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			char[] quiz = br.readLine().toCharArray();
			int result = 0;
			int cnt = 0; 
			for(int i = 0, size = quiz.length; i < size; i++) {
				if(quiz[i] == 'X') {
					cnt = 0;
					continue;
				}
				
				cnt++;
				result += cnt;
				
			}
			
			System.out.println(result);
		}
	}
}
