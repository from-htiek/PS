import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.11.07
 * 상범 빌딩
 */
public class G5_6593 {
	public static class pos{
		int z;
		int y;
		int x;
		int cnt;
		
		public pos(int z, int y, int x, int cnt) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); // 층 수
			int r = Integer.parseInt(st.nextToken()); // 행
			int c = Integer.parseInt(st.nextToken()); // 열
		
			if(l == 0 && r == 0 && c == 0) break; // 입력 끝 
			
			char[][][] map = new char[l][r][c]; // 상범 빌딩
			pos start = null; 
			
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++){
					String input = br.readLine();
					for(int k = 0; k < c; k++) {
						map[i][j][k] = input.charAt(k);
						if(map[i][j][k] == 'S') { // 시작점
							start = new pos(i, j, k, 0);
						}
					}
				}
				
				br.readLine();
			}
			
//			for(char[][] ma : map) {
//				for(char[] m : ma) {
//					System.out.println(Arrays.toString(m));
//				}
//			}
			
			int[] dy = {1, -1, 0, 0, 0, 0}; // 인접한 6개의 칸 이동
			int[] dx = {0, 0, 1, -1, 0, 0};
			int[] dz = {0, 0, 0, 0, 1, -1};
			
			boolean[][][] visitied = new boolean[l][r][c]; // 방문체크
			Queue<pos> q = new LinkedList<>();
			q.offer(start);
			visitied[start.z][start.y][start.x] = true;
			
			boolean flag = false; 
			while(!q.isEmpty()) {
				pos cur = q.poll();
				
				if(map[cur.z][cur.y][cur.x] == 'E') { // 도착했다면 끝
					System.out.println("Escaped in " + cur.cnt + " minute(s).");
					flag = true; 
					break; 
				}
				
				for(int d = 0; d < 6; d++) {
					int newz = cur.z + dz[d];
					int newy = cur.y + dy[d];
					int newx = cur.x + dx[d];
					
					if(newz < 0 || newz >= l || newy < 0 || newy >= r || newx < 0 || newx >= c) continue;
					if(visitied[newz][newy][newx]) continue;
					if(map[newz][newy][newx] == '#') continue;

					q.offer(new pos(newz, newy, newx, cur.cnt+1));
					visitied[newz][newy][newx] = true; 
 				}
			}
			
			if(!flag) System.out.println("Trapped!");
			
		}
		
		
	}
}
