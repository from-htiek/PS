import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.03.07
 * 유기농 배추
 */
public class S2_1012 {
	
	static int m, n, field[][], dy[], dx[]; 
	static boolean visitied[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine()); // 테스트 케이스

		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
			n = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
			int k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치 개수

			field = new int[n][m]; // 배추 밭
			visitied = new boolean[n][m]; // 방문체크
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				field[y][x] = 1;
			}
			
			dy = new int[]{1, -1, 0, 0};
			dx = new int[]{0, 0, 1, -1};

			// 입력 확인
//			for(int[] f : field) {
//				System.out.println(Arrays.toString(f));
//			}
			
			int cnt = 0; // 필요한 최소의 배추흰지렁이 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(field[i][j] == 1 && !visitied[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
	public static void dfs(int y, int x) {
		visitied[y][x] = true;
		
		for(int i = 0; i < 4; i++) { // 4방위 탐색
			int newy = y + dy[i];
			int newx = x + dx[i];
			
			// 범위 벗어나지 않음 & 아직 방문하지 않음 & 배추 있음
			if(newy >= 0 && newy < n && newx >= 0 && newx < m && !visitied[newy][newx] && field[newy][newx] == 1) {
				dfs(newy, newx);
			}
		}
		
	}
}
