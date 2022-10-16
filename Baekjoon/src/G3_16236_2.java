import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.10.15
 * 아기상어
 * 먹을 수 있는 물고기 리스트를 pq에 넣어서 다 계산했지만 생각해보면.. 이 과정이 없어도 되지 않았을까 싶다 
 * 결국 아기상어가 bfs로 움직이면서 가장 먼저 만난 물고기 중에 가장 위에 있고 가장 왼쪽에 있는 물고기가 지금 먹을 수 있는 물고기니까
 * fish를 compareTo를 y, x로만 비교하고 
 * bfs를 상어 위치에서 돌면서 q의 size-- > 0로 while문을 돌면서 먹을 수 있는 물고기 리스트를 계속 비교했다면 
 * 훨씬 빠르지않았을까
 */
public class G3_16236_2 {
	public static class Fish implements Comparable<Fish>{
		int y;
		int x;
		int distance;
		
		public Fish(int y, int x, int distance) {
			super();
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.distance == o.distance) {
				if(this.y == o.y) {
					return this.x - o.x;
				}else {
					return this.y - o.y;
				}
			}
			
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "Fish [y=" + y + ", x=" + x + ", distance=" + distance + "]";
		}

	}
	
	public static class Shark {
		int y;
		int x;
		int size;
		int cnt;
		
		public Shark(int y, int x, int size, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Shark [y=" + y + ", x=" + x + ", size=" + size + ", cnt=" + cnt + "]";
		}	
	}
	
	public static Shark shark;
	public static int n, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		n = Integer.parseInt(br.readLine()); // 공간 크기 
		
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) { // 아기 상어 초기화
					map[i][j] = 0; 
					shark = new Shark(i, j, 2, 0); 
				}
			}
		}
		
		int result = 0; 

		while(true) { // 먹을 수 있는 물고기가 있을 때 까지 반복
			PriorityQueue<Fish> pq = new PriorityQueue<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 0) continue; // 물고기가 없는 곳은 제외
					if(map[i][j] >= shark.size) continue; // 더 큰 물고기는 제외
					
					int distance = bfs(i, j); // 거리 계산
					
					if(distance != -1) pq.offer(new Fish(i, j, distance)); // 먹을 수 있는 물고기라면 q에 넣기
					
				}
			}

			if(pq.isEmpty()) break; // 더 이상 먹을 수 있는 물고기가 없다면 멈춤
			
			Fish fish = pq.poll(); // 상어가 잡아 먹을 물고기
			map[fish.y][fish.x] = 0; 
			shark.y = fish.y;
			shark.x = fish.x;
			shark.cnt++;
			
			if(shark.cnt == shark.size) {  // 크기 만큼 물고기 잡아 먹었다면 커짐
				shark.cnt = 0;
				shark.size++; 
			}
			
			result += fish.distance;
		
		}
		
		System.out.println(result);
		
	}
	
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dx = {1, 0, -1, 0};
	public static int bfs(int y, int x) {
		
		boolean[][] visitied = new boolean[n][n];
		visitied[shark.y][shark.x] = true;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {shark.y, shark.x, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int newy = cur[0] + dy[d];
				int newx = cur[1] + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(visitied[newy][newx]) continue; // 이미 방문했다면 제외
				if(map[newy][newx] > shark.size) continue; // 물고기가 더 커서 지나갈 수 없다면 제외
				
				if(newy == y && newx == x) { // 도착하면 끝
					return cur[2]+1;
				}
				
				q.offer(new int[] {newy, newx, cur[2]+1});
				visitied[newy][newx] = true; 
			}
		}
		
		return -1; // 해당 물고기 자리에 도착할 수 없다면 -1 리턴
	}
}
