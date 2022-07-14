import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.07.14
 * 데스 나이트
 */
public class S1_16948 {
	
	public static class pos{
		int y, x, cnt;

		public pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
				
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()); // 출발 지점 
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken()); // 도착 지점
		int y2 = Integer.parseInt(st.nextToken());
		
		boolean[][] visitied = new boolean[n][n]; // 방문 체크 
		int[] dy = {-1, 1, -2, 2, -1, 1}; // 나이트 이동 방향
		int[] dx = {-2, -2, 0, 0, 2, 2};
		
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(y1, x1, 0));
		visitied[y1][x1] = true;
		
		int result = -1; 
		
		while(!q.isEmpty()) {
			pos cur = q.poll();
			
			if(cur.y == y2 && cur.x == x2) { // 도착했다면 멈춤
				result = cur.cnt;
				break; 
			}
			
			for(int d = 0; d < 6; d++) {
				int newy = cur.y + dy[d];
				int newx = cur.x + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				
				q.offer(new pos(newy, newx, cur.cnt+1));
				visitied[newy][newx] = true; 
			}
			
		}
		
		System.out.println(result);
		
	}
}
