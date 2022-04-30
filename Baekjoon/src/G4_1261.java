import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.30
 * 알고스팟
 * 
 * visitied 배열을 만들어서 도착점에 도착할 때 까지 부수어야하는 최소 벽의 수를 카운트했다
 * 다른 분들의 코드에서 본 것 중에 기억에 남는거 deque를 이용해서 벽이 없을 때는 addfirst, 벽이 있을 때는 addlast를 해서 
 * 벽을 최소로만 뚫을 수 있게 이동한 뒤 도착점에 도착하면 break 하는 코드
 *  
 */
public class G4_1261 {
	static class pos{
		int y;
		int x;
		int cnt; // y, x지점에 도착하기 위해 부수어야하는 벽의 수
		
		public pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 미로 가로 크기
		int m = Integer.parseInt(st.nextToken()); // 미로 세로 크기
		int[][] map = new int[m][n]; // 미로
		int[][] visitied = new int[m][n]; // 부순 벽의 개수 체크
		
		for(int i = 0; i < m; i++) {
			String string = br.readLine();
			Arrays.fill(visitied[i], Integer.MAX_VALUE); // visitied를 max값으로 채우기
			for(int j = 0; j < n; j++) {
				map[i][j] = string.charAt(j) - '0';
			}
		}
		
		
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(0, 0, 0));
		int result = Integer.MAX_VALUE; // 부수어야 하는 최소 벽의 개수
		
		// bfs
		while(!q.isEmpty()) {
			pos cur = q.poll();

			if(cur.y == m-1 && cur.x == n-1) { // 도착했다면 
				result = Math.min(result, cur.cnt); // 최소값 비교
			}
			
			for(int d = 0; d < 4; d++) { // 4방위 탐색 
				int newy = cur.y + dy[d];
				int newx = cur.x + dx[d];
				
				if(newy < 0 || newy >= m || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				
				
				if(map[newy][newx] == 0) { // 벽이 없을 때
					if(visitied[newy][newx] > cur.cnt) { 
						visitied[newy][newx] = cur.cnt;
						q.offer(new pos(newy, newx, cur.cnt));
					}
				}else if (map[newy][newx] == 1){ // 벽이 있을 때 
					if(visitied[newy][newx] > cur.cnt +1) {
						visitied[newy][newx] = cur.cnt + 1; 
						q.offer(new pos(newy, newx, cur.cnt+1));
					}
						
				}

			}
		}
		
		System.out.println(result);
		
	}
}
