import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.09.11
 * 이동하기
 * DP라는걸 알고풀지않았다면 DP로 풀었을까?
 */
public class S1_11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][m];
		dp[0][0] = map[0][0];
		
		int[] dy = {-1, -1, 0}; // 3가지 방향
		int[] dx = {0, -1, -1};
 		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int d = 0; d < 3; d++) {
					int newy = i + dy[d];
					int newx = j + dx[d];
					
					if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
					if(dp[i][j] > map[i][j] + dp[newy][newx]) continue; // 기존 dp 테이블의 값보다 작다면 제외
					
					dp[i][j] = map[i][j] + dp[newy][newx]; // 크면 값 갱신 
				}
			}
		}
		
		System.out.println(dp[n-1][m-1]);
		
	}
}
