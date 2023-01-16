import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2023.01.16
 * 먹을 것인가 먹힐 것인가
 */
public class S3_7795 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] a = new int[n];
			int[] b = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			n--;
			m--;
			int result = 0;
			while(m >= 0) {
				
				if(a[n] > b[m]) {
					result += (m+1);
					n--;
				}else {
					m--;
				}
				
				if(n < 0 || m < 0) break;
			}
			
			sb.append(result).append("\n");
			
			
		}
		
		System.out.println(sb.toString());
	}
}
