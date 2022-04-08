import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.08
 * 치즈 도둑
 */
public class D4_7733 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine()); // 치즈 한 변의 길이 
			int[][] cheese = new int[n][n];
			int days = 0; // 날짜
			int result = 0; // 치즈 덩어리가 가장 많을 때의 개수
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					days = Math.max(days, cheese[i][j]);
				}
			}
			
			int[] dy = {1, -1, 0, 0};
			int[] dx = {0, 0, 1, -1}; 
			
			for(int day = 0; day < days; day++) { // 1일부터 days-1일 까지 반복 
				int cnt = 0;
				boolean[][] visitied = new boolean[n][n];
				
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(cheese[i][j] > day && !visitied[i][j]) { // 치즈가 남아있고 아직 방문하지 않았을 때
							cnt++; 
							
							// bfs 
							Queue<int[]> q = new LinkedList<>();
							q.offer(new int[] {i, j});
							visitied[i][j] = true; 
							
							while(!q.isEmpty()) {
								int[] cur = q.poll();
								
								for(int d = 0; d < 4; d++) {
									int newy = cur[0] + dy[d];
									int newx = cur[1] + dx[d];
									
									if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
									if(cheese[newy][newx] <= day) continue; // 치즈가 남아있지 않다면 제외
									if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
									
									q.offer(new int[] {newy, newx});
									visitied[newy][newx] = true; 
									
								}
							}
							
						}
					}
				}
				
//				System.out.println("cnt : " + cnt);
				result = Math.max(cnt, result);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
}
