import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.08.31
 * 전쟁 - 전투
 */
public class S1_1303 {
	public static int n, m;
	public static char map[][];
	public static boolean visitied[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 전쟁터의 가로 크기
		m = Integer.parseInt(st.nextToken()); // 전쟁터의 세로 크기
		map = new char[m][n];
		visitied = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		int my = 0;
		int enemy = 0; 
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visitied[i][j]) { // 아직 방문하지 않은 곳만 계산 
					int cnt = bfs(i, j, map[i][j]); // 색깔에 따라 결과 합산
					if(map[i][j] == 'W') my += cnt;
					else enemy += cnt;
				}
			}
		}
		
		System.out.println(my + " " + enemy);
		
	}
	
	public static int[] dy = {1, -1, 0, 0};
	public static int[] dx = {0, 0, 1, -1};
	public static int bfs(int y, int x, char color) {
		
		Queue<int[]> q = new LinkedList<>();
		visitied[y][x] = true; 
		q.offer(new int[] {y, x});
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			cnt++; // 몇 명인지 세기

			for(int d = 0; d < 4; d++) { // 4방위 탐색
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= m || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				if(map[newy][newx] != color) continue; // 색깔이 다르다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true; 
			}
			
		}
		
		return cnt*cnt; // 제곱 반환
	}
}
