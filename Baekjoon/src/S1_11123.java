import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.08.04
 * 양 한마리... 양 두마리...
 */
public class S1_11123 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[h][w]; // 입력
			for(int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			
			boolean[][] visitied = new boolean[h][w];
			Queue<int[]> q = new LinkedList<>();
			int cnt = 0; 
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j< w; j++) {
					if(!visitied[i][j] && map[i][j] == '#') { // 아직 방문하지 않았고, 양이 있으면 무리 세기
						cnt++;  // 무리 수 카운트
						 
						q.offer(new int[] {i, j}); // bfs 
						visitied[i][j] = true; 
						
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							
							for(int d = 0; d < 4; d++) {
								int newy = cur[0] + dy[d];
								int newx = cur[1] + dx[d];
								
								if(newy < 0 || newy >= h || newx < 0 || newx >= w) continue; // 범위 벗어나면 제외
								if(visitied[newy][newx]) continue; // 이미 체크한 양이면 제외
								if(map[newy][newx] == '.') continue; // 양이 아니면 제외
								
								q.offer(new int[] {newy, newx});
								visitied[newy][newx] = true; 
							}
						}
					}
				}
			}
			
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}
