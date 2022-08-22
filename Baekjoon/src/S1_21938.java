import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.08.22
 * 영상처리
 */
public class S1_21938 {
	static int n, m, map[][], t;
	static boolean visitied[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 화면 세로
		m = Integer.parseInt(st.nextToken()); // 화면 가로
		
		map = new int[n][m]; // 픽셀 배열 
		visitied = new boolean[n][m]; // 방문 체크 배열

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int num = 0; 
				for(int k = 0; k < 3; k++) { // 3픽셀의 합의 값 저장
					num += Integer.parseInt(st.nextToken());
				}
				map[i][j] = num;
			}
		}
		
		t = Integer.parseInt(br.readLine()) * 3; // 픽셀 평균 구하는 대신 경계값 * 3
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visitied[i][j] && map[i][j] >= t) { // 아직 방문하지 않았고 경계값 보다 클때만 방문
					result++;
					bfs(i, j);
				}
			}
		}	
		
		System.out.println(result);
	}
	
	public static int[] dy = {1, -1, 0, 0};
	public static int[] dx = {0, 0, 1, -1};
	
	public static void bfs(int y, int x) {
		visitied[y][x] = true; 
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) { // 4방위
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				if(map[newy][newx] < t) continue; // 경계값 보다 작다면 제외
				
				visitied[newy][newx] = true; 
				q.offer(new int[] {newy, newx});
			}
			
		}
	}
}
