import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 2022.09.24
 * 주사위 굴리기
 */
public class G4_14499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 지도 세로 크기
		int m = Integer.parseInt(st.nextToken()); // 지도 가로 크기
		int y = Integer.parseInt(st.nextToken()); // 주사위 x 좌표
		int x = Integer.parseInt(st.nextToken()); // 주사위 y 좌표
		int k = Integer.parseInt(st.nextToken()); // 명령어 개수
		
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dy = {0, 0, 0, -1, 1}; // 4방위, 0 인덱스는 쓰지 않음 
		int[] dx = {0, 1, -1, 0, 0}; 
		int[] position = {0, 1, 2, 3, 4, 5, 6}; // 주사위 위치
		int[] value = {0, 0, 0, 0, 0, 0, 0}; // 해당 위치의 값 
		st = new StringTokenizer(br.readLine());
		
		for(int kk = 0; kk < k; kk++) {
			int dir = Integer.parseInt(st.nextToken());
//			System.out.println(dir);
			int newy = y + dy[dir];
			int newx = x + dx[dir];
			
			if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 바깥으로 이동하는 명령은 무시
			if(dir == 4) {
				int tmp = position[2];
				position[2] = position[6];
				position[6] = position[5];
				position[5] = position[1];
				position[1] = tmp;
			}else if(dir == 3) {
				int tmp = position[2];
				position[2] = position[1];
				position[1] = position[5];
				position[5] = position[6];
				position[6] = tmp;
			}else if(dir == 2) {
				int tmp = position[1];
				position[1] = position[3];
				position[3] = position[6];
				position[6] = position[4];
				position[4] = tmp;
			}else {
				int tmp = position[1];
				position[1] = position[4];
				position[4] = position[6];
				position[6] = position[3];
				position[3] = tmp;
			}
			
			if(map[newy][newx] == 0) { // 0일때는 바닥에 쓰여 있는 수가 복사
				map[newy][newx] = value[position[6]]; 
			}else {
				value[position[6]] = map[newy][newx];
				map[newy][newx] = 0;
			}
			
			y = newy;
			x = newx;
			
			sb.append(value[position[1]]).append("\n");
//			System.out.println(Arrays.toString(position));
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
