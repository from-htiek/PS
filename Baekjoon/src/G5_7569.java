import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * 2022.02.25
 * 토마토
 * 3차원을 2차원으로 바꿔서 풀었더니 오류남 => 왜일까? 
 */
public class G5_7569 {
	static int m, n, h, tomato[][], visitied[][], result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 상자 가로 크기
		n = Integer.parseInt(st.nextToken()); // 상자 세로 크기
		h = Integer.parseInt(st.nextToken()); // 상자 수 
		
		tomato = new int[n*h][m];
		visitied = new int[n*h][m]; // 방문체크		
		int check = 0; // 익지 않은 토마토가 있는지 체크
		result = 0; // 결과
		
		for(int i = 0; i < n*h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken()); // 1 : 익은 토마토, 0 : 익지 X 토마토, -1 : 없음
				
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

		for(int i = 0; i < n*h; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] == 1) bfs(i,j);
			}
		}
		
		result -= 1; // 첫째날도 하루로 셌으므로 1 빼주기 

		outerloop : for(int i = 0; i < n*h; i++) {
			for(int j = 0; j < m; j++) {
				if(visitied[i][j] == 0) {
					result = -1;
					break outerloop;
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void bfs(int y, int x) {
		int[] dy = new int[]{1, -1, 0, 0, n, -n}; // 6 방위
		int[] dx = new int[]{0, 0, 1, -1, 0, 0};
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{y, x});
		visitied[y][x] = 1; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 6; i++) {
				int newy = cur[0] + dy[i];
				int newx = cur[1] + dx[i];
				
				// 바운더리 안에 있음 & 방문하지 않음 & 아직 익지않은 토마토
				if(newy >= 0 && newy < n*h && newx >= 0 && newx < m && visitied[newy][newx] == 0
						&& tomato[newy][newx] == 0) {
					visitied[newy][newx] = visitied[cur[0]][cur[1]] + 1;
					result = Math.max(visitied[newy][newx], result);
					q.offer(new int[] {newy, newx});
				}
			}
		}
		
		
	}
}
