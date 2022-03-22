import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.12
 * 안전 영역
 */
public class S1_2468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n]; // 지역의 높이 
		int[] dy = {1, -1, 0, 0}; // 4방위
		int[] dx = {0, 0, 1, -1}; 
		// int min = Integer.MAX_VALUE; // 최저 높이
		int max = 0; // 최고 높이 
		int result = 0; // 안전한 영역 최대 개수
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		// min값에서 수정 => 0부터 탐색 (비가 오지않을 때 고려)
		// max높이는 탐색 X(모든 지역이 물에 잠김)
		for(int height = 0; height < max; height++) {
			
			// bfs
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visitied = new boolean[n][n]; // 방문 체크
			int cnt = 0; // 안전 영역 개수
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] > height && visitied[i][j] == false) {
						cnt++; 
						q.offer(new int[] {i, j});
						
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							
							for(int k = 0; k < 4; k++) {
								int newy = cur[0] + dy[k];
								int newx = cur[1] + dx[k];
								
								if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
								
								if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
								
								if(map[newy][newx] <= height) continue; // 잠긴다면 제외
								
								q.offer(new int[] {newy, newx});
								visitied[newy][newx] = true;
								
							}
						}
						
					}
				}
			}
			
			//System.out.println("cnt : " + cnt + " height : " + height);
			result = Math.max(result, cnt);
			
		}
		
		System.out.println(result);
		
		
	}
}
