import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 2022.02.11
 * 사칙연산 유효성검사
 */
public class D4_1233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int result = 1;
			char ch = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				ch = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					if(ch >= 48) result = 0;
					st.nextToken();
					st.nextToken();
				}else {
					if(ch < 48) result = 0;
				}
				
			}
			
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
