import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.03.12
 * 로봇 청소기
 */
public class G5_14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int cleaner_y = Integer.parseInt(st.nextToken()); // 로봇 청소기 위치
		int cleaner_x = Integer.parseInt(st.nextToken()); 
		int cleaner_dir = Integer.parseInt(st.nextToken()); // 로봇 청소기 방향 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[] dy = {-1, 0, 1, 0}; // 0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽 
		int[] dx = {0, 1, 0, -1};
		
		
		boolean flag = false; 
		int cnt = 1; // 시작점 포함 
		map[cleaner_y][cleaner_x] = -1; // 지나간 곳 표시
		
		
		while(!flag) {
			int dir; 
			for(dir = 0; dir < 4; dir++) { // 청소기 방향 정하기 
				cleaner_dir = (cleaner_dir+3)%4; // -90도씩 확인 
				
				int newy = cleaner_y + dy[cleaner_dir];
				int newx = cleaner_x + dx[cleaner_dir]; 
				
				if(map[newy][newx] == 1 || map[newy][newx] == -1) continue; // 벽이거나, 이미 청소한 곳이면 제외
				
				
				map[newy][newx] = -1; // 청소
				cnt++; 
				cleaner_y = newy; // 현재 청소기 위치 갱신
				cleaner_x = newx;
//				System.out.println(cleaner_y + ", " + cleaner_x);
				dir = 0; 
				break;
				
			}
			
			
			// 네 방향 모두 청소가 되어 있거나 벽인 경우, 한칸 후진 
			if(dir == 4) {
				cleaner_y = cleaner_y + dy[(cleaner_dir+2)%4];
				cleaner_x = cleaner_x + dx[(cleaner_dir+2)%4];
				
				// 뒤쪽 방향이 벽이라 후진도 할 수 없다면 멈춤
				if(map[cleaner_y][cleaner_x] == 1) {
					flag = true; 
				}
			}
				
		
		}
		System.out.println(cnt);
	
	}
}
