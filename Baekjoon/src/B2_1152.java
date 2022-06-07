import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.06.07
 * 단어의 개수
 */
public class B2_1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			result++;
		}
		System.out.println(result);
	}
}
