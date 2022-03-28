import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 2022.03.28
 * 인구 이동
 */
public class G5_16234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = {0, 0, 1, -1}; // 4방위 이동
		int[] dx = {1, -1, 0, 0};
		int result = 0; // 인구이동이 며칠동안 발생하는지

		while(true) { // 인구이동이 일어나지 않을때까지 반복 
			boolean[][] visitied = new boolean[n][n]; // 인접한 나라와 인구차이 계산했는지 체크 
			int check = 0; // 인구 이동이 일어났는지 체크
			result++;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					// bfs 
					if(!visitied[i][j]) {
						Queue<int[]> q = new LinkedList<>();
						ArrayList<int[]> list = new ArrayList<>(); // 연합의 값을 계산한 후, 나라들에 다시 계산값 넣어주기 위해 list 할당
						visitied[i][j] = true;
						q.offer(new int[] {i,j});
						list.add(new int[] {i,j});
						int cnt = 0; // 연합이 이루어 졌을 때, 그 연합의 나라 수
						int sum = 0; // 연합의 인구 합 

						cnt++;
						sum += map[i][j];

						while(!q.isEmpty()) {
							int[] cur = q.poll();

							for(int d = 0; d < 4; d++) {
								int newy = cur[0] + dy[d];
								int newx = cur[1] + dx[d];

								if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어났으면 제외
								if(visitied[newy][newx]) continue; // 방문 했으면 제외
								if(Math.abs(map[cur[0]][cur[1]]-map[newy][newx]) < l 
										|| Math.abs(map[cur[0]][cur[1]]-map[newy][newx]) > r) continue; // 국경이 열리지 않으면 제외
								

								visitied[newy][newx] = true; 
								q.offer(new int[] {newy,newx});
								list.add(new int[] {newy,newx});
								cnt++;
								sum += map[newy][newx];
								check++; // 인구 이동 일어났는지 체크

							}
						}

//						System.out.println("cnt : " + cnt + " sum : " + sum);

						int num = sum/cnt; // 연합의 값 계산
						for(int k = 0; k < list.size(); k++) {
							int[] cur = list.get(k);
							map[cur[0]][cur[1]] = num;
						}

					}


				}
			}
			
			if(check == 0) { // 인구 이동이 한번도 일어나지 않았다면 멈춤
				break;
			}
//			System.out.println("check : " + check);
//			System.out.println(Arrays.deepToString(map));
		}
		
		System.out.println(result-1); // 마지막 인구이동을 체크하기 위해 한번 더 while문을 돌았으므로 -1
	}
}
