import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2022.04.07
 * 보급로
 */
public class D4_1249 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[][] visitied = new int[n][n];

			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
					visitied[i][j] = Integer.MAX_VALUE;
				}
			}

			// 입력 확인 
			//for(int[] m : map) {
			//	System.out.println(Arrays.toString(m));
			//}

			// bfs 
			int[] dy = {1, -1, 0, 0};
			int[] dx = {0, 0, 1, -1}; 
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {0, 0}); // 출발점 
			visitied[0][0] = 0;

			while(!q.isEmpty()) {
				int[] cur = q.poll();

				for(int d = 0; d < 4; d++) { // 4방위 탐색
					int newy = cur[0] + dy[d];
					int newx = cur[1] + dx[d];

					if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue;

					if(visitied[newy][newx] > visitied[cur[0]][cur[1]] + map[newy][newx]) {
						visitied[newy][newx] = visitied[cur[0]][cur[1]] + map[newy][newx];
						q.offer(new int[] {newy, newx});
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(visitied[n-1][n-1]).append("\n");

		}
		
		System.out.println(sb.toString());
	}
}
