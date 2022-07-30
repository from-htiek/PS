import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2022.07.30
 * 미로만들기
 * 그냥 방문체크만 해도 괜찮은것같다. 근데 왜일까?
 */
public class G4_2665 {
	public static class pos{
		int y;
		int x;
		int cnt;
		
		public pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 한 줄에 들어가는 방의 수
		char[][] map = new char[n][n];
		int[][] visitied = new int[n][n]; // 방 바꾸기 최소값 기록
		
		for(int i = 0; i < n; i++) { // 방 정보 입력
			map[i] = br.readLine().toCharArray();
			Arrays.fill(visitied[i], Integer.MAX_VALUE); // 최대값으로 초기화
		}
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1}; 
		
		
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(0, 0, 0)); // 출발 지점 
		visitied[0][0] = 0;
		
		while(!q.isEmpty()) {
			pos cur = q.poll();
			
			for(int d = 0; d < 4; d++) { // 4방위 탐색 
				int newy = cur.y + dy[d];
				int newx = cur.x + dx[d];
				
				if(newy < 0 || newy >= n || newx < 0 || newx >= n) continue; // 범위 벗어나면 제외
				if(map[newy][newx] == '0') { // 검은방 일 때 
					if(cur.cnt + 1 < visitied[newy][newx]) { // 기록된 값+1 보다 작을 때만 q에 넣기 
						visitied[newy][newx] = cur.cnt + 1;
						q.offer(new pos(newy, newx, cur.cnt+1));
					}
				}else { // 흰 방일떄
					if(cur.cnt < visitied[newy][newx]) { // 기록된 값보다 작을때만 q에 넣기 
						visitied[newy][newx] = cur.cnt;
						q.offer(new pos(newy, newx, cur.cnt));
					}
				}
			}

		}

		System.out.println(visitied[n-1][n-1]);
	}
}
