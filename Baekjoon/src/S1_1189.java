import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.11.26
 * 컴백홈
 */
public class S1_1189 {
	public static int r, c, k, result;
	public static char map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		result = 0; 
		
		dfs(r-1, 0, 1, new boolean[r][c]);
		System.out.println(result);
		
	}
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	// DFS
	public static void dfs(int y, int x, int cnt, boolean[][] visitied) {
		
		boolean[][] _visitied = new boolean[r][c]; // 방문 배열 복사
		for(int i = 0; i < r; i++) {
			_visitied[i] = visitied[i].clone();
		}
		
		_visitied[y][x] = true;
		
		if(cnt == k) {
			if(y == 0 && x == c-1) result++;
			return;
		}
		
//		if(y == 0 && x == c-1) {
//			if(cnt == k) result++; 
//			return; 
//		}

		for(int d = 0; d < 4; d++) {
			int newy = y + dy[d];
			int newx = x + dx[d];
			
			if(newy < 0 || newy >= r || newx < 0 || newx >= c) continue;
			if(visitied[newy][newx]) continue;
			if(map[newy][newx] == 'T') continue;
			
			dfs(newy, newx, cnt+1, _visitied);

		}
	}
	
}
