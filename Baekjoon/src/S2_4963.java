import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.02.23
 * 섬의 개수
 */
public class S2_4963 {
	static int h, w, map[][], dy[], dx[];
	static boolean[][] visitied;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break; // 0 0 입력 : 종료
			
			dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1}; // 8방위
			dx = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
			map = new int[h][w]; // 지도
			visitied = new boolean[h][w]; // 방문 체크  
			int cnt = 0; // 섬의 개수
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++ ) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 0) visitied[i][j] = true; // 바다는 방문 불가능
				}

			}
			
			
			// 한번 방문 할 때 갈 수 있는 섬을 모두 방문하므로 
			// 방문 횟수를 세면 섬의 개수가 됨
			for(int i = 0; i < h; i++) {
				for(int j = 0; j <w; j++) {
					if(!visitied[i][j]) { 
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
	public static void dfs(int y, int x) {

		
		for(int i = 0; i < 8; i++) { // 8가지 방향으로 탐색
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			// 인덱스 범위 넘지 않기  && 아직 방문 하지 않음 
			if(newX >= 0 && newX < w && newY >= 0 && newY < h && !visitied[newY][newX]) {
				visitied[newY][newX] = true;
				dfs(newY, newX); 
			}
		}
	}
}
