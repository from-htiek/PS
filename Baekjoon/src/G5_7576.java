import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.02.25
 * 토마토
 * 
 * 다른 토마토랑 섞어짜다보니 코드가 굉장히 지저분함
 * 
 */
public class G5_7576 {
	static int m, n, h, tomato[][], visitied[][], result;
	static Queue<int[]> q ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomato = new int[n][m];
		visitied = new int[n][m]; // 방문체크 & 날짜
		q = new LinkedList<>();
		int check = 0; // // 익지 않은 토마토가 있는지 체크
		result = 0;
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				
				if(tomato[i][j] == 0) {
					check++;
				}else if(tomato[i][j] == -1) {
					visitied[i][j] = -1;
				}
			}
		}
		
		
		if(check == 0) { // 익지 않은 토마토가 하나도 없으면 종료
			System.out.println(0);
			System.exit(0);
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] == 1) {
					q.offer(new int[]{i, j});
					visitied[i][j] = 1; 
				}
			}
		}
		
		bfs();
		
		result -= 1; // 첫째날도 하루로 셌으므로 1 빼주기 

		outerloop : for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visitied[i][j] == 0) {
					result = -1;
					break outerloop;
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(visitied));
		System.out.println(result);
		
		
	}
	
	public static void bfs() {
		int[] dy = new int[]{1, -1, 0, 0}; // 4 방위
		int[] dx = new int[]{0, 0, 1, -1};
		
		//q.offer(new int[]{y, x});
		//visitied[y][x] = 1; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int newy = cur[0] + dy[i];
				int newx = cur[1] + dx[i];
				
				// 바운더리 안에 있음 & 방문하지 않음 & 아직 익지않은 토마토
				if(newy >= 0 && newy < n && newx >= 0 && newx < m && visitied[newy][newx] == 0
						&& tomato[newy][newx] == 0) {
					visitied[newy][newx] = visitied[cur[0]][cur[1]] + 1;
					result = Math.max(visitied[newy][newx], result);
					q.offer(new int[] {newy, newx});
				}
			}
		}
	}
}
