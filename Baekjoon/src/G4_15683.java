import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.10.26
 * 감시
 */
public class G4_15683 {
	public static class cctv {
		int y;
		int x;
		int version;
		
		public cctv(int y, int x, int version) {
			super();
			this.y = y;
			this.x = x;
			this.version = version;
		}

		@Override
		public String toString() {
			return "cctv [y=" + y + ", x=" + x + ", version=" + version + "]";
		}
	}
	
	public static int n, m, map[][], cctvCnt, order[], result;
	public static ArrayList<cctv> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) list.add(new cctv(i, j, map[i][j])); // cctv 리스트
			}
		}
		
		result = Integer.MAX_VALUE; // 사각지대의 최소 크기 
		cctvCnt = list.size(); // cctv 개수
		order = new int[cctvCnt]; 
		permutation(0);
		
		System.out.println(result);
	}
	
	// 중복 순열 생성
	public static void permutation(int idx) {
		if(idx == cctvCnt) {
//			System.out.println(Arrays.toString(order));
			result = Math.min(result, monitor()); // 최소값 갱신 
			return;
		}
		
		if(list.get(idx).version == 2) { // 2번 cctv는 방향 경우의 수 2개
			for(int i = 0; i < 2; i++) {
				order[idx] = i;
				permutation(idx+1);
			}
		}else if(list.get(idx).version == 5) { // 5번 cctv는 경우의 수 1개
			order[idx] = 0;
			permutation(idx+1);
		}else {
			for(int i = 0; i < 4; i++) { // 나머지는 경우의 수 4개
				order[idx] = i;
				permutation(idx+1);
			}	
		}
	}
	
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dx = {1, 0, -1, 0};
	public static int monitor() {
		
		int[][] _map = new int[n][m]; // 기존 map 복사
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				_map[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < cctvCnt; i++) {
			int cury = list.get(i).y;
			int curx = list.get(i).x;
			int curVer = list.get(i).version;
			
			for(int d = 0; d < 4; d++) { // 4방위 탐색
				int newy = cury;
				int newx = curx;
				if(curVer == 1 && d > 0) continue; // 1번일 때는 한 방향만 탐색 
				if(curVer == 2 && (d == 1 || d == 3)) continue; // 2번일 때는 반대 방향까지 탐색
				if(curVer == 3 && d > 1) continue; // 3번일 때는 직각 방향만 탐색
				if(curVer == 4 && d == 3) continue; // 4번일 때는 한 방향 제외하고 모두 탐색 
				
				int dir = (order[i] + d) % 4; // 방향
				while(true) { // 벽에 닿거나 범위 벗어날 때 까지 감시
					newy += dy[dir];
					newx += dx[dir];

					if(newy < 0 || newy >= n || newx < 0 || newx >= m) break;
					if(_map[newy][newx] == 6) break; 
					if(_map[newy][newx] > 0 && _map[newy][newx] < 6) continue;
					_map[newy][newx] = -1; 
				}
			}
			

		}
	
		int cnt = 0;
		for(int i = 0; i < n; i++) { // 사각지대 개수 카운트
			for(int j = 0; j < m; j++) {
				if(_map[i][j] == 0) cnt++; 
			}
		}

		
		return cnt;
	}
}
