import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.06.15
 * 점프왕 쩰리(Small)
 * 
 * 문제를 오해해서 생각보다 시간이 오래걸렸던 문제.
 * 게임판위의 숫자만큼 움직일 때, 가로 세로 모두 숫자만큼을 곱해서 점프한다고 생각하지 못하고
 * 숫자만큼 오른쪽/밑쪽 방향으로 랜덤하게 움직일 수 있다고 생각해서 너무 어렵다고 생각했는데 아니였다.
 * 문제를 잘 읽자...........
 */
public class S5_16173 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 게임 구역 크기 
		
		int[][] map = new int[n][n]; // 게임판 
		boolean[][] visitied = new boolean[n][n]; // 방문 체크 배열 
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dy = {1, 0};
		int[] dx = {0, 1}; 
		Queue<int[]> q = new LinkedList<>(); // bfs
		q.offer(new int[] {0, 0});
		visitied[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == n-1 && cur[1] == n-1) { // 도착점에 도착 
				System.out.println("HaruHaru");
				return;
			}
			
			for(int d = 0; d < 2; d++) { // 2방향으로 체크
				int newy = cur[0] + dy[d] * map[cur[0]][cur[1]]; // 게임판의 숫자만큼 x, y 점프
				int newx = cur[1] + dx[d] * map[cur[0]][cur[1]];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 범어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				
				q.offer(new int[] {newy, newx});
				visitied[newy][newx] = true; 
			}
		}
		
		System.out.println("Hing");
		
	}

}
