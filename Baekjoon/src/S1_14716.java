import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.06.06
 * 현수막
 */
public class S1_14716 {
	static int m, n, map[][];
	static boolean visitied[][];
	static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
	static int[] dx = {1, 0, -1, 1, -1, 1, 0, -1}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visitied = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		int result = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visitied[i][j] && map[i][j] == 1) {
					result++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int y, int x) {
		visitied[y][x] = true;
		
		for(int d = 0; d < 8; d++) {
			int newy = y + dy[d];
			int newx = x + dx[d];
			
			if(newy < 0 || newy >= m || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
			if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
			if(map[newy][newx] == 0) continue; // 글자가 아니라면 제외 
			
			dfs(newy, newx);
		}
	}
}
