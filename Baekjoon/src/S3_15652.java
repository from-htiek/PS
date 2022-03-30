import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.03.30
 * N과 M(4)
 */
public class S3_15652 {
	static int n, m, num[], result[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n+1];
		result = new int[m];
		for(int i = 1; i <= n; i++) {
			num[i] = i;
		}
		
		func(0, 1);
		System.out.println(sb.toString());
	}
	
	public static void func(int idx, int start) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= n; i++) {
			result[idx] = num[i];
			func(idx+1, i);
		}
	}
}
