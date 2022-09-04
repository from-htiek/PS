import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.09.04
 * 아기 상어2
 * 내 코드는 왜이렇게 오래걸릴까 생각하며 다른 사람 코드를 봤더니 
 * 다들 반대로 생각해서 코드를 작성했더라 어떻게 이런 생각을 하지
 * 상어가 없을 때 q에 추가해서 넣고 돌린 나와 달리.. 상어가 있을때만 q에 넣어서 거리를 구하는 식으로 
 * 새롭다 새로워
 */
public class S2_17086 {
	public static int n, m, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로 
		m = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) continue;
				result = Math.max(result, bfs(i, j));
			}
		}
		
		System.out.println(result); 
		
		
	}
	
	public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static int bfs(int y, int x) {
		
		boolean[][] visitied = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x, 0});
		visitied[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int newcnt = cur[2] + 1;
			
			for(int d = 0; d < 8; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
	
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue;
				if(visitied[newy][newx]) continue;
				
				if(map[newy][newx] == 1) {
					return newcnt;
				}
				
				q.offer(new int[] {newy, newx, newcnt});
				visitied[newy][newx] = true; 
			}
		}
		
		return 0;
	}
}
