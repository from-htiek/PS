import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.11.29
 * 꼬마 정민
 */
public class B5_11382 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long a = Long.parseLong(st.nextToken());
		Long b = Long.parseLong(st.nextToken());
		Long c = Long.parseLong(st.nextToken());
		
		System.out.println(a + b + c);
		
	}
}
