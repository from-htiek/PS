import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.05.04
 * 침투
 */
public class S2_13565 {
	static int m, n, map[][];
	static boolean[][] visitied;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 격자 세로 크기
		n = Integer.parseInt(st.nextToken()); // 격자 세로 크기
		map = new int[m][n]; // 섬유 
		visitied = new boolean[m][n]; // 방문 체크 
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			if(!visitied[0][i] && map[0][i] == 0) {
				if(bfs(0, i)) {
					System.out.println("YES");
					return;
				}
			}
		}
		
		System.out.println("NO");
	}
	
	// bfs
	public static boolean bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		visitied[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
 			for(int d = 0; d < 4; d++) { // 4방위 탐색
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= m || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(map[newy][newx] == 1) continue; // 전류가 통할 수 없으면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true;
				if(newy == m-1) return true; // inner side에 도착하면 return 
				
			}
		}
		
		return false; 
	}
}
