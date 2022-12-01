import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.12.01
 * 보물섬
 */
public class G5_2589 {
	static int n, m;
	static char map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지도 세로 길이 
		m = Integer.parseInt(st.nextToken()); // 지도 가로 길이
		
		map = new char[n][m]; // 보물섬 지도 
		int result = 0; // 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'L') {
					result = Math.max(result, bfs(i, j));
				}
			}
		}
		
		System.out.println(result);
		
		
	}
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	// bfs 
	static int bfs(int y, int x) {
		
		int max = 0; 
		boolean[][] visitied = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x, 0});
		visitied[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			max = Math.max(cur[2], max);
			for(int d = 0; d < 4; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
				if(visitied[newy][newx]) continue;
				if(map[newy][newx] == 'W') continue;
				
				visitied[newy][newx] = true;
				q.offer(new int[] {newy, newx, cur[2]+1});
			}
		}
		
		return max;
	}
}
