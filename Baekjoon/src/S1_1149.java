import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.03.31
 * RGB 거리
 */

public class S1_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n+1][3];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n+1][3];
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}

		
		int result = Math.min(dp[n][0], dp[n][1]);
		result = Math.min(result, dp[n][2]);
		System.out.println(result);
		
//		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
		
	}
}
