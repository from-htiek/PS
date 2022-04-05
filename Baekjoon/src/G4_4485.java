import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 2022.04.03 -> 2022.04.05
 * 녹색 옷 입은 애가 젤다지? 
 * 
 * 처음에 풀 때는 visitied를 max값으로 채워주지 않았음 
 * 그래서 아직 계산하지 않아 0인 값과, 연속으로 0이 들어와 계산해서 0이 나온값이 구분이 안됐기때문에
 * 입력으로 0의 값이 연속으로 들어오면 무한루프를 돌았었는데
 * 다른 사람들의 코드를 참고해서 저 부분을 수정하니까 잘 돌아갔다 .. 
 * (기존의 내 코드는 if(visitied[newy][newx] != 0) 라고 적은 부분이 있었음 ^_^...)  
 * 아이디어에서 나온 코드 한줄이 이렇게 중요하다 ㅠ 
 * 나중에 다시 풀어보면 좋겠다
 */
public class G4_4485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1; 
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break; // 입력 0이 들어오면 멈춤 
			
			int[][] map = new int[n][n];
			int[][] visitied = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visitied[i][j] = Integer.MAX_VALUE; // 최대값으로 채우기 
				}
			}

			int[] dy = {0, 0, 1, -1}; 
			int[] dx = {1, -1, 0, 0};
			
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {0, 0});
			visitied[0][0] = map[0][0];
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for(int d = 0; d < 4; d++) { // 4방위 탐색
					int newy = cur[0] + dy[d];
					int newx = cur[1] + dx[d];
					
					if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
					
					if(visitied[newy][newx] > visitied[cur[0]][cur[1]] + map[newy][newx]) { // 지금 위치에서 계산한 값이 더 작다면
						visitied[newy][newx] = visitied[cur[0]][cur[1]] + map[newy][newx]; // 갱신
						q.offer(new int[] {newy, newx}); 
						
					}

				}
								
				for(int[] v : visitied) {
					System.out.println(Arrays.toString(v));
				}
				System.out.println();
				
			}
			
			sb.append("Problem ").append(tc++).append(": ").append(visitied[n-1][n-1]).append("\n");		
			
		}
		
		System.out.println(sb.toString());
	}
}
