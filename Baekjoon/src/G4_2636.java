import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.03.30
 * 치즈
 * 
 * 구현하고보니 내가 푼 방법은 한번 더 꼬아 생각해서 푼 방법인듯하다.
 * 판의 가장자리는 항상 0이니까, (0,0)부터 bfs를 돌려서 닿는 부분을 모두 없애주면 
 * 치즈에 구멍이 있는지 없는지도 구할필요가 없는 문제였다! 
 */
public class G4_2636 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int map[][] = new int[r][c];
		int total = 0; // 총 치즈 개수
		int result = 0; // 치즈가 모두 녹아 없어지는 시간

		// 입력
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) total++; // 총 치즈 개수 구하기 
			}
		}


		int dy[] = {0, 0, 1, -1}; // 4 방위 탐색
		int dx[] = {1, -1, 0, 0};
		while(true) { // 치즈가 모두 없어질때까지 반복 
			result++;
			
			// 1. 치즈에 구멍이 있는지 체크
			boolean visitied[][] = new boolean[r][c];
			Queue<int[]> q = new LinkedList<>();
			ArrayList<int[]> list = new ArrayList<>(); // 치즈가 없는 범위를 list에 넣고, 구멍이라면 list에 들어있는 좌표에 구멍 표시
			boolean flag = false; // 치즈안의 구멍인지 그냥 공기인지 체크
			
			for(int i = 1; i < r-1; i++) {
				for(int j = 1; j < c-1; j++) {
					if(map[i][j] == 0 && !visitied[i][j]) { // 치즈가 없는데 아직 방문 하지 않았다면
						//list = new ArrayList<>();
						q.offer(new int[] {i, j});
						list.add(new int[] {i, j});
						visitied[i][j] = true;
						flag = false;
						
						while(!q.isEmpty()) { // bfs => 인접한 치즈 없는 부분 모두 체크
							int cur[] = q.poll();

							for(int d = 0; d < 4; d++) {
								int newy = cur[0] + dy[d];
								int newx = cur[1] + dx[d];

								if(newy == 0 || newy == r-1 || newx == 0 || newx == c-1) { // 벽에 닿았다면(= 공기에 노출되어 있다면) 구멍이 아님 
									list.clear(); // 리스트 초기화
									flag = true;
								}

								if(newy < 1 || newy >= r-1 || newx < 1 || newx >= c-1) continue; // 범위 벗어나면 제외
								if(map[newy][newx] == 1) continue; // 치즈 있다면 제외
								if(visitied[newy][newx]) continue; // 이미 방문했다면 제외

								visitied[newy][newx] = true;				
								q.offer(new int[] {newy, newx});
								if(!flag) list.add(new int[] {newy, newx}); // 공기에 노출되지 않았을 때만 list에 넣기 
							}

						}
					}

					if(!flag) { // 구멍은 2로 표시 
						for(int k = 0; k < list.size(); k++) {
							int holey = list.get(k)[0];
							int holex = list.get(k)[1];

							map[holey][holex] = 2;
						}
					}

					list.clear();

				}


			}

			// 치즈 구멍 판별 끝
/*			for(int[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			System.out.println();*/
			
			// 2. 녹아 없어진 치즈 체크
			int[][] _map = new int[r][c]; // 공기에 노출된 부분을 체크하기 위해 같은 크기의 배열 만들기 


			int cnt = 0; // 현재 시간에 공기에 노출되어 없어지는 치즈 세기
			for(int i = 1; i < r-1; i++) {
				for(int j = 1; j < c-1; j++) {
					if(map[i][j] == 1) { // 치즈인데 
						for(int d = 0; d < 4; d++) {
							int newy = i + dy[d];
							int newx = j + dx[d];

							if(newy < 0 || newy >= r || newx < 0 || newx >= c) continue; // 범위 벗어나면 제외
							if(map[newy][newx] == 0) { // 공기에 닿아있다면 카운트 
								cnt++;
								break;

							}

							if(d == 3) _map[newy][newx] = 1; // 4방위 모두 치즈나 치즈 구멍으로 둘러싸여있다면 녹지않으므로 치즈로 표시
						}
					}
					
				}
			}
			
			map = _map; // 반복문을 돌기 위한 재할당
			total -= cnt;  // 전체 치즈 개수에서 1시간 동안 녹아 없어진 치즈 빼기 
			
/*			for(int[] m : _map) {
				System.out.println(Arrays.toString(m));
			}
			System.out.println();*/
			
			if(total == 0) { // 치즈가 다 없어졌다면 반복문 멈춤 
				System.out.println(result);
				System.out.println(cnt);
				break; 
			}
			
		}
	}
}
