import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2022.02.23
 * 적록색약
 */
public class G5_10026 {
	static int n, dy[], dx[], resDolta, resNormal;
	static char colors[][];
	static boolean vDolta[][], vNormal[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		colors = new char[n][n]; // 입력 배열
		dy = new int[]{0, 1, 0, -1}; // 4방위
		dx = new int[]{-1, 0, 1, 0};
		
		vDolta = new boolean[n][n]; // 방문 배열
		vNormal = new boolean[n][n];
		resDolta = 0; // 구역 수 
		resNormal = 0; 
		
		for(int i = 0; i < n; i++) {
			colors[i] = br.readLine().toCharArray();
			// 새로운 배열을 만든다면
			// colors[i][j] = str.charAt(j);
			// _colors[i][j] = str.charAt(j) == 'G' ? 'R' : colors[i][j];

		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!vNormal[i][j]) {
					resNormal++;
					normal(i, j, colors[i][j]);
				}
				
				if(!vDolta[i][j]) {
					resDolta++;
					doltanism(i, j, colors[i][j]);
				}
			}
		}
		
		System.out.printf("%d %d%n", resNormal, resDolta);

		
	}
	
	// 적록 색약인 사람의 DFS
	public static void doltanism(int y, int x, char color) {
		vDolta[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int newy = y + dy[i];
			int newx = x + dx[i];
			
			// 바운더리 안에 있음 & 아직 방문하지 않았음
			if(newy >= 0 && newy < n && newx >= 0 && newx < n && !vDolta[newy][newx]) {
				// 파란색일 때
				if(color == 'B') {
					// 위 조건과 아래 조건을 같은 if문에 적으면
					// 파란색 DFS를 돌 때 빨강이나 초록을 만나면 아래 조건(else)에 해당하므로 따로 적어야함
					if(colors[newy][newx] == 'B') doltanism(newy, newx, color);
				}
				// 빨간색과 초록색일 때
				else {
					if(colors[newy][newx] == 'R' || colors[newy][newx] == 'G') {
						doltanism(newy, newx, color);
					}
				}
			}
		}
	}
	
	// 적록 색약이 아닌 사람의 DFS
	public static void normal(int y, int x, char color) {
		vNormal[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int newy = y + dy[i];
			int newx = x + dx[i];
			
			// 바운더리 안에 있음 & 아직 방문하지 않았음 & 같은 색 
			if(newy >= 0 && newy < n && newx >= 0 && newx < n && !vNormal[newy][newx]
					&& colors[newy][newx] == color) {
				normal(newy, newx, color); 
			}
		}
	}
}
