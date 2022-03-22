import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.02.25
 * 저수지의 물의 총 깊이 구하기
 */
public class D3_7236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			char[][] map = new char[n][n];
			int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // 8방위
			int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
			for(int i = 0; i < n; i++) {
				String string = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = string.charAt(j*2);
				}
			}

			
			int result = 0;
			
			for(int i = 1; i <= n-2; i++) {
				for(int j = 1; j <= n-2; j++) {

					if(map[i][j] == 'G') continue; // 땅이면 계산 X 
					int cnt = 0;
					for(int k = 0; k < 8; k++) { // 저수지일 때, 8방위 탐색
						int newy = i + dy[k];
						int newx = j + dx[k];

						if(map[newy][newx] == 'G') {
							cnt++;
						}
					}
					
					if(cnt == 8) cnt = 7; // 모두 땅일 때, 깊이는 1이므로 7로 바꿔줌
					cnt = 8 - cnt;
					result = Math.max(cnt, result);

				}
			}
			
			System.out.printf("#%d %d", tc, result);
		}
		
		
	}
}
