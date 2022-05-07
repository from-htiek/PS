import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.05.07
 * 연구소
 * 
 * 2차원에서의 조합을 어떻게 만들어야할지 몰라서 한참 고민했던 문제. 결국 이 부분은 다른 코드를 참고했다.
 * https://bcp0109.tistory.com/15
 * 다른 분들 코드를 보디 3중 for문을 이용해서 푸는 경우가 많았다 
 */
public class G5_14502 {

	static int n, m, map[][], total, result;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static boolean[][] visitied;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 지도 세로 크기
		m = Integer.parseInt(st.nextToken()); // 지도 가로 크기
		map = new int[n][m]; // 지도
		total = 0; // 빈 칸의 수
		result = 0; // 안전 영역 최대 크기
		
		for(int i = 0; i < n; i++) { // 지도 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) total++; // 빈칸 수 세기
			}
		}


		total -= 3; // 빈칸에 벽을 3개 세워야 하므로 미리 빼줌 
		combi(0, 0);
		System.out.println(result);

	}

	// 벽을 3개 세우는 조합 찾기 
	public static void combi(int start, int cnt) {
		if(cnt == 3) { // 벽 3개를 다 세웠을 때 
			
			int safeZone = total; 
			visitied = new boolean[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 2 && !visitied[i][j]) { // 바이러스가 있고 아직 방문하지 않았을 때 퍼지는 바이러스 체크 
						safeZone -= bfs(i, j);
						
					}
				}
			}
			
			result = Math.max(result, safeZone); // 최대 안전 영역 크기 비교
			return;
		}


		for(int i = start; i < n*m; i++) {  // 벽 3개 세우는 조합 
			int y = i / m;
			int x = i % m;
			
			if(map[y][x] == 0) {
				map[y][x] = 1;
				combi(i+1, cnt+1);
				map[y][x] = 0; 
			}
		}
	}
	
	
	// bfs 
	public static int bfs(int y, int x) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {y, x});
		visitied[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) { // 4방위 탐색 
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				if(map[newy][newx] == 1) continue; // 벽이면 제외
				
				if(map[newy][newx] == 0) cnt++; // 빈칸이면 감염되므로 감염된 칸 세기
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true;
			}
		}
		
		return cnt; // 바이러스로 감염된 칸 수 리턴
  		
	}
}
