import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.06.27
 * 숫자 카드 2
 */
public class S3_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] list = new int[20_000_001];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			list[Integer.parseInt(st.nextToken()) + 10_000_000]++; 
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			sb.append(list[Integer.parseInt(st.nextToken()) + 10_000_000]).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
	}
}
