import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 22.10.03
 * 캐슬 디펜스
 * 그대로 구현하면 되는 코드 임에도 비효율적인 부분이 많다.
 * dy, dx 인덱스를 내 마음대로 써서, BFS의 장점을 이용하지 못했다.
 * 좌 -> 위 -> 우로 탐색했으면 종료 조건을 또 주지 않아도 됐을텐데.
 * 그리고 적군을 계속 위로 올려서 문제를 푼게 옳은 방법인가 생각이 든다. 아군 체크를 한번 해야하는 상황이..? 
 * 요즘 다른 사람들 코드가 눈에 더 안들어오는 느낌이라 큰일이다
 */
public class G3_17135 {
	static int n, m, d, map[][], position[], _map[][], result;
	static Queue<int[]> check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 격자판 행의 수
		m = Integer.parseInt(st.nextToken()); // 격자판 열의 수
		d = Integer.parseInt(st.nextToken()); // 공격 제한 거리
		result = 0; // 제거할 수 있는 적의 최대 수
		check = new LinkedList<>(); // 적의 위치를 담기 위한 큐
		
		map = new int[n+1][m];
		position = new int[3]; // 병사 위치 담는 배열
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(result);
		
	}
	
	
	// 병사 위치 조합 생성 
	public static void combination(int idx, int start) {
		if(idx == 3) {			
			int[] soldier = new int[m];
			for(int i = 0; i < 3; i++) {
				soldier[position[i]] = 1;
			}
			
			_map = new int[n+1][m]; // 기존 격자판과 같은 _map 복사 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					_map[i][j] = map[i][j];
				}
			}
			
			int cnt = 0; // 제거할 수 있는 적의 수 세기 
			for(int i = n; i >= 0; i--) { // 성벽에 가까운 위치에서부터 병사 배치
				_map[i] = soldier;
				
				for(int j = 0; j < 3; j++) { // 병사 위치에서 제거할 수 있는 적 위치 찾기
					bfs(i, position[j]);
				}
				
				while(!check.isEmpty()) { // 적 위치 
					int[] cur = check.poll();
//					System.out.println(cur[0] + " : " + cur[1]);
					if(_map[cur[0]][cur[1]] == 0) continue; // 이미 제거한 적은 세지 않음 
					_map[cur[0]][cur[1]] = 0; // 제거한 적 표시 
					cnt++;
				}
				
			}

			
			result = Math.max(result, cnt);			
			return;
		}
		
		for(int i = start; i < m; i++) {
			position[idx] = i;
			combination(idx+1, i+1);
		}
	}
	
	public static int[] dy = {-1, 0, 0};
	public static int[] dx = {0, 1, -1};
	public static void bfs(int y, int x) {
		
		boolean[][] visitied = new boolean[n+1][m];
		visitied[y][x] = true;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x, 0});
		
		int checky = -1; // 적의 y 좌표
		int checkx = -1; // 적의 x 좌표
		int checkd = 9999; // 적과의 거리
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			if(_map[cur[0]][cur[1]] == 1) { // 적이 있으면서 
				if(cur[0] != y && (cur[2] < checkd || (cur[2] == checkd && checkx > cur[1]))) { // 거리가 더 짧거나, x좌표가 더 작을 때 
					checky = cur[0];
					checkx = cur[1];
					checkd = cur[2];
				}
			}
			
			for(int dir = 0; dir < 3; dir++) { // 3방향 탐색
				int newy = cur[0] + dy[dir];
				int newx = cur[1] + dx[dir];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				if(newy == y) continue; // 아군이라면 제외
				if(Math.abs(y - newy) + Math.abs(x - newx) > d) continue; // 쏠 수 없는 적이라면 제외
				
				q.offer(new int[] {newy, newx, Math.abs(y - newy) + Math.abs(x - newx)});
				visitied[newy][newx] = true; 
			}
			
		}
		
		if(checky != -1 && checkx != -1) {
			check.offer(new int[] {checky, checkx});
		}
		
	}
	
	
}
