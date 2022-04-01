import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.01
 * 벽 부수고 이동하기
 */
public class G4_2206 {
	static class pos{
		int y;
		int x;
		int wall;
		
		public pos(int y, int x, int wall) {
			this.y = y;
			this.x = x;
			this.wall = wall;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		int[] dy = {0, 0, 1, -1}; // 4방위 탐색
		int[] dx = {1, -1, 0, 0};
		
		int result = 0; // 최단거리
		Queue<pos> q = new LinkedList<>();
		boolean[][][] visitied= new boolean[n][m][2]; // 방문체크 (벽통과 했을 때와 아닐때 [2])
		q.offer(new pos(0, 0, 0));
		visitied[0][0][0] = true; 
		
		// bfs 
		while(!q.isEmpty()) {
			result++;
			int size = q.size();
			while(size-->0) {
				pos cur = q.poll();
//				System.out.println("cur : " + cur.y + " " + cur.x + " " + cur.wall);
				if(cur.y == n-1 && cur.x == m-1 ) { // 도착했다면 츌력
					System.out.println(result);
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int newy = cur.y + dy[d];
					int newx = cur.x + dx[d];
					
					if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
					if(visitied[newy][newx][cur.wall]) continue; // 이미 방문했다면 제외
					
					if(map[newy][newx] == 1 && cur.wall == 0) { // 벽을 만났는데 통과할 수 있을때
						q.offer(new pos(newy, newx, 1));
						visitied[newy][newx][1] = true;
//						System.out.println("벽O : " + newy + " " + newx);
						continue;
					}
					
					if(map[newy][newx] == 1 && cur.wall == 1) continue; // 벽을 만났지만 통과할 수 없을 때
					
					q.offer(new pos(newy, newx, cur.wall));
					visitied[newy][newx][cur.wall] = true; 
//					System.out.println("벽x : " + newy + " " + newx);
					
				}
			}
			
		}
		
		System.out.println(-1);
		
	}
}
