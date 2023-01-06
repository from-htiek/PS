import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2023.01.06
 * 벼락치기
 * 와 냅색도 벌써 까마득해 큰일나따
 */
public class G5_14728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 시험 단원의 개수
		int t = Integer.parseInt(st.nextToken()); // 시험 공부 총 시간
		
		int[] time = new int[n+1]; // 단원 별 예상 공부 시간 배열
		int[] score = new int[n+1]; // 단원 문제의 배점 배열
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// knapsack
		int[][] dp = new int[n+1][t+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= t; j++) {
				if(time[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]]+score[i]);
		
			}
		}
		
		System.out.println(dp[n][t]);
		
		
	}
}
