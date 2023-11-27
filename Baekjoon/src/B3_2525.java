import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.11.27
 * 오븐 시계
 */
public class B3_2525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()); // 시
		int b = Integer.parseInt(st.nextToken()); // 분
		int c = Integer.parseInt(br.readLine()); // 요리하는 데 걸리는 시간
		
		b += c; 
		
		while(b >= 60 || a >= 24) {
			if(b >= 60) {
				a++;
				b -= 60;
			}
		
			if(a >= 24) {
				a -= 24;
			}
		}
		
		System.out.println(a + " " + b);
	}
}
