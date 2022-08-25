import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.08.26
 * 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유
 */
public class S1_17129 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정보섬 2층 세로 길이
		int m = Integer.parseInt(st.nextToken()); // 정보섬 2층 가로 길이
		
		int starty = -1; // 윌리암슨수액빨이딱따구리 위치 
		int startx = -1; 
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String string = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = string.charAt(j) - '0';
				if(map[i][j] == 2) {
					starty = i;
					startx = j;
				}
			}
		}
		
		int[] dy = {1, -1, 0, 0}; // 4방위 탐색
		int[] dx = {0, 0, 1, -1};
		
		int[][] visitied = new int[n][m]; // 방문 체크 배열
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {starty, startx}); // 시작점 
		visitied[starty][startx] = 1; // 판별을 위해 1로 설정
		
		// bfs 
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int pos = map[cur[0]][cur[1]];
			if(pos == 3 || pos == 4 || pos == 5) { // 어떤 음식이든 도착했다면 끝
				System.out.println("TAK");
				System.out.println(visitied[cur[0]][cur[1]] - 1);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx] != 0) continue; // 이미 방문했다면 제외
				if(map[newy][newx] == 1) continue; // 장애물 있다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = visitied[cur[0]][cur[1]] + 1; 
			}
		}
		
		System.out.println("NIE");

	}
}
