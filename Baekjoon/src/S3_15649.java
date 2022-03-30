import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.30
 * N과 M(1)
 * 
 * StringBuilder를 사용하면 속도가 많이 줄어든당
 
 */
public class S3_15649 {
	static int n, m, num[], result[];
	static boolean visitied[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n+1];
		result = new int[m];
		visitied = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			num[i] = i;
		}
		
		permutation(0);
		System.out.println(sb.toString());
		
	}
	
	// 순열
	public static void permutation(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i = 1; i <= n; i++) {
			if(visitied[i]) continue;
			
			visitied[i] = true; 
			result[idx] = num[i];
			
			permutation(idx+1);
			visitied[i] = false; 

		}
	}
}
