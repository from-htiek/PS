import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.01
 * 말이 되고픈 원숭이
 * 생각하기 어려웠던 부분은 과연 방문체크를 어떻게 할것인가였다
 * 같은 지점에 방문하더라도, 점프해서 갔을 때와 인접한 거리로 갔을 때를 다르게 방문체크해야하는데 (점프를 언제할지모르니까)
 * 이걸 어떻게 구현해야할지 모르겠더라
 * 첫번째는 인접한 곳으로 움직일 때와 점프할때 2가지 방문배열로 체크했는데 반례가 생겼다 ㅠㅠ
 * 점프하고난 후에 인접한 배열로 움직이면.. 기존의 인접한 배열로 움직인 것들이 사라졌기때문에 
 * 결국 3차원 배열을 사용해서 점프유무에 따른 방문체크를 해줬다. 
 * 
 */
public class G4_1600 {
	static class Pos{
		int y;
		int x;
		int cnt;

		public Pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int map[][] = new int[h][w];

		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int[] dy = {0, 0, 1, -1}; // 4방위
		int[] dx = {1, -1, 0, 0};
		int[] ddy = {-2, -1, 1, 2, 2, 1, -1, -2}; // 나이트 이동 (점프)
		int[] ddx = {1, 2, 2, 1, -1, -2, -2, -1};

		// bfs 
		Queue<Pos> q = new LinkedList<>();
		int result = 0; // 동작수 최솟값
		boolean[][][] visitied = new boolean[k+1][h][w]; // 점프 횟수에 따른 방문체크
		q.offer(new Pos(0, 0, 0));


		while(!q.isEmpty()) {
			int size = q.size();
			result++;
//			System.out.println(q);
			while(size-->0) {
				Pos cur = q.poll();
//				System.out.println(cur.y + " " + cur.x + " " + cur.cnt);

				if(cur.y == h-1 && cur.x == w-1) { // 도착하면 return
					System.out.println(result-1);
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int newy = cur.y + dy[d];
					int newx = cur.x + dx[d];

					if(newy < 0 || newy >= h || newx < 0 || newx >= w) continue; // 범위 벗어나면 제외
					if(map[newy][newx] == 1) continue; // 장애물 도착 제외
					if(visitied[cur.cnt][newy][newx]) continue; // 이미 방문했다면 제외
					
					q.offer(new Pos(newy, newx, cur.cnt));
					visitied[cur.cnt][newy][newx] = true;
				}
				

				if(cur.cnt < k) { // k보다 적게 점프했을 때 
					for(int d = 0; d < 8; d++) {
						int newy = cur.y + ddy[d];
						int newx = cur.x + ddx[d];

						if(newy < 0 || newy >= h || newx < 0 || newx >= w) continue; // 범위 벗어나면 제외
						if(map[newy][newx] == 1) continue; // 장애물 도착 제외
						if(visitied[cur.cnt+1][newy][newx]) continue; // 이미 방문했다면 제외
						
						q.offer(new Pos(newy, newx, cur.cnt+1));
						visitied[cur.cnt+1][newy][newx] = true;
						
						
					}
				}

			}
//			System.out.println();

		}
		
		System.out.println(-1); // 모든 시도를 했지만 도착할 수 없다면 -1


	}
}
