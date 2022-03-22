import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.10
 * 빙산
 */
public class G4_2573 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		int result  = 0; // 시간

		while(true) {
			// 1년 후 빙산의 높이
			int[][] _map = new int[n][m]; // 1년 후 빙산 높이 저장할 임시 배열
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] != 0) { // 빙산일 때 
						int cnt = 0; // 주위 바다와 닿아있는 면의 개수
						for(int k = 0; k < 4; k++) { // 4방위 탐색 
							int newy = i + dy[k];
							int newx = j + dx[k];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외

							if(map[newy][newx] != 0) continue; // 바다가 아니면 제외

							cnt++; // 해당 빙하 주위에 바다가 몇개인지 체크
						}

						_map[i][j] = map[i][j] - cnt <= 0 ? 0 :  map[i][j] - cnt; // 바다수만큼 빼주기
					}
				}

			}
			
			result++; 
//			for(int[] i : _map) {
//				System.out.println(Arrays.toString(i));
//			}
			
			// bfs
			boolean[][] visitied = new boolean[n][m];
			Queue<int[]> q = new LinkedList<>();
			int cnt = 0; // 빙산의 덩어리
			int sea = 0; // 바다 면적
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(_map[i][j] != 0 && !visitied[i][j]) {
						
						cnt++; 
						q.offer(new int[]{i, j});
						visitied[i][j] = true;
						
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							//System.out.println(cur[0] + " " + cur[1]);
							for(int k = 0; k < 4; k++) {
								int newy = cur[0] + dy[k];
								int newx = cur[1] + dx[k];

								if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외

								if(visitied[newy][newx] == true) continue; // 이미 방문했다면 제외
								
								if(_map[newy][newx] == 0) continue; // 바다가 아니면 제외
								
								visitied[newy][newx] = true;
								q.offer(new int[] {newy, newx});	

							}
						}
					}else if(_map[i][j] == 0) sea++; 
				}
			}
			
			map = _map; // while문 돌기위한 재할당 

			if(cnt >= 2) { // 빙산이 2개 이상으로 분리됐다면 걸린 시간 출력
				System.out.println(result);
				break; 
			}else if(sea == m*n) { // 빙산이 다 녹았지만 2개 이상으로 분리되지 않았다면 0 출력
				System.out.println(0);
				break;
			}
			
			
		}
	}
}
