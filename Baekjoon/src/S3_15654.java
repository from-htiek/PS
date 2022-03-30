import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.30
 * N과 M(5) 
 */
public class S3_15654 {
	static int n, m, num[], result[];
	static boolean visitied[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		result = new int[m];
		visitied = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}	
		
		Arrays.sort(num);
		permutation(0);
		System.out.println(sb.toString());
	}
	
	public static void permutation(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visitied[i]) continue;
			
			result[idx] = num[i];
			visitied[i] = true;
			
			permutation(idx+1);
			visitied[i] = false;
		}
	}
}
