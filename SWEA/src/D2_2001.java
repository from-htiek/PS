import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.04
 * 파리 퇴치
 */
public class D2_2001 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc ++) {
			// n : 칸의 수, m : 파리채 크기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 배열 생성 후 입력
			int[][] files = new int[n][n];
			int result = 0; 

			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					files[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// n - m 까지 돌며 완전탐색
			for(int i = 0; i < n - m + 1; i++) {
				for(int j = 0; j < n - m + 1; j++) {
					int sum = 0;
					// 현재 위치에서 아래 위로 m칸
					for(int x = i; x < i + m; x++) {
						for(int y = j; y < j + m; y++) {
							sum += files[x][y];
						}

					}
					result = Math.max(sum, result);
				}
			}

			System.out.printf("#%d %d\n", tc, result);
		}

	}
}
