import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_baseStation2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine()); // 배열 크기
			
			char[][] map = new char[n][];
			for(int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			
			int newy, newx;
			
			// 기지국 찾기
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] >= 'A' && map[i][j] <= 'C') {
						
						// 지기국 주변 4방 탐색 
						for(int l = 1; l <= (map[i][j]-'A')+1; l++) {
							
							// 기지국 유형만큼 칸 탐색
							for(int k = 0; k < 4; k++) {
							
								newy = i + l*dy[k];
								newx = j + l*dx[k];
								
								if(newy >= 0 && newy < n && newx >= 0 && newx < n && map[newy][newx] == 'H') {
									map[newy][newx] = 'X';
									
								}
							}
							
						}
					}
				}
			}
			
			
			// 커비되지 않은 집의 수 세기
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 'H') cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
			
		}
		
	}
}
