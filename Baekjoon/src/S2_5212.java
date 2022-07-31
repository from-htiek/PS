import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2022.07.31
 * 지구 온난화
 */
public class S2_5212 {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 지도의 크기
		int c = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[r][c];
		char[][] _map = new char[r][c];
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
			
		int miny = r-1;  // 모든 섬을 포함하는 가장 작은 직사각형을 그리기 위한 범위 체크 
		int minx = c-1;
		int maxy = 0;
		int maxx = 0;  
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'X') {
					int cnt = 0; // 인접한 바다의 수 세기 
					
					for(int d = 0; d < 4; d++) { // 4방위 탐색 
						int newy = i + dy[d];
						int newx = j + dx[d];
						
						if(newy < 0 || newy >= r || newx < 0 || newx >= c) { // 범위 벗어나면 바다
							cnt++;
							continue;
						}
						if(map[newy][newx] == 'X') continue; // 바다가 아니면 제외
						cnt++; 
					}
					
					if(cnt < 3) { // 주위에 바다가 3면 미만이면 섬
						_map[i][j] = 'X'; 
						miny = Math.min(miny, i);
						minx = Math.min(minx, j);
						maxy = Math.max(maxy, i);
						maxx = Math.max(maxx, j);
					}else { // 3면 이상이면 바다
						_map[i][j] = '.';
					}
				}else {
					_map[i][j] = '.';
				}
			}
		}


		for(int i = miny; i <= maxy; i++) {
			for(int j = minx; j <= maxx; j++) {
				System.out.printf("%c", _map[i][j]);
			}
			System.out.println();
		}
		
				
	}
}
