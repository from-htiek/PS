import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.01
 * 탈출
 * X 대신 K를 쓴 걸 못찾고 한참 고생했다.........ㅠ
 * class position을 하나 만들어 고슴도치일때와 물일때 비버굴일때를 표시했다면
 * 큐를 하나만 써도 될 듯함! 
 */
public class G4_3055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		int[] waterPos = null;
		int[] hedgePos = null;
		int[] beaverPos = null;
		Queue<int[]> water = new LinkedList<>();
		Queue<int[]> hedge = new LinkedList<>();
		
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D') beaverPos = new int[] {i, j};
				if(map[i][j] == 'S') hedgePos = new int[] {i, j};
				if(map[i][j] == '*') {
					waterPos = new int[] {i, j};
					water.offer(waterPos);
				}
			}
		}

		int[] dy = {1, -1, 0, 0}; // 4방위
		int[] dx = {0, 0, 1, -1};
		int visitied[][] = new int[r][c];

		water.offer(waterPos);
		hedge.offer(hedgePos);
		visitied[hedgePos[0]][hedgePos[1]] = 1; 

		while(true) { // 고슴도치가 도착하거나, 물이 다 찰때까지 반복 

			
			if(waterPos != null) {
				int waterSize = water.size();
				while(waterSize-->0) {
					int[] cur = water.poll();
					for(int d = 0; d < 4; d++){
						int newy = cur[0] + dy[d];
						int newx = cur[1] + dx[d];

						if(newy < 0 || newy >= r || newx < 0 || newx >= c) continue;  // 범위 벗어나면 제외 
						if(map[newy][newx] ==  'D' || map[newy][newx] == '*' || map[newy][newx] == 'X') continue; // 물이 차지 못하는 곳 제외

						map[newy][newx] = '*';
						water.offer(new int[] {newy, newx});

					}
				}
			}
			
			
/*			for(char[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			System.out.println();
*/
			int hedgeSize = hedge.size();

			if(hedgeSize == 0) {
				System.out.println("KAKTUS");
				return;
			}

			while(hedgeSize-->0) {
				int[] cur = hedge.poll();

				for(int d = 0; d < 4; d++){
					int newy = cur[0] + dy[d];
					int newx = cur[1] + dx[d];

					if(newy < 0 || newy >= r || newx < 0 || newx >= c) continue;  // 범위 벗어나면 제외
					if(visitied[newy][newx] != 0) continue; // 이미 방문했다면 제외
					if(map[newy][newx] == '*' || map[newy][newx] == 'X') continue;// 갈 수 없는 곳이면 제외

					hedge.offer(new int[] {newy, newx});
					visitied[newy][newx] = visitied[cur[0]][cur[1]] + 1;
//					System.out.println(newy + " " + newx);

					if(newy == beaverPos[0] && newx == beaverPos[1]) { // 비버집 도착했다면 출력
						System.out.println(visitied[newy][newx]-1);
						return; 
					}
				}
			}
		}

	}
}

