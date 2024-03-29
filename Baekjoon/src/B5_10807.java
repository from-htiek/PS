import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.12.06
 * 개수 세기
 */
public class B5_10807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[201];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			num[Integer.parseInt(st.nextToken()) + 100]++; 
		}
		
		int v = Integer.parseInt(br.readLine());
		
		System.out.println(num[v+100]);
	}
}
