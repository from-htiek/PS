import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.04.30
 * 음식물 피하기
 */
public class S1_1743 {
	static int n, m, map[][], result, cnt;
	static boolean visitied[][];
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 통로 세로 길이 
		m = Integer.parseInt(st.nextToken()); // 통로 가로 길이
		map = new int[n][m]; // 통로를 나타내는 배열 
		visitied = new boolean[n][m]; // 방문 체크
		result = 0; // 가장 큰 음식물 크기
		
		int k = Integer.parseInt(st.nextToken()); // 음식물 개수
		for(int i = 0; i < k; i++) { // 음식물 위치 표시
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			map[y-1][x-1] = 1; 
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visitied[i][j] && map[i][j] == 1) {
					cnt = 0; 
					dfs(i, j); // 체크하지 않은 음식물일때만 dfs 
				}
			}
		}
		
		System.out.println(result);

		
	}
	
	static void dfs(int y, int x) { // dfs
		
		visitied[y][x] = true;
		cnt++; 
		result = Math.max(cnt, result);
		
		for(int d = 0; d < 4; d++) { // 4방위 탐색
			int newy = y + dy[d];
			int newx = x + dx[d];
			
			if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외 
			if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
			if(map[newy][newx] == 0) continue; // 일반 통로라면 제외 
			dfs(newy, newx); // 쓰레기 크기  +1
			
		}

		
	}
}
