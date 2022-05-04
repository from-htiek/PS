import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.05.04
 * 그림
 */
public class S1_1926 {
	static int n, m, paper[][], count, area;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static boolean[][] visitied;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도화지 세로 크기
		m = Integer.parseInt(st.nextToken()); // 도화지 가로 크기
		
		paper = new int[n][m];  // 도화지
		visitied = new boolean[n][m]; // 방문체크 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 0; // 그림의 개수
		area = 0; // 가장 넓은 그림의 넓이
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visitied[i][j] && paper[i][j] == 1) { // 방문하지 않았고, 그림이 있다면 bfs로 체크 
					count++; 
					bfs(i, j);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(area);
	}
	
	public static void bfs(int y, int x) {
		
		int cnt = 1; 
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		visitied[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) { // 4방위 탐색 
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(paper[newy][newx] == 0) continue; // 그림이 아니면 제외
				if(visitied[newy][newx]) continue; // 방문했다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true;
				cnt++; // 그림 넓이 + 1 
				
			}
		}
		
		area = Math.max(cnt, area);
		
	}
}
