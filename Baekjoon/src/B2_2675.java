import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.07.07
 * 문자열 반복
 */
public class B2_2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(int i = 0; i < s.length(); i++) {
				for(int j = 0; j < r; j++) {
					sb.append(s.charAt(i));
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
