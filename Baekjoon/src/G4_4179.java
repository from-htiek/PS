import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2022.04.06
 * 불!
 * 
 * 가장자리에 도착하더라도 그 자리에 불이 번진다면 탈출 할 수 없음 
 * 참고한 반례 코드 : 
 *  3 3
	###
	#J.
	#.F
	
 * ktahu2 
 * 지훈이가 범위를 벗어난다면 탈출한 것  
 */
public class G4_4179 {
	static class pos{
		int y;
		int x;
		char type; // q 하나만 쓰기 위한 타입 설정

		public pos(int y, int x, char type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		Queue<pos> q = new LinkedList<>();
		int[][] visitied = new int[r][c];

		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') q.offer(new pos(i, j, 'J')); 
				if(map[i][j] == 'F') q.offer(new pos(i, j, 'F'));
			}
		}


		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};

		while(!q.isEmpty()) {
			pos cur = q.poll();
			
			 // 가장자리 도착했고, 아직 불이 번지지 않았다면 도착 
			if((cur.y == 0 || cur.y == r-1 || cur.x == 0 || cur.x == c-1) && cur.type == 'J' && map[cur.y][cur.x] != 'F') {
				System.out.println(visitied[cur.y][cur.x] + 1);
				return; 
			}
			
			for(int d = 0; d < 4; d++) {
				int newy = cur.y + dy[d];
				int newx = cur.x + dx[d];
				
				if(newy < 0 || newy >=r || newx < 0 || newx >= c) continue; // 범위 벗어나면 제외
				if(map[newy][newx] == '#') continue; // 벽은 통과할 수 없으므로 제외
				if(map[newy][newx] == 'F') continue; // 불이 났다면 제외 

				if(cur.type == 'J') {
					if(visitied[newy][newx] != 0) continue; // 이미 방문했다면 제외
					q.offer(new pos(newy, newx, 'J'));
					visitied[newy][newx] = visitied[cur.y][cur.x] + 1;
//					System.out.println("J : " + newy + "  " + newx);

				}else { // type == 'F'
					map[newy][newx] = 'F';
					q.offer(new pos(newy, newx, 'F'));
//					System.out.println("F : " +newy + "  " + newx);
				}
			}
			
/*			for(char[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			System.out.println();*/

		}

		System.out.println("IMPOSSIBLE"); // 탈출 할 수 없으면 IMPOSSIBLE 출력


	}
}
