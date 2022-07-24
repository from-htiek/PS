import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.07.24
 * 바닥 장식
 */
public class S3_1388 {
	static int n, m;
	static char[][] floor;
	static boolean[][] visitied;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 방 바닥 세로 크기
		m = Integer.parseInt(st.nextToken()); // 방 바닥 가로 크기
		
		floor = new char[n][m];
		visitied = new boolean[n][m]; // 방문체크를 위한 배열
		
		for(int i = 0; i< n; i++) {
			floor[i] = br.readLine().toCharArray();
		}

		
		int cnt = 0; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visitied[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
 
	}
	
	public static void bfs(int y, int x) {
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {y, x}); 
		visitied[y][x] = true; 
		char shape = floor[y][x]; // 바닥 모양
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				if(shape == '-') { // '-' 모양은 같은 행일때만 같은 나무 판자
					if(d == 0) continue;
					if(d == 1) continue;
				}
				
				if(shape == '|') { // '|' 모양은 같은 열일때만 같은 나무 판자
					if(d == 2) continue;
					if(d == 3) continue;
				}
				
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				if(shape != floor[newy][newx]) continue; // 모양이 다르다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true;
				
			}
		}
		
		
	}
}
