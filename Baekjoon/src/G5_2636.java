import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.05.05
 * (다시 푸는) 치즈
 * 판의 가장자리가 0이므로, (0,0)부터 탐색하면 모든 공기에 노출되어 있는 치즈를 탐색할 수 있음
 */
public class G5_2636 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 판 가로 길이
		int m = Integer.parseInt(st.nextToken()); // 세로 세로 길이
		int[][] map = new int[n][m];
		int total = 0; // 총 치즈 개수
		int time = 0; // 치즈가 모두 녹아서 없어지는 데 걸리는 시간
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) total++; 
			}
		}

		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		int cnt = 0; // 하루 동안 녹는 치즈 수
		
		while(total > 0) { // 치즈가 남아 있을 때 가지 반복
			time++; // 한시간 흐름
			
			Queue<int[]> q = new LinkedList<>(); 
			boolean[][] visitied = new boolean[n][m]; // 방문체크 
			q.offer(new int[] {0, 0});
			visitied[0][0] = true;
			cnt = 0; 

			// bfs 
			while(!q.isEmpty()) {
				int[] cur = q.poll();

				for(int d = 0; d < 4; d++) { // 4방위 탐색 
					int newy = cur[0] + dy[d];
					int newx = cur[1] + dx[d];

					if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어났으면 제외
					if(visitied[newy][newx]) continue;  // 이미 방문했다면 제외 

					if(map[newy][newx] == 1) { // 치즈가 있으면 녹이기 
						map[newy][newx] = 0;
						cnt++;
						visitied[newy][newx] = true; 
					} else { // 그렇지 않다면 탐색
						q.offer(new int[] {newy, newx});
						visitied[newy][newx] = true; 
					}

				}
			}

			total -= cnt; // 남은 치즈 수 갱신 
		}

		System.out.println(time);
		System.out.println(cnt);
		

	}
}
