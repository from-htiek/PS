import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.04.06
 * 0/1 Knapsack
 */
public class D3_3282 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] map = new int[n+1][2]; // 0 : 부피, 1 : 가치

			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[n+1][k+1];

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= k; j++) {
					if(j  < map[i][0]) { // 부피가 더 크면 넣을 수 없음 
						dp[i][j] = dp[i-1][j];
					} else { // 넣을 수 있다면, 넣지 않았을 때와 넣을 때 중 더 큰 값으로 갱신
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-map[i][0]] + map[i][1]);
					}

				}

			}
			
			sb.append("#").append(tc).append(" ").append(dp[n][k]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
