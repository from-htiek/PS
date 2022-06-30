import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.06.30
 * 헌내기는 친구가 필요해
 */
public class S2_21736 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		int cury = 0;
		int curx = 0; 
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'I') { // 도연이 위치 
					cury = i;
					curx = j; 
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visitied = new boolean[n][m]; // 방문 체크 배열 
		
		q.offer(new int[] {cury, curx}); // 도연이 위치부터 시작 
		visitied[cury][curx] = true; 
		
		int result = 0; // 도연이가 만난 사람
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1}; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]] == 'P') {
				result++; 
			}
			
			for(int d = 0; d < 4; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= m) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외 
				if(map[newy][newx] == 'X') continue; // 벽을 만났다면 제외 
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true; 
			}
		}
		
		
		if(result > 0) System.out.println(result);
		else System.out.println("TT");
		
	}
}
