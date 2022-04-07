import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.07
 * 탈주범 검거
 * 
 * 코드가 비슷한 부분이 많은데 이걸 줄일 수 있는 방법이 없을까 음
 */
public class Test_1953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 터널 세로 크기
			int m = Integer.parseInt(st.nextToken()); // 터널 가로 크기
			int r = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 행 위치
			int c = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 열 위치
			int l = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간 

			int[][] map = new int[n][m]; 
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] dy = {-1, 1, 0, 0}; // 위, 아래,  좌, 우
			int[] dx = {0, 0, -1, 1}; 

			int cnt = 1;
			int time = 1; 
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visitied = new boolean[n][m]; // 방문 체크 배열 
			q.offer(new int[] {r, c}); // 뚜껑 위치 
			visitied[r][c] = true;			

			while(!q.isEmpty()) {
				if(time == l) break; // 시간이 다 됐으면 멈춤 
				int size = q.size();
				while(size-->0) {
					int[] cur = q.poll();
					int type = map[cur[0]][cur[1]];
					int newy, newx; 
					switch(type) {
					case 1 :
						for(int d = 0; d < 4; d++) {
							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 
							if(d == 0) {
								if(map[newy][newx] == 3 || map[newy][newx] == 4 || map[newy][newx] == 7) continue;
							}

							if(d == 1) {
								if(map[newy][newx] == 3 || map[newy][newx] == 5 || map[newy][newx] == 6) continue;
							}

							if(d == 2) {
								if(map[newy][newx] == 2 || map[newy][newx] == 6 || map[newy][newx] == 7) continue;
							}

							if(d == 3) {
								if(map[newy][newx] == 2 || map[newy][newx] == 4 || map[newy][newx] == 5) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 
						}
						break; 
					case 2 :
						for(int d = 0; d < 2; d++) {
							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 
							if(d == 0) {
								if(map[newy][newx] == 3 || map[newy][newx] == 4 || map[newy][newx] == 7) continue;
							}

							if(d == 1) {
								if(map[newy][newx] == 3 || map[newy][newx] == 5 || map[newy][newx] == 6) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 
						}
						break; 
					case 3 : 
						for(int d = 2; d < 4; d++) {
							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 
							if(d == 2) {
								if(map[newy][newx] == 2 || map[newy][newx] == 6 || map[newy][newx] == 7) continue;
							}

							if(d == 3) {
								if(map[newy][newx] == 2 || map[newy][newx] == 4 || map[newy][newx] == 5) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 
						}
						break; 
					case 4 :
						for(int d = 0; d < 4; d++) {
							if(d == 1 || d == 2) continue; 

							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 

							if(d == 0) {
								if(map[newy][newx] == 3 || map[newy][newx] == 4 || map[newy][newx] == 7) continue;
							}

							if(d == 3) {
								if(map[newy][newx] == 2 || map[newy][newx] == 4 || map[newy][newx] == 5) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 
						}
						break; 
					case 5 :
						for(int d = 0; d < 4; d++) {
							if(d == 0 || d == 2) continue; 

							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 

							if(d == 1) {
								if(map[newy][newx] == 3 || map[newy][newx] == 5 || map[newy][newx] == 6) continue;
							}

							if(d == 3) {
								if(map[newy][newx] == 2 || map[newy][newx] == 4 || map[newy][newx] == 5) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 
						}
						break; 
					case 6:
						for(int d = 0; d < 4; d++) {
							if(d == 0 || d == 3) continue; 

							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 

							if(d == 1) {
								if(map[newy][newx] == 3 || map[newy][newx] == 5 || map[newy][newx] == 6) continue;
							}

							if(d == 2) {
								if(map[newy][newx] == 2 || map[newy][newx] == 6 || map[newy][newx] == 7) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 

						}
						break; 
					case 7 :
						for(int d = 0; d < 4; d++) {
							if(d == 1 || d == 3) continue; 

							newy = cur[0] + dy[d];
							newx = cur[1] + dx[d];

							if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
							if(visitied[newy][newx]) continue; 
							if(map[newy][newx] == 0) continue; 

							if(d == 0) {
								if(map[newy][newx] == 3 || map[newy][newx] == 4 || map[newy][newx] == 7) continue;
							}

							if(d == 2) {
								if(map[newy][newx] == 2 || map[newy][newx] == 6 || map[newy][newx] == 7) continue;
							}

							cnt++; 
							q.offer(new int[] {newy, newx});
							visitied[newy][newx] = true; 

						}
						break; 


					}

					//					System.out.println(q);
				}

				time++; 
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");

		}

		System.out.println(sb.toString());
	}
}
