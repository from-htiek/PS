import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.01.21
 * 라디오
 */
public class S5_3135 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		int result = Math.abs(b-a);
		
		for(int i = 0; i < n; i++) {
			result = Math.min(result, Math.abs(b-list[i])+1);
		}
		
		System.out.println(result);
	}
}
