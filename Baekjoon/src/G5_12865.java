import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.05.07
 * 평범한 배낭
 */
public class G5_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 물품 수
		int k = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게 
		
		int[] w = new int[n+1]; // 각 물건의 무게
		int[] v = new int[n+1]; // 각 물건의 가치
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int [n+1][k+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= k; j++) {
				if(w[i] > j) dp[i][j] = dp[i-1][j]; // 물건을 담을 수 없을 때 
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]); // 물건을 담을 수 있을 때 => 넣을 수 있는만큼 최대한 넣기
				}
			}
		}
		
//		for(int[] d : dp) {
//			System.out.println(Arrays.toString(d));
//		}
		
		System.out.println(dp[n][k]);
		
		
	}
}
