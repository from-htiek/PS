import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2022.12.08
 * 경쟁적 전염
 * cnt를 넣어서 우선순위를 바꿨는데, 다른 분들 코드를 보다보니.. map[i][j] < map[newy][newx]를 넣어서
 * 크면 번식을 막아주면 훨씬 더 빠르지 않았을까 싶다! 
 */
public class G5_18405 {
	public static class virus implements Comparable<virus>{
		int y; // y좌표
		int x; // x좌표
		int type; // 바이러스 종류
		int cnt; // 시간이 얼마나 지났는지 
		
		public virus(int y, int x, int type, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.type = type;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(virus o) {
			if(this.cnt == o.cnt) {
				return Integer.compare(this.type, o.type);
			}
			
			return Integer.compare(this.cnt, o.cnt);
		}

		@Override
		public String toString() {
			return "virus [y=" + y + ", x=" + x + ", type=" + type + ", cnt=" + cnt + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 시험관 크기
		int k = Integer.parseInt(st.nextToken()); // 바이러스 종류
		
		PriorityQueue<virus> pq = new PriorityQueue<>();
		int[][] map = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) pq.add(new virus(i, j, map[i][j], 0));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()); // s초 뒤
		int resulty = Integer.parseInt(st.nextToken()); // 정답 y 위치
		int resultx = Integer.parseInt(st.nextToken()); // 정답 x 위치
		
		int[] dy = {1, -1, 0, 0}; 
		int[] dx = {0, 0, 1, -1};
		
		for(int i = 0; i < s; i++) { // s초만큼 반복
			int size = pq.size();
			while(size -- > 0) {
				virus cur = pq.poll();
				
				for(int d = 0; d < 4; d++) { // 4방위 탐색
					int newy = cur.y + dy[d];
					int newx = cur.x + dx[d];
					
					if(newy <= 0 || newy > n || newx <= 0 || newx > n) continue; 
					if(map[newy][newx] != 0 ) continue;
					
					map[newy][newx] = cur.type;
					pq.offer(new virus(newy, newx, cur.type, cur.cnt+1));
				}
			}
		}
		
		System.out.println(map[resulty][resultx]);
		
	}
}
